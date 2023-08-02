package de.codecentric.recipedddexample.recipe.domain.model.ingredient;

import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.ddd.types.Entity;
import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
public class RecipeIngredient implements ValueObject{
    @Id
    private String id;
    private String name;

    private Amount amount;
    public static RecipeIngredient create(String name, double amount, RecipeIngredientUnit unit) {
        return RecipeIngredient.of(UUID.randomUUID().toString(), name, new Amount(amount, unit));
    }

    public record Amount(double amount, @Enumerated(EnumType.STRING) RecipeIngredientUnit unit) implements ValueObject {}

}
