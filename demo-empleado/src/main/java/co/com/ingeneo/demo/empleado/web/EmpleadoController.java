package co.com.ingeneo.demo.empleado.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ingeneo.demo.empleado.entities.Empleado;
import co.com.ingeneo.demo.empleado.service.EmpleadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping(value = "/administrador")
public class EmpleadoController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
			
	@Autowired
	private EmpleadoService service;
	
	@RequestMapping(value = "/empleado",method=RequestMethod.GET)
	public List<Empleado> getEmpleados(){
		return service.getEmpleados();
	}
	
	@RequestMapping(value = "/empleado/filtro",method=RequestMethod.GET)
	public List<Empleado> getPorNombre(@RequestParam String nombre){
		logger.debug("Servicio:Gestión de Empleado => /empleado/filtro");
		return service.getPorNombre(nombre);
	}
	
	
	@ApiOperation(value = "insertar", nickname = "insertar", response = Empleado.class)
	@RequestMapping(value = "/empleado",method=RequestMethod.POST)
	public Empleado insertar(@RequestBody Empleado empleado){
		logger.debug("Servicio:Gestión de empleado => /empleado/insertar");
		try{
			return service.insertar(empleado);
		}catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping(value = "/empleado",method=RequestMethod.DELETE)
	public String borrar(@RequestParam String cedula){
		logger.debug("Servicio:Gestión de empleado => /empleado/borrar");
		try{
			service.borrar(cedula);
			return "Operación exitosa";  
		}catch (Exception e) {
			return "Operación no exitosa"; 
		}
	}
}
