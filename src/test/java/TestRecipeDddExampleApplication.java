import de.codecentric.recipedddexample.RecipeDddExampleApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestRecipeDddExampleApplication {

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>("postgres:latest");
    }

    public static void main(String[] args) {
        SpringApplication.from(RecipeDddExampleApplication::main).with(TestRecipeDddExampleApplication.class).run(args);
    }

}
