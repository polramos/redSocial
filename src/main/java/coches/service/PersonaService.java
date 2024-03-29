package coches.service;


import coches.domain.Persona;
import coches.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public void testPersonas(){
        Persona persona = new Persona();// crear objeto
        persona.setNombre("Ivan");// nombrar objeto
        persona.setAge(22);
        personaRepository.save(persona);// guardar objeto

        Persona persona2 = new Persona();
        persona2.setNombre("Dimple");
        persona2.setAge(26);
        personaRepository.save(persona2);

        Persona persona3 = new Persona();
        persona3.setNombre("Noelia");
        persona3.setApellido("Villa");
        persona3.setAge(25);
        personaRepository.save(persona3);

        Persona persona4 = new Persona();
        persona4.setNombre("Jordi");
        persona4.setAge(25);
        personaRepository.save(persona4);

        Persona persona5 = new Persona();
        persona5.setNombre("Ricard");
        persona5.setAge(23);
        personaRepository.save(persona5);


        Persona persona6 = new Persona();
        persona6.setNombre("Noelia");
        persona6.setApellido("Hernandez");
        persona6.setAge(21);
        personaRepository.save(persona6);

        Persona persona7= new Persona();
        persona7.setNombre("Juan");
        persona7.setApellido("Villa");
        persona7.setAge(26);
        personaRepository.save(persona7);

        System.out.println(personaRepository.findOne(2L)); // encontrar la persona que se encuentra en la posición 2L
        System.out.println(personaRepository.findByNombre("Noelia"));

        System.out.println("mostramos todas las personas cuya edad es >= 25");
        System.out.println(personaRepository.findByAgeGreaterThanEqual(25));

        System.out.println("Mostramos todas las personas que se llamen Noelia Villa");
        System.out.println(personaRepository.findByNombreAndApellido("Noelia","Villa"));

        System.out.println("Mostramos todas las personas que se llamen Noelia  o Villa de apellido");
        System.out.println( personaRepository.findByNombreOrApellido("Noelia","Villa"));



    }
}
