package de.codecentric.recipedddexample.recipe.application.port.in;

import de.codecentric.recipedddexample.recipe.adapter.in.web.model.SaveRecipeRequest;
import de.codecentric.recipedddexample.recipe.domain.model.Recipe;

public interface CreateRecipeUseCase {
    Recipe create(SaveRecipeRequest recipeRequest);
}
