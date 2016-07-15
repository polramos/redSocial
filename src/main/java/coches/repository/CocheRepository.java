package coches.repository;

import coches.domain.Coche;
import coches.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CocheRepository  extends JpaRepository<Coche,Long>{


    List<Coche> findByAño(Integer año);

    List<Coche> findByAñoGreaterThanEqual(Integer año);

    List<Coche> findByAñoLessThanEqual(Integer año);

    List<Coche> findByAñoBetween(Integer año1,Integer año2);

    List<Coche> findByPrecioGreaterThanEqual(Double precio);

    List<Coche>findByPrecioLessThanEqual (Double precio);

    List<Coche> findByPrecioBetween ( Double precio1,Double precio2);

    Coche  findByMatricula(String matricula);

    List<Coche> findByMarcaAndModelo(String marca, String modelo);

    List<Coche> findByMarcaAndPrecioLessThanEqual(String marca, Double precio);

    List<Coche>findByMarcaAndModeloAndPrecioGreaterThanEqual(String marca, String modelo, Double precio);

    List<Coche> findByPropietario(Persona propietario);
    /*@Query (" SELECT (coche) from Coche coche where coche.propietario = :propietario")
    List<Coche> obtenerCoches(@Param("propietario")Persona propietario); igual que findByPropietario*/

    List<Coche> findByPropietarioAndPrecioGreaterThan(Persona propietario, Double precio);

    List<Coche> findByPropietarioAndPrecioGreaterThanAndAñoBetween(Persona propietario, Double precio,Integer año1, Integer año2);

    List<Coche> findByMatriculaContaining(String matricula);
    /* @Query("SELECT c from Coche c where c.matricula LIKE(CONCAT('%',:fragmentoMatricula,'%'))")// CONCAT= concatenar = +(concatena 2 strings) % en sql significa que puede ser cualquier valor literalmente.
    List<Coche> getCocheMatriculasQueContengan(@Param ("fragmentoMatricula") String fragmentoMatricula);*/



    @Query("SELECT AVG(c.precio) from Coche c where c. marca = :marca")
    Double obtenerMediaPorMarca(@Param("marca")String marca);

    @Query("SELECT c  from Coche c   where c.propietario.age> :edad ")
    List<Coche> obtenerCochesGreaterEdad(@Param("edad")Integer edad);

    @Query("SELECT c from Coche c where c.propietario.age< :edadmax and c.propietario.age> :edadmin ")
    List<Coche> obtenerCochesRangoEdad(@Param("edadmax")Integer edadmax,@Param("edadmin")Integer edadmin);

   @Query("SELECT c.marca, AVG(c.precio),max(c.precio),min(c.precio) from Coche c group by c.marca")
    List<Object[]>medianaMarcaMaxMinList();

    @Query("SELECT c.año, COUNT (c)  from Coche c group by c.año")
    List<Object[]>obtenerCochesPorAño();



















}
