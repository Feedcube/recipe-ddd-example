package de.codecentric.recipedddexample.recipe.adapter.in.web.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public record SaveRecipeRequest(@JsonProperty String name, @JsonProperty String description, @JsonProperty String imageUrl) {
}
