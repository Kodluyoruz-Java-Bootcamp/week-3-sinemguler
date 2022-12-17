package medium;

import medium.service.BlogService;
import medium.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MediumServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediumServiceApplication.class, args);
	}
	@Bean
	public UserService userService() {
		return new UserService();
	}
	@Bean
	public BlogService blogService() {
		return new BlogService();
	}
}
