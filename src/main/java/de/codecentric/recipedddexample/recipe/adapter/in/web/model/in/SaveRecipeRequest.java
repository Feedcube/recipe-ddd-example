package de.codecentric.recipedddexample.recipe.adapter.in.web.model.in;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public record SaveRecipeRequest(@JsonProperty String name, @JsonProperty String description, @JsonProperty String imageUrl, @JsonProperty List<SaveRecipeIngredientRequest> ingredients) {
}
