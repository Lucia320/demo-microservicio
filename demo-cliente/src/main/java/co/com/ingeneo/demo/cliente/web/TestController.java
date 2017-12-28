package co.com.ingeneo.demo.cliente.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ingeneo.demo.cliente.entities.Cliente;
import co.com.ingeneo.demo.cliente.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping(value = "/prueba")
public class TestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
			
	@Autowired
	private TestService service;
	
	@RequestMapping(value = "/clientes",method=RequestMethod.GET)
	public List<Cliente> getClientes(){
		return service.getClientes();
	}
	
	@RequestMapping(value = "/clientes/filtro",method=RequestMethod.GET)
	public List<Cliente> getClientesPorNombre(@RequestParam String nombre){
		logger.debug("Servicio:Gestión de clientes => /clientes/filtro");
		return service.getClientesPorNombre(nombre);
	}
	
	
	@ApiOperation(value = "insertarCliente", nickname = "getClientes", response = Cliente.class)
	@RequestMapping(value = "/clientes",method=RequestMethod.POST)
	public Cliente insertarCliente(@RequestBody Cliente cliente){
		logger.debug("Servicio:Gestión de clientes => /clientes/insertar");
		try{
			return service.insertarCliente(cliente);
		}catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping(value = "/clientes",method=RequestMethod.DELETE)
	public String borrarCliente(@RequestParam String cedula){
		logger.debug("Servicio:Gestión de clientes => /clientes/borrar");
		try{
			service.borrarCliente(cedula);
			return "Operación exitosa";  
		}catch (Exception e) {
			return "Operación no exitosa"; 
		}
	}
}
