package ir.barsavanet.shortenurlbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.data.map.repository.config.EnableMapRepositories;

/**
 *
 * @author Mohammad
 */
@SpringBootApplication
@Profile(value = "!test")
@EnableMapRepositories
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
