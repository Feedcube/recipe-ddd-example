package de.codecentric.recipedddexample.recipe.adapter.out.persistence.repository;

import de.codecentric.recipedddexample.recipe.adapter.out.persistence.mapper.RecipeMapper;
import de.codecentric.recipedddexample.recipe.application.port.out.RecipeRepository;
import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class RecipeRepositoryImpl implements RecipeRepository {
    private final RecipeJpaRepository recipeJpaRepository;
    private final RecipeMapper recipeMapper;

    @Override
    public Recipe save(Recipe recipe) {
        return recipeMapper.jdbcToDomain(recipeJpaRepository.save(recipeMapper.domainToJdbc(recipe)));
    }

    @Override
    public List<Recipe> findAll() {
        return recipeJpaRepository.findAll().stream()
                .map(recipeMapper::jdbcToDomain).toList();
    }
}
