import de.codecentric.recipedddexample.RecipeDddExampleApplication;
import de.codecentric.recipedddexample.recipe.adapter.in.web.model.SaveRecipeRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = RecipeDddExampleApplication.class)
@AutoConfigureMockMvc
@Testcontainers
public class RecipeTests {
    @Autowired
    private MockMvc mvc;

    @Container
    @ServiceConnection
    static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:latest");

    @Test
    public void itCreatesARecipe() throws Exception {
        SaveRecipeRequest saveRecipeRequest = new SaveRecipeRequest("Testrecipe", "Description", null);
        ObjectMapper objectMapper = new ObjectMapper();
        mvc.perform(MockMvcRequestBuilders.post("/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saveRecipeRequest)))
                .andExpect(status().is2xxSuccessful())
                .andDo(result -> System.out.println(new String(result.getResponse().getContentAsByteArray())));
    }

    @Test
    @Sql("/fixtures/recipe/create_recipe.sql")
    public void itFetchesRecipesWithoutIngredients() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mvc.perform(MockMvcRequestBuilders.get("/recipes"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0]['id']").value("979d3c40-e9ec-47e1-ac30-8b34c02c555f"));
    }

    @Test
    @Sql({
            "/fixtures/recipe/create_recipe.sql",
            "/fixtures/recipe/create_recipe_ingredients.sql"
    })
    public void itFetchesRecipesWithIngredients() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mvc.perform(MockMvcRequestBuilders.get("/recipes"))
                .andExpect(status().is2xxSuccessful())
                .andDo(result -> System.out.println(new String(result.getResponse().getContentAsByteArray())))
                .andExpect(jsonPath("$[0]['id']").value("979d3c40-e9ec-47e1-ac30-8b34c02c555f"));
    }
}
