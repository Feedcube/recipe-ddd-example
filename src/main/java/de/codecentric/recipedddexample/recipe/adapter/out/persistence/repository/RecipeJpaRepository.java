package de.codecentric.recipedddexample.recipe.adapter.out.persistence.repository;

import de.codecentric.recipedddexample.recipe.adapter.out.persistence.model.RecipeJdbc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
public interface RecipeJpaRepository extends ListCrudRepository<RecipeJdbc, UUID> {

}
