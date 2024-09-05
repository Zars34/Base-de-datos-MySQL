package com.digitalers.gestion.services;


import com.digitalers.gestion.models.Curso;
import com.digitalers.gestion.models.Estudiante;
import com.digitalers.gestion.models.Instructor;

import java.util.List;

public interface CursoService extends Servicio<Curso, Integer>{

    List<Estudiante> mostrarEstudiantes(Integer id_curso) throws Exception;

}
