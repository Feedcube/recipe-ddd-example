package de.codecentric.recipedddexample.recipe.application.port.in;

import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredient;

import java.util.List;

public interface CreateRecipeUseCase {
    Recipe create(String name, String description, String imageUrl, List<RecipeIngredient> ingredients);
}
