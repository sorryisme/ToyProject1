package com.sorry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
(scanBasePackages={"com.sorry.*,SQLMap.mapper.board"})
public class SorryProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SorryProject1Application.class, args);
	}

}
