package com.zcwnewsapp.MOCNews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MocNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MocNewsApplication.class, args);
	}

}
