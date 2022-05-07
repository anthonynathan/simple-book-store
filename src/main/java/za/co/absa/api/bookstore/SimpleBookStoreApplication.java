package za.co.absa.api.bookstore;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Simple Book Store",
                                description = "Simple interface to place and retrieve online book orders",
                                version = "0.0.1",
                                contact = @Contact(name = "Anthony Nathan", email = "anthonynathan64@gmail.com")))
public class SimpleBookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleBookStoreApplication.class, args);
    }

}
