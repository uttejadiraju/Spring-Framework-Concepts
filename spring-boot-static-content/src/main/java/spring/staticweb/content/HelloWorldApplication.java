package spring.staticweb.content;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication {
	public static void main(String[] args) {
		String[] appArgs = { "--debug" };
		SpringApplication app = new SpringApplication(HelloWorldApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.setLogStartupInfo(true);
		app.run(appArgs);

	}
}