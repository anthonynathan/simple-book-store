package za.co.absa.api.bookstore.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(info = @Info(title = "Simple Book Store",
                                description = "Simple interface to place and retrieve online book orders",
                                version = "0.0.1",
                                contact = @Contact(name = "Anthony Nathan", email = "anthonynathan64@gmail.com")))
@SecurityScheme(name = "code", type = SecuritySchemeType.OAUTH2,
                flows = @OAuthFlows(
                        authorizationCode = @OAuthFlow(
                                authorizationUrl = "${springdoc.oAuthFlow.authorizationUrl}",
                                tokenUrl = "${springdoc.oAuthFlow.tokenUrl}")))
public class OpenApiConfig {
}
