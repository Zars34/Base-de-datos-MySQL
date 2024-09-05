package com.digitalers.gestion.services;

import com.digitalers.gestion.models.Curso;
import com.digitalers.gestion.repositories.CursoRep;
import com.digitalers.gestion.repositories.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digitalers.gestion.models.Instructor;
import com.digitalers.gestion.repositories.InstructorRep;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InstructorServiceImp extends ServicioImp<Instructor, Integer> implements InstructorService{

    @Autowired
    private InstructorRep instructorRep;

    @Autowired
    private CursoRep cursoRep;

    public InstructorServiceImp(Repositorio<Instructor, Integer> repositorio) {
        super(repositorio);
    }

    public List<Curso> mostrarCursosPorInstructor(Integer id_instructor) throws Exception{
        //Lista de cursos completa
        List<Curso> cursos = cursoRep.findAll();

        //Lista de cursos del instructor
        List<Curso> cInstructor = new ArrayList<>();
        try {
            Optional<Instructor> instructor = instructorRep.findById(id_instructor);
            Instructor iEncontrado = instructor.get();
                for (Curso curso : cursos) {
                    if (Objects.equals(curso.getInstructor().getId(), iEncontrado.getId())) {
                        cInstructor.add(curso);
                    }
                }
            return cInstructor;
        } catch (Exception e) {
            throw new Exception("Error en la busqueda del archivo\n\n" + e.getMessage() );
            }
    }
}




