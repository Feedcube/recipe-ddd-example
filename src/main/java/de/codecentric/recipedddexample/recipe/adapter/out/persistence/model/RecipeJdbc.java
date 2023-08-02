package de.codecentric.recipedddexample.recipe.adapter.out.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Table(name = "recipe")
@AllArgsConstructor
public final class RecipeJdbc {
    @Id
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    @MappedCollection(idColumn = "recipe", keyColumn = "id")
    private List<RecipeIngredientJdbc> ingredients;
}
