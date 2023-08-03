package de.codecentric.recipedddexample.recipe.application.service;

import de.codecentric.recipedddexample.recipe.adapter.in.web.model.SaveRecipeRequest;
import de.codecentric.recipedddexample.recipe.application.port.in.CreateRecipeUseCase;
import de.codecentric.recipedddexample.recipe.application.port.in.GetRecipesUseCase;
import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import de.codecentric.recipedddexample.recipe.application.port.out.RecipeRepository;
import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredient;
import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredientUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService implements CreateRecipeUseCase, GetRecipesUseCase {
    private final RecipeRepository recipeRepository;
    @Override
    public Recipe create(SaveRecipeRequest recipeRequest) {
        List<RecipeIngredient> ingredients = recipeRequest.ingredients().stream().map(ingredientRequest -> RecipeIngredient.create(ingredientRequest.name(), ingredientRequest.amount(), ingredientRequest.unit())).toList();

        Recipe recipe = Recipe.create(null, recipeRequest.name(), recipeRequest.description(), recipeRequest.imageUrl(), ingredients);
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }
}
