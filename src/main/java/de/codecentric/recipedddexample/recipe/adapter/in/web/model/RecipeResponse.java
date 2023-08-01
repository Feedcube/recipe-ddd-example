package de.codecentric.recipedddexample.recipe.adapter.in.web.model;

import java.util.UUID;

public record RecipeResponse (UUID id, String name, String description, String imageUrl){}
