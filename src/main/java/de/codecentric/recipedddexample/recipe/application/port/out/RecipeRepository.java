package de.codecentric.recipedddexample.recipe.application.port.out;

import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import org.jmolecules.ddd.types.Repository;

import java.util.List;

public interface RecipeRepository extends Repository<Recipe, Recipe.RecipeId> {
    Recipe save(Recipe recipe);
    List<Recipe> findAll();
}
