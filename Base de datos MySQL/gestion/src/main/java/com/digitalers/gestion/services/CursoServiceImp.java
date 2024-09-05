package com.digitalers.gestion.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.digitalers.gestion.models.Estudiante;
import com.digitalers.gestion.models.Instructor;
import com.digitalers.gestion.repositories.EstudianteRep;
import com.digitalers.gestion.repositories.InstructorRep;
import com.digitalers.gestion.repositories.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalers.gestion.models.Curso;
import com.digitalers.gestion.repositories.CursoRep;

@Service
public class CursoServiceImp extends ServicioImp<Curso, Integer> implements CursoService{

    @Autowired
    private CursoRep cursoRep;
    @Autowired
    private EstudianteRep estudianteRep;

    public CursoServiceImp(Repositorio<Curso, Integer> repositorio) {
        super(repositorio);
    }


    @Override
    public List<Estudiante> mostrarEstudiantes(Integer id_curso) throws Exception{

        List<Estudiante> estudiantes = estudianteRep.findAll();

        List<Estudiante> estudiantesCurso = new ArrayList<>();
        try{
            Optional<Curso> curso = cursoRep.findById(id_curso);
            for(Estudiante estudiante : estudiantes){
                if(estudiante.getCursos().contains(curso.get())){
                    estudiantesCurso.add(estudiante);
                }
            }
            return estudiantesCurso;
        } catch (Exception e) {
            throw new Exception("Error en la busqueda del archivo\n\n" + e.getMessage() );
        }




    }



}
