package someidea.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import someidea.auth.bean.JwtAuthenticationEntryPoint;
import someidea.auth.bean.JwtAuthenticationFilter;
import someidea.auth.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private JwtAuthenticationFilter authenticationFilter;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(
				authorize -> authorize
				.requestMatchers("/auth/**").permitAll()
				.requestMatchers("/user/create/**").permitAll()
				.requestMatchers("/swagger-ui/**").permitAll()
//				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
//				.requestMatchers("/user/**").hasRole("USER")
				.requestMatchers("/user/**").hasAnyAuthority("USER")
				.anyRequest().authenticated())
		.formLogin(
				form -> form
				.loginPage("/login")
				.loginProcessingUrl("/login")
//				.defaultSuccessUrl("/users")
				.permitAll())
		.logout(
				logout -> logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.permitAll())
		.exceptionHandling(
				exception -> exception
				.authenticationEntryPoint(authenticationEntryPoint))
		.sessionManagement(
				session -> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		http.authenticationProvider(authenticationProvider());
		http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}


}