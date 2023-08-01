package de.codecentric.recipedddexample.recipe.domain.model;

import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredient;
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

    private List<RecipeIngredient> ingredients;


    public record RecipeId(UUID id) implements Identifier {}

    public static Recipe create(String name, String description, String imageUrl) {
        return Recipe.of(new RecipeId(UUID.randomUUID()), name, description, imageUrl, List.of());
    }

}
