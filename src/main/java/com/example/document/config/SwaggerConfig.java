package com.example.document.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI documentQASystemOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Document Q&A API")
                        .description("APIs for document ingestion, filtering, and Q&A")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Your Name")
                                .email("you@example.com")
                                .url("https://your-site.com")
                        )
                );
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/api/**")
                .build();
    }
}
