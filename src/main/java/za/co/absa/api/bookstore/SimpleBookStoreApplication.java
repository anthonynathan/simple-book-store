package za.co.absa.api.bookstore;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleBookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleBookStoreApplication.class, args);
    }

}
