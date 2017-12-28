package co.com.ingeneo.demo.circuitbreaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ingeneo.demo.circuitbreaker.services.DemoCircuitBreakerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("circuitBreaker/")
public class DemoCircuitBreakerController {
	
	@Autowired
	private DemoCircuitBreakerService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "callService/")   
	@ApiOperation(value = "callService", nickname = "callService", response = String.class)
    public ResponseEntity<String> callService(@RequestBody(required = true) String customerParam) {

        System.out.println("--> name received: " +customerParam);
        return service.consumeService(customerParam);
    }

}
