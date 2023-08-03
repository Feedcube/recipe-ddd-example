package de.codecentric.recipedddexample;

import de.codecentric.recipedddexample.recipe.adapter.out.persistence.model.RecipeJdbc;
import de.codecentric.recipedddexample.recipe.domain.model.Recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;

import java.util.Arrays;
import java.util.UUID;

@EnableJdbcRepositories(basePackages = "de.codecentric.recipedddexample.*")
@SpringBootApplication(scanBasePackages = "de.codecentric.recipedddexample.*")
public class RecipeDddExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeDddExampleApplication.class, args);
    }

    @Bean
    BeforeConvertCallback<RecipeJdbc> beforeConvertCallbackRecipe() {
        return (recipe) -> {
           if(recipe.getId() == null) {
               recipe.setId(UUID.randomUUID().toString());
           }
           return recipe;
        };
    }
}
