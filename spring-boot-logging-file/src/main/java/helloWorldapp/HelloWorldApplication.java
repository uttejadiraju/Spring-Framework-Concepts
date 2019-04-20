package helloWorldapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloWorldApplication {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldApplication.class);
    public static void main (String[] args) {
        ApplicationContext ctx =
                    SpringApplication.run(HelloWorldApplication.class, args);
        logger.info("just a test info log");
        logger.error("Error!!!");

    }
}