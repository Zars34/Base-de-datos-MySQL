package com.digitalers.gestion.services;

import com.digitalers.gestion.models.Entidad;

import java.io.Serializable;
import java.util.List;

public interface Servicio<T extends Entidad, N extends Serializable> {

    List<T> findAll() throws Exception;

    T findById(N id) throws Exception;

    T save(T entidad) throws Exception;

    T update(T entidad, N id) throws Exception;

    Boolean delete(N id) throws Exception;
}
