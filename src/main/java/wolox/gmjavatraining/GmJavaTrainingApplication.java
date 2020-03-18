package wolox.gmjavatraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("wolox.gmjavatraining.models")
@SpringBootApplication
public class GmJavaTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmJavaTrainingApplication.class, args);
	}

}
