package br.com.erick.lara.adapter.configuration;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title="Customer API",
                version = "1.0.1",
                description = "Customer Microservice with Quarkus",
                contact = @Contact(
                        name = "Erick Lara",
                        url = "http://linkedin.com/in/erick-gm-lara",
                        email = "egmlara81@gmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class SwaggerConfiguration extends Application {}