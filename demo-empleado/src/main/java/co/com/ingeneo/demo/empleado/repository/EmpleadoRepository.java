package co.com.ingeneo.demo.empleado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ingeneo.demo.empleado.entities.Empleado;

/**
 * Repository para gestión de Empleados en la base de datos
 * @author Ingeneo
 *
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
	
	@Query("SELECT e FROM Empleado e WHERE e.nombre like (%:nombre%)")
	public List<Empleado> findPorNombre(@Param("nombre") String nombre);

}
