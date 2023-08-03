package de.codecentric.recipedddexample.recipe.adapter.out.persistence.mapper;

import de.codecentric.recipedddexample.recipe.adapter.out.persistence.model.RecipeIngredientJdbc;
import de.codecentric.recipedddexample.recipe.adapter.out.persistence.model.RecipeIngredientUnitJdbc;
import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredient;
import org.springframework.stereotype.Service;

@Service
public class RecipeIngredientMapper {
    public RecipeIngredientJdbc domainToJdbc(RecipeIngredient ingredient) {
        return new RecipeIngredientJdbc(ingredient.getId(), ingredient.getName(), ingredient.getAmount().amount(), ingredient.getAmount().unit());
    }

    public RecipeIngredient jdbcToDomain(RecipeIngredientJdbc ingredient) {
        return RecipeIngredient.create(ingredient.getName(), ingredient.getAmount(), RecipeIngredientUnitJdbc.toDomain(ingredient.getUnit()));
    }

}
