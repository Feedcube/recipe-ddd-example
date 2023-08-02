package de.codecentric.recipedddexample.recipe.domain.model;

import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredient;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jmolecules.ddd.annotation.Association;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifiable;
import org.jmolecules.ddd.types.Identifier;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
public class Recipe  implements AggregateRoot<Recipe, Recipe.RecipeId> {
    private RecipeId id;
    @Setter
    private String name;
    @Setter
    private String description;
    @Setter
    private String imageUrl;

    @CollectionTable(name = "recipe_ingredient")
    @ElementCollection
    private List<RecipeIngredient> ingredients;


    public record RecipeId(UUID id) implements Identifier {}

    public static Recipe create(String name, String description, String imageUrl, List<RecipeIngredient> ingredients) {
        return Recipe.of(new RecipeId(UUID.randomUUID()), name, description, imageUrl, ingredients);
    }

}
