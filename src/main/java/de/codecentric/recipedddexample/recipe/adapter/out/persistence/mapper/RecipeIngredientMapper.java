package de.codecentric.recipedddexample.recipe.adapter.out.persistence.mapper;

import de.codecentric.recipedddexample.recipe.adapter.out.persistence.model.RecipeIngredientJdbc;
import de.codecentric.recipedddexample.recipe.adapter.out.persistence.model.RecipeJdbc;
import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredient;
import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredientUnit;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RecipeIngredientMapper {
    public RecipeIngredientJdbc domainToJdbc(RecipeIngredient ingredient) {
        return new RecipeIngredientJdbc( ingredient.getId(), ingredient.getName());
    }

    public RecipeIngredient jdbcToDomain(RecipeIngredientJdbc ingredient) {
        return RecipeIngredient.create(ingredient.getName(), 0d, RecipeIngredientUnit.GRAM);
    }
}
