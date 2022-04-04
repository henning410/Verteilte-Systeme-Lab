package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	class Hello {
		@GetMapping("/hello")
		String hello() {
			return "Hello here I am";
		}

		@GetMapping("/parameter/{id}")
		@ResponseBody
		String testParameter(@PathVariable("id") String id) {
			return "Parameter ID: " + id;
		}
	}

}
