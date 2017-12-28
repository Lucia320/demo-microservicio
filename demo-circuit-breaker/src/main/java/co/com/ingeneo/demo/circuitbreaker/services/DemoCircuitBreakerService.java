package co.com.ingeneo.demo.circuitbreaker.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DemoCircuitBreakerService {
	
	@Autowired
	@LoadBalanced
	private final RestTemplate restTemplate;

	  public DemoCircuitBreakerService(RestTemplate rest) {
	    this.restTemplate = rest;
	  }

	  @HystrixCommand(fallbackMethod = "reliable")
	  public ResponseEntity<String>  consumeService(String name) {
	    URI uri = URI.create("http://localhost:8096/customer/saludo/");
		return this.restTemplate.postForEntity(uri, name, String.class);
	  }

	  public ResponseEntity<String>   reliable(String name) {
		return new ResponseEntity<String>("Servicio no encontrado", null , HttpStatus.CREATED);
	  }
	  
}
