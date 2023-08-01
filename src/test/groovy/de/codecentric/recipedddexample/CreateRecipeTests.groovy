package de.codecentric.recipedddexample


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.test.web.servlet.MockMvc
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@Testcontainers
@SpringBootTest(classes = RecipeDddExampleApplication.class)
class CreateRecipeTests extends Specification {

    @Autowired
    private MockMvc mvc

    @Shared
    @ServiceConnection
    static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:latest");


    def "when get is performed then the response has status 200 and content is 'Hello world!'"() {
        expect: "Status is 200 and the response is 'Hello world!'"
        mvc.perform(post("/recipes"))
                .andExpect(status().isOk())


    }
}
