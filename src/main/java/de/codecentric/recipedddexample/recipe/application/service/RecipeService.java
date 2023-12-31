package de.codecentric.recipedddexample.recipe.application.service;

import de.codecentric.recipedddexample.recipe.application.port.in.CreateRecipeUseCase;
import de.codecentric.recipedddexample.recipe.application.port.in.GetRecipesUseCase;
import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import de.codecentric.recipedddexample.recipe.application.port.out.RecipeRepository;
import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredient;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService implements CreateRecipeUseCase, GetRecipesUseCase {
    private final RecipeRepository recipeRepository;
    @Override
    public Recipe create(String name, String description, String imageUrl, List<RecipeIngredient> ingredients) {
        Recipe recipe = Recipe.create(name, description, imageUrl, ingredients);
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }
}
