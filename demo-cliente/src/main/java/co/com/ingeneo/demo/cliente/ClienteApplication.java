package co.com.ingeneo.demo.cliente;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import co.com.ingeneo.demo.cliente.util.Properties;


@SpringBootApplication
@EnableAutoConfiguration
@EnableCircuitBreaker
@EntityScan(basePackages = { "co.com.ingeneo.demo.cliente.entities" })
@EnableJpaRepositories(basePackages = { "co.com.ingeneo.demo.cliente.repository" })
@EnableCaching
public class ClienteApplication extends SpringBootServletInitializer{
	
	@Autowired
	private Properties properties;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(ClienteApplication.class, args);
	}
        
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ClienteApplication.class);
	}
}
