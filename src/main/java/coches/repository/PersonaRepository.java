package coches.repository;


import coches.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonaRepository extends JpaRepository<Persona,Long> {

    List<Persona> findByNombre(String nombre);

    List<Persona> findByNombreAndApellido(String nombre, String apellido);

    List<Persona> findByNombreOrApellido(String nombre, String apellido);

    List<Persona> findByAgeGreaterThanEqual(Integer edad);

}
