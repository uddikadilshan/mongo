package com.uddika.mongo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API Doc - [ Mongo Test App]")
                        .description("API Documentation © Uddika")
                        .version("v0.0.1").contact(buildContact())
                        .license(new License().name("Uddika").url("https://uddika.lk")));
    }

    private Contact buildContact() {
        Contact contact = new Contact();
        contact.name("Uddika");
        contact.email("uddika0296@gmail.com");
        contact.url("https://uddika.lk");
        return contact;
    }
}
