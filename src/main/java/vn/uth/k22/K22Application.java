package vn.uth.k22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;



@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class K22Application {
	public static void main(String[] args) {
		SpringApplication.run(K22Application.class, args);
	}
}
