package coches.service;


import coches.domain.Coche;
import coches.domain.Persona;
import coches.repository.CocheRepository;
import coches.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CocheService {
    @Autowired
    private CocheRepository cocheRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public void testCoche () {

        Coche coche = new Coche();
        coche.setMarca("Porsche");
        coche.setModelo("Carrera");
        coche.setId(1L);
        coche.setAño(2010);
        coche.setMatricula("AAA1234");
        coche.setPrecio(60000.00);


        Persona persona = new Persona();// crear objeto
        persona.setNombre("Ivan");// nombrar objeto
        persona.setAge(22);
        personaRepository.save(persona);// guardar objeto

        coche.setPropietario(persona);
        cocheRepository.save(coche);

        Coche coche2 = new Coche();
        coche2.setMarca("Seat");
        coche2.setModelo("Panda");
        coche2.setId(2L);
        coche2.setAño(2010);
        coche2.setMatricula("BBB1235");
        coche2.setPrecio(10000.00);
        Persona ivan= personaRepository.findOne(1L);
        coche2.setPropietario(ivan);
        cocheRepository.save(coche2);


        Coche coche3 = new Coche();
        coche3.setMarca("Opel");
        coche3.setModelo("Corsa");
        coche3.setId(3L);
        coche3.setAño(1998);
        coche3.setMatricula("CCC1236");
        coche3.setPrecio(4500.00);
        Persona ivan2= personaRepository.findOne(1L);
        coche3.setPropietario(ivan);
        cocheRepository.save(coche3);

        Coche coche4 = new Coche();
        coche4.setMarca("Ford");
        coche4.setModelo("Focus");
        coche4.setId(4L);
        coche4.setAño(2015);
        coche4.setMatricula("DDD1237");
        coche4.setPrecio(11000.00);
        Persona ivan3= personaRepository.findOne(1L);
        coche4.setPropietario(ivan);
        cocheRepository.save(coche4);

        Coche coche5 = new Coche();
        coche5.setMarca("Nissan");
        coche5.setModelo("Patrol");
        coche5.setId(5L);
        coche5.setAño(2001);
        coche5.setMatricula("CCC1238");
        coche5.setPrecio(12000.00);
        Persona dimple=personaRepository.findOne(2L);
        coche5.setPropietario(dimple);
        cocheRepository.save(coche5);

        Coche coche6= new Coche();
        coche6.setMarca("Opel");
        coche6.setModelo("Astra");
        coche6.setId(6L);
        coche6.setAño(2008);
        coche6.setMatricula("FFF1239");
        coche6.setPrecio(11500.00);
        Persona jordi= personaRepository.findOne(4L);
        coche6.setPropietario(jordi);
        cocheRepository.save(coche6);

        Coche coche7= new Coche();
        coche7.setMarca("Ford");
        coche7.setModelo("Focus");
        coche7.setId(7L);
        coche7.setAño(2014);
        coche7.setMatricula("GGG1231");
        coche7.setPrecio(8500.00);
        Persona ricard= personaRepository.findOne(5L);
        coche7.setPropietario(ricard);
        cocheRepository.save(coche7);

        System.out.println("Mostramos todos los coches cuya fabricación es >= 2010");
        System.out.println(cocheRepository.findByAñoGreaterThanEqual(2010));

        System.out.println("Mostramos todos los coches cuya fabricación es <=2010");
        System.out.println(cocheRepository.findByAñoLessThanEqual(2010));

        System.out.println("Mostramos todos los coches fabricados entre 1998 y 2010");
        System.out.println(cocheRepository.findByAñoBetween(1998,2010));

        System.out.println("Mostramos los coches cuyo precio es <= 10000.00");
        System.out.println(cocheRepository.findByPrecioLessThanEqual(10000.00));

        System.out.println("Mostramos los coches cuyo precio es >= 10000.00");
        System.out.println(cocheRepository.findByPrecioGreaterThanEqual(10000.00));

        System.out.println("Mostramos los coches cuyo precio está entre 4500.00 y 10000.00");
        System.out.println(cocheRepository.findByPrecioBetween(45000.00,10000.00));

        System.out.println("Mostramos todos los coches con la matrícula CCC1238 ");
        System.out.println( cocheRepository.findByMatricula("CCC1238"));

        System.out.println("Mostramos todos los Seat Panda");
        System.out.println(cocheRepository.findByMarcaAndModelo("Seat","Panda"));

        System.out.println("Mostramos todos los coches de una determinada marca y cuyo precio es <=12000.00");
        System.out.println(cocheRepository.findByMarcaAndPrecioLessThanEqual("Opel",12000.00));

        System.out.println("Mostramos todos los coches de una eterminada marca y modelo y cuyo precio sea >= 8000.00");
        System.out.println(cocheRepository.findByMarcaAndModeloAndPrecioGreaterThanEqual("Ford","Focus",8000.00));

        System.out.println("Mostramos la media del precio de todos los coches de una determinada marca");
        System.out.println(cocheRepository.obtenerMediaPorMarca("Ford"));

        System.out.println(" Mostramos todos los coches de un determinado propietario");
        System.out.println(cocheRepository.findByPropietario(ivan));

        System.out.println(" Mostramos todos los coches de un determinado propietario y con un precio >= 9000.00");
        System.out.println(cocheRepository.findByPropietarioAndPrecioGreaterThan(ivan,9000.00));

        System.out.println(" Mostramos todos los coches de un determinado propietario y con un precio >= 9000.00 y fabricados entre 2007 y 2015");
        System.out.println(cocheRepository.findByPropietarioAndPrecioGreaterThanAndAñoBetween(ivan,9000.00,2007,2015));

        System.out.println("Mostramos todos los coches de las personas > 23");
        System.out.println(cocheRepository.obtenerCochesGreaterEdad(23));

        System.out.println("Mostramos todos los coches de las personas entre 24 y 27 años");
        System.out.println(cocheRepository.obtenerCochesRangoEdad(27,24));

        System.out.println("Mostramos todos los coches que en su matricula contengan 123");
        System.out.println(cocheRepository.findByMatriculaContaining("123"));
        /*System.out.println(cocheRepository.getCocheMatriculasQueContengan("123"));*/

        System.out.println("java 5");
        List<Object[]> estadisticaMarcaList = cocheRepository.medianaMarcaMaxMinList();
        for (Object[] estadisticaMarca: estadisticaMarcaList)
        {
            System.out.println("marca: " + estadisticaMarca[0]);// numero basico para que reconozca/sepa en que posición de array list está.
            System.out.println("media: " + estadisticaMarca[1]);
            System.out.println("max: " + estadisticaMarca[2]);
            System.out.println("min: " + estadisticaMarca[3]);
        }

        System.out.println("java 5");

        for (Object[]  estadisticaAño: cocheRepository.obtenerCochesPorAño())
        { Integer año= (Integer)estadisticaAño[0];
            System.out.println("Año: " + año);
            System.out.println("numero de coches: "+ estadisticaAño[1]);
            System.out.println( "Listado de coches: "+ cocheRepository.findByAño(año));

        }









    }
}
   /*he coche1 = new Coche(1L, "A", 2010, "Carrera", "Porsche");
    Coche coche2 = new Coche(2L, "B", 2010, "Panda", "Seat");
    Coche coche3 = new Coche(3L, "D", 1998, "Corsa", "Opel");
    Coche coche4 = new Coche(4L, "F", 2015, "Focus", "Ford");
    Coche coche5 = new Coche(5L, "C", 2001, "Patrol", "Nissan");*/