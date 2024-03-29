package com.example.service;

import com.example.domain.Pareja;
import com.example.domain.Persona;
import com.example.repository.ParejaRepository;
import com.example.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SocialNetworkService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ParejaRepository parejaRepository;

    public void añadirPersona(Persona persona)// el que(Publico)
    {
        personaRepository.save(persona); // el como (privado) -- esto es la encapsulación
    }

    public void añadirPareja(Persona p1, Persona p2) {

        Pareja pareja= new Pareja(p1,p2);
        parejaRepository.save(pareja);
    }
    public Persona getPersona(Long id) {
        return personaRepository.findOne(id);
    }

    public Persona getPersona(String nombre) {
        return personaRepository.findByNombre(nombre);

    }
    public Persona getPareja (Persona persona) {

        Pareja pareja = parejaRepository.getPareja(persona);

        Persona resultado= null;
        if(pareja==null){
            return resultado;
        }
            else
        {
            if (pareja.getP1().equals(persona))
            {
                resultado= pareja.getP2();
            }
        if (pareja.getP2().equals(persona))
        {
            resultado= pareja.getP1();
        }

    }  return resultado;


} }
