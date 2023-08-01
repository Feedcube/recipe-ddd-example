package de.codecentric.recipedddexample.recipe.application.port.in;

import de.codecentric.recipedddexample.recipe.domain.model.Recipe;

import java.util.List;

public interface GetRecipesUseCase {
    List<Recipe> getRecipes();
}
