package co.com.ingeneo.demo.empleado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ingeneo.demo.empleado.entities.Empleado;
import co.com.ingeneo.demo.empleado.repository.EmpleadoRepository;


@Service
@Transactional
public class EmpleadoService {
	
	@Autowired
	private EmpleadoRepository repository;
	
	public List<Empleado> getEmpleados(){
		return repository.findAll();
	}

	public Empleado insertar(Empleado empleado) {
		return repository.save(empleado);
	}

	public void borrar(String cedula) {
		repository.delete(cedula);
	}
	
	public List<Empleado> getPorNombre(String nombre){
		return repository.findPorNombre(nombre);
	}
	
}
