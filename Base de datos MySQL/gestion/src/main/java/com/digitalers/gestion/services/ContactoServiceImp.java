package com.digitalers.gestion.services;

import com.digitalers.gestion.models.Estudiante;
import com.digitalers.gestion.repositories.EstudianteRep;
import com.digitalers.gestion.repositories.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalers.gestion.models.Contacto;
import com.digitalers.gestion.repositories.ContactoRep;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoServiceImp extends ServicioImp<Contacto, Integer> implements ContactoService{

    @Autowired
    ContactoRep contactoRep;

    @Autowired
    EstudianteRep estudianteRep;

    public ContactoServiceImp(Repositorio<Contacto, Integer> repositorio) {
        super(repositorio);
    }

    @Override
    public Estudiante mostrarEstudiante(Integer id_contacto) throws Exception {
        List<Estudiante> estudiantes = estudianteRep.findAll();
        Estudiante estudianteContacto = new Estudiante();
        Optional<Contacto> contacto = contactoRep.findById(id_contacto);
        for (Estudiante estudiante : estudiantes){
            if(estudiante.getContacto().equals(contacto.get())){
                estudianteContacto = estudiante;
            }
        }
        return estudianteContacto;
    }
}
