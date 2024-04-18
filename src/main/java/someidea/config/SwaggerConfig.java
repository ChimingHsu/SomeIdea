package someidea.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;


@OpenAPIDefinition
@Configuration
public class SwaggerConfig {
	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("public-apis")
				.pathsToMatch("/**")
				.build();
	}
	
	@Bean
	public OpenAPI custOpenApi() {
		final String securitySchemeName = "bearerAuth";
		return new OpenAPI()        
				.addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
		        .components(
		                new Components()
		                        .addSecuritySchemes(securitySchemeName,
		                                new SecurityScheme()
		                                        .name(securitySchemeName)
		                                        .type(SecurityScheme.Type.HTTP)
		                                        .scheme("bearer")
		                                        .bearerFormat("JWT")
		                        )
		        )
				.info(new Info().title("Some Idea API Document").version("1.0.0"));
	}
}