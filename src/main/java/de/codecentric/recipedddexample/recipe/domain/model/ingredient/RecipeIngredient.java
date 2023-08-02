package de.codecentric.recipedddexample.recipe.domain.model.ingredient;


import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import org.jmolecules.ddd.types.ValueObject;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
public class RecipeIngredient implements ValueObject{
    private Integer id;
    private String name;

    private Amount amount;

    public record Amount(double amount, RecipeIngredientUnit unit) implements ValueObject {}

    public static RecipeIngredient create(String name, double amount, RecipeIngredientUnit unit) {
        return RecipeIngredient.of(null, name, new Amount(amount, unit));
    }


}
