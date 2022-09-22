package edu.vanderbilt.wall.wall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WallApplication {

	public static void main(String[] args) {
		SpringApplication.run(WallApplication.class, args);
	}

	@Bean
	public AddResponseHeaderFilter xssBrowserAuditDisabler(){
		return new AddResponseHeaderFilter();
	}
}
