package de.codecentric.recipedddexample.recipe.adapter.out.persistence.repository;

import de.codecentric.recipedddexample.recipe.application.port.out.RecipeRepository;
import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RecipeRepositoryImpl implements RecipeRepository {
    private final RecipeJpaRepository recipeJpaRepository;

    @Override
    public Recipe save(Recipe recipe) {
        return null;
    }

    @Override
    public List<Recipe> findAll() {
        return null;
    }
}
