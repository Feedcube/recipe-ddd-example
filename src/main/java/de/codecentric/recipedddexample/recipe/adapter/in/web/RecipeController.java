package de.codecentric.recipedddexample.recipe.adapter.in.web;

import de.codecentric.recipedddexample.recipe.adapter.in.web.model.out.RecipeCreatedResponse;
import de.codecentric.recipedddexample.recipe.adapter.in.web.model.out.RecipeIngredientResponse;
import de.codecentric.recipedddexample.recipe.adapter.in.web.model.out.RecipeResponse;
import de.codecentric.recipedddexample.recipe.adapter.in.web.model.in.SaveRecipeRequest;
import de.codecentric.recipedddexample.recipe.application.port.in.CreateRecipeUseCase;
import de.codecentric.recipedddexample.recipe.application.port.in.GetRecipesUseCase;
import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredient;
import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredientUnit;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PrimaryAdapter
@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {
    private final CreateRecipeUseCase createRecipeUseCase;
    private final GetRecipesUseCase getRecipesUseCase;

    @PostMapping
    public ResponseEntity<RecipeCreatedResponse> create(@RequestBody SaveRecipeRequest saveRecipeRequest) {
        Recipe createdRecipe = this.createRecipeUseCase.create(saveRecipeRequest.name(), saveRecipeRequest.description(), saveRecipeRequest.imageUrl(), saveRecipeRequest.ingredients().stream().map(ingredientRequest ->  RecipeIngredient.create(ingredientRequest.name(), ingredientRequest.amount(), RecipeIngredientUnit.GRAM)).toList());
        return ResponseEntity.ok(new RecipeCreatedResponse(createdRecipe.getId().id()));
    }

    @GetMapping
    public ResponseEntity<List<RecipeResponse>> get() {
        List<Recipe> recipes = this.getRecipesUseCase.getRecipes();
        List<RecipeResponse> recipeResponses = recipes.stream().
                map(recipe -> new RecipeResponse(recipe.getId().id(), recipe.getName(), recipe.getDescription(), recipe.getImageUrl(), recipe.getIngredients().stream().map(ingredient -> new RecipeIngredientResponse(ingredient.getName(), ingredient.getAmount().amount())).toList()))
                .toList();
        return ResponseEntity.ok(recipeResponses);
    }
}
