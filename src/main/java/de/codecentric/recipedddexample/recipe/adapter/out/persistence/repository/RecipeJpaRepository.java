package de.codecentric.recipedddexample.recipe.adapter.out.persistence.repository;

import de.codecentric.recipedddexample.recipe.adapter.out.persistence.model.RecipeJpa;
import de.codecentric.recipedddexample.recipe.domain.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface RecipeJpaRepository extends CrudRepository<RecipeJpa, UUID> {

}
