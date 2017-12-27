package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootConfiguration
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	   @RequestMapping(
	            value = "/demo/{username}",
	            method = RequestMethod.GET,
	            produces = MediaType.TEXT_PLAIN_VALUE)
	    public String whoami(@PathVariable("username") String username) {
	        return "Hello " + username;
	    }
}
