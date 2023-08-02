package de.codecentric.recipedddexample.recipe.adapter.in.web.model.out;

import java.util.List;
import java.util.UUID;

public record RecipeResponse (UUID id, String name, String description, String imageUrl, List<RecipeIngredientResponse> ingredients){}
