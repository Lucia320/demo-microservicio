package co.com.ingeneo.demo.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ingeneo.demo.cliente.entities.Cliente;
import co.com.ingeneo.demo.cliente.repository.TestRepository;


@Service
@Transactional
public class TestService {
	
	@Autowired
	private TestRepository repository;
	
	public List<Cliente> getClientes(){
		return repository.findAll();
	}

	public Cliente insertarCliente(Cliente cliente) {
		return repository.save(cliente);
	}

	public void borrarCliente(String cedula) {
		repository.delete(cedula);
	}
	
	public List<Cliente> getClientesPorNombre(String nombre){
		return repository.findClientePorNombre(nombre);
	}
	
}
