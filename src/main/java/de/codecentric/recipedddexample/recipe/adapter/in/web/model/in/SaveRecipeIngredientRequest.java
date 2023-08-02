package de.codecentric.recipedddexample.recipe.adapter.in.web.model.in;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredientUnit;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public record SaveRecipeIngredientRequest(String name, double amount, RecipeIngredientUnit unit) {
}
