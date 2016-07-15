package com.example;


import com.example.domain.Persona;
import com.example.service.SocialNetworkService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        SocialNetworkService socialNetworkService = context.getBean(SocialNetworkService.class);

        testSocialNetwork(socialNetworkService);


    }

    private static void testSocialNetwork(SocialNetworkService socialNetworkService) {
        Persona ivan = new Persona();// crear objeto
        ivan.setNombre("Ivan");// nombrar objeto
        ivan.setAge(22);

        Persona daniel = new Persona();// crear objeto
        daniel.setNombre("Daniel");// nombrar objeto
        daniel.setAge(25);

        Persona novia = new Persona();// crear objeto
        novia.setNombre("novia");// nombrar objeto
        novia.setAge(23);

        socialNetworkService.añadirPersona(ivan);
        socialNetworkService.añadirPersona(daniel);
        socialNetworkService.añadirPersona(novia);

        socialNetworkService.añadirPareja(ivan, novia);

        System.out.println("La pareja de ivan es: ");
        System.out.println(socialNetworkService.getPareja(ivan));
    }

}
