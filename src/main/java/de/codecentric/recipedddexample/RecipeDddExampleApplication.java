package de.codecentric.recipedddexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"de.codecentric.*"})
public class RecipeDddExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeDddExampleApplication.class, args);
    }

}
