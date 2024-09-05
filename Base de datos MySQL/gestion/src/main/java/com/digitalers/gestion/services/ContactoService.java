package com.digitalers.gestion.services;

import com.digitalers.gestion.models.Contacto;
import com.digitalers.gestion.models.Estudiante;

public interface ContactoService extends Servicio<Contacto, Integer>{

    Estudiante mostrarEstudiante(Integer id_contacto) throws Exception;

}