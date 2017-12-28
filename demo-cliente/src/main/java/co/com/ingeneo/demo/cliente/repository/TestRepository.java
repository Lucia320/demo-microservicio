package co.com.ingeneo.demo.cliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ingeneo.demo.cliente.entities.Cliente;

/**
 * Repository para gestión de Clientes en la base de datos
 * @author Ingeneo
 *
 */
public interface TestRepository extends JpaRepository<Cliente, String> {
	
	@Query("SELECT c FROM Cliente c WHERE c.nombre like (%:nombre%)")
	public List<Cliente> findClientePorNombre(@Param("nombre") String nombre);

}
