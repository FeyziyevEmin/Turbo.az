package az.hamburg.it.turbo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class DocumentationConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("turbo.az")
                        .version("0.0.1")
                        .description("masin almaq ve satmaq ucun yazdigim proyekt")
                        .contact(
                                new Contact()
                                        .name("Emin")
                                        .email("feyziyevemin2006@gmail.com")

                        )
        );

    }
}
