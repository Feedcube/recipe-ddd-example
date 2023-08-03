package de.codecentric.recipedddexample.recipe.adapter.out.persistence.model;

import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredientUnit;

public enum RecipeIngredientUnitJdbc {
    MILLILITER, GRAM;

    public static RecipeIngredientUnitJdbc of(RecipeIngredientUnit unit) {
        return switch (unit) {
            case GRAM -> RecipeIngredientUnitJdbc.GRAM;
            case MILLILITER -> RecipeIngredientUnitJdbc.MILLILITER;
        };
    }

    public static RecipeIngredientUnit toDomain(RecipeIngredientUnitJdbc unit) {
        return switch (unit) {
            case GRAM -> RecipeIngredientUnit.GRAM;
            case MILLILITER -> RecipeIngredientUnit.MILLILITER;
        };
    }
}
