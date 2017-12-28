package co.com.ingeneo.demo.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootConfiguration
@EnableAutoConfiguration
public class DemoCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCustomerApplication.class, args);
    }
}
