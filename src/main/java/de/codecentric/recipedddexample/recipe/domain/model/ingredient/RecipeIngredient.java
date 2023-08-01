package de.codecentric.recipedddexample.recipe.domain.model.ingredient;

import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.ddd.types.Entity;
import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

import java.util.UUID;

@Getter
public class RecipeIngredient implements ValueObject{

    private Amount amount;

    public record Amount(double amount, @Enumerated(EnumType.STRING) RecipeIngredientUnit unit) implements ValueObject {}

}
