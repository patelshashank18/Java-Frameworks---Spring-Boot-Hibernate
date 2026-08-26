package fst5.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class used to start the Customer Management application.
 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * Starts the Spring Boot application.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {

		SpringApplication.run(
				DemoApplication.class,
				args);
	}
}
