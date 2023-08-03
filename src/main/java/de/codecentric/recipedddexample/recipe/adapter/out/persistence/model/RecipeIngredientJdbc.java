package de.codecentric.recipedddexample.recipe.adapter.out.persistence.model;

import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredientUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "recipe_ingredient")
public class RecipeIngredientJdbc {
    @Id
    private Integer id;
    private String name;
    private double amount;
    @Transient
    private RecipeJdbc recipe;
    private RecipeIngredientUnitJdbc unit;

    public RecipeIngredientJdbc(String name, double amount, RecipeIngredientUnit unit ) {
        this.name = name;
        this.amount = amount;
        this.unit = RecipeIngredientUnitJdbc.of(unit);
    }
}
