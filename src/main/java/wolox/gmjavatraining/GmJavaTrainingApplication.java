package wolox.gmjavatraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("wolox.gmjavatraining.persistence.repo")
@EntityScan("wolox.gmjavatraining.persistence.model")
@SpringBootApplication
public class GmJavaTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmJavaTrainingApplication.class, args);
	}

}
