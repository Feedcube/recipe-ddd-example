package de.codecentric.recipedddexample.recipe.adapter.out.persistence.mapper;

import de.codecentric.recipedddexample.recipe.adapter.out.persistence.model.RecipeIngredientJdbc;
import de.codecentric.recipedddexample.recipe.adapter.out.persistence.model.RecipeJdbc;
import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import de.codecentric.recipedddexample.recipe.domain.model.ingredient.RecipeIngredient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecipeMapper {
    private final RecipeIngredientMapper recipeIngredientMapper;
    public RecipeJdbc domainToJdbc(Recipe recipe) {
        String id = recipe.getId().id() != null ? recipe.getId().id().toString() : null;
        List<RecipeIngredientJdbc> ingredients = recipe.getIngredients().stream().map(recipeIngredientMapper::domainToJdbc).toList();
        return new RecipeJdbc(id, recipe.getName(), recipe.getDescription(), recipe.getImageUrl(), ingredients);
    }

    public Recipe jdbcToDomain(RecipeJdbc recipeJdbc) {
        List<RecipeIngredient> ingredients = recipeJdbc.getIngredients().stream().map(recipeIngredientMapper::jdbcToDomain).toList();
        return Recipe.create(UUID.fromString(recipeJdbc.getId()), recipeJdbc.getName(), recipeJdbc.getDescription(), recipeJdbc.getImageUrl(), ingredients);
    }
}
