package de.codecentric.recipedddexample.recipe.application.port.in;

import de.codecentric.recipedddexample.recipe.domain.model.Recipe;

public interface CreateRecipeUseCase {
    Recipe create(String name, String description, String imageUrl);
}
