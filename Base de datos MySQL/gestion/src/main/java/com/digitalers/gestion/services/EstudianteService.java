package com.digitalers.gestion.services;

import com.digitalers.gestion.models.Curso;
import com.digitalers.gestion.models.Estudiante;

import java.util.List;

public interface EstudianteService extends Servicio<Estudiante, Integer>{

    List<Curso> mostrarCursos(Integer id) throws Exception;
}
