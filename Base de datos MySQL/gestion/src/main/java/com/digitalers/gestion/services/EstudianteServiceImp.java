package com.digitalers.gestion.services;

import java.util.List;
import java.util.Optional;

import com.digitalers.gestion.models.Contacto;
import com.digitalers.gestion.models.Curso;
import com.digitalers.gestion.repositories.ContactoRep;
import com.digitalers.gestion.repositories.EstudianteRep;
import com.digitalers.gestion.repositories.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalers.gestion.models.Estudiante;

@Service
public class EstudianteServiceImp extends ServicioImp<Estudiante, Integer> implements EstudianteService{

    @Autowired
    private EstudianteRep estudianteRep;

    @Autowired


    public EstudianteServiceImp(Repositorio<Estudiante, Integer> repositorio) {
        super(repositorio);
    }

    @Override
    public List<Curso> mostrarCursos(Integer id) throws Exception {
        try {
            Optional<Estudiante> optional = estudianteRep.findById(id);
            if(optional.isPresent()){
                return optional.get().getCursos();
            }
            return null;
        } catch (Exception e) {
            throw new Exception("Error en la busqueda del archivo\n\n" + e.getMessage() );
        }
    }
}