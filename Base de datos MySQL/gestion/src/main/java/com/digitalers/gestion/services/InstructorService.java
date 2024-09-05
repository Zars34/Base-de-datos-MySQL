package com.digitalers.gestion.services;


import com.digitalers.gestion.models.Curso;
import com.digitalers.gestion.models.Instructor;

import java.util.List;

public interface InstructorService extends Servicio<Instructor, Integer>{

    List<Curso> mostrarCursosPorInstructor(Integer id_instructor) throws Exception;

}
