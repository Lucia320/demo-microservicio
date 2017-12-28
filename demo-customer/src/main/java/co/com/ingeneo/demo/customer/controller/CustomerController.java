/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ingeneo.demo.customer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value = "customer/")
public class CustomerController {
	
	@Autowired
	private Environment environment;

    @RequestMapping(method = RequestMethod.POST, value = "saludo/")
    @ApiOperation(value = "saludo", nickname = "saludo", response = String.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    public String saludo(
            @ApiParam(value = "request", required = true) @RequestBody(required = true) String customerName) {

        System.out.println("--> Nombre recibido " + customerName);
        return "Saludo desde servicio customer local.port: "+ environment.getProperty("local.server.port")+"- Nombre: " + customerName;
    }
}
