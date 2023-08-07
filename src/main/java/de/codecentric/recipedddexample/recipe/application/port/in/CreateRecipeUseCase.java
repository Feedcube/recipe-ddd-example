package de.codecentric.recipedddexample.recipe.application.port.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.codecentric.recipedddexample.recipe.adapter.in.web.model.SaveRecipeRequest;
import de.codecentric.recipedddexample.recipe.adapter.in.web.model.in.SaveRecipeIngredientRequest;
import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredientUnit;

import java.util.List;

public interface CreateRecipeUseCase {
    Recipe create(CreateRecipeCommand createRecipeCommand);
    record CreateRecipeCommand(String name, String description, String imageUrl, List<CreateRecipeIngredientCommand> ingredients) { }
    record CreateRecipeIngredientCommand(String name, double amount, RecipeIngredientUnit unit) { }

}
