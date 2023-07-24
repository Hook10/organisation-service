package com.hook.organisation;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(
        info = @Info(
                title = "Organization Service REST APIs",
                description = "Organization Service REST APIs Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Hook Ten",
                        email = "some@email.com",
                        url = "someurl.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "someurl.com/license"
                )
        ),
        externalDocs =  @ExternalDocumentation(
                description = "Organization Service Doc",
                url = "someurl.com"
        )
)
@SpringBootApplication
public class OrganisationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrganisationServiceApplication.class, args);
  }

}
