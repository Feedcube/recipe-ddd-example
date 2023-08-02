package de.codecentric.recipedddexample.recipe.domain.model;

import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredient;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jmolecules.ddd.types.Identifier;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
public class Recipe implements org.jmolecules.ddd.types.AggregateRoot<Recipe, Recipe.RecipeId> {

    @Getter
    private RecipeId id;
    @Setter
    private String name;
    @Setter
    private String description;
    @Setter
    private String imageUrl;

    private List<RecipeIngredient> ingredients;


    public record RecipeId(UUID id) implements Identifier {}

    public static Recipe create(UUID id, String name, String description, String imageUrl, List<RecipeIngredient> ingredients) {
        return Recipe.of(new RecipeId(id), name, description, imageUrl,ingredients);
    }

}
