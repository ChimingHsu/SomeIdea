package someidea.auth.bean;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import someidea.auth.service.CustomUserDetailsService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
    private JwtTokenProvider jwtTokenProvider;

	@Autowired
    private CustomUserDetailsService userDetailsService;
	

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = getTokenFromRequest(request);
        
        LoggerFactory.getLogger(JwtAuthenticationFilter.class).info("token: "+token);
        
        if(StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)){

            String userNo = jwtTokenProvider.getUserNo(token);

            LoggerFactory.getLogger(JwtAuthenticationFilter.class).info("userNo: "+userNo);
            
            UserDetails userDetails = userDetailsService.loadUserByUsername(userNo);

            LoggerFactory.getLogger(JwtAuthenticationFilter.class).info("getUsername: "+userDetails.getUsername());
            LoggerFactory.getLogger(JwtAuthenticationFilter.class).info("getPassword: "+userDetails.getPassword());
            LoggerFactory.getLogger(JwtAuthenticationFilter.class).info("getAuthorities: "+userDetails.getAuthorities());
            
            
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails.getUsername(),
                userDetails.getPassword(),
                userDetails.getAuthorities()
            );
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request){

        String bearerToken = request.getHeader("Authorization");

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, bearerToken.length());
        }

        return null;
    }


}