package com.digitalers.gestion.controllers;

import com.digitalers.gestion.models.Entidad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface Controller<T extends Entidad, N extends Serializable> {
    ResponseEntity<? extends Object> getAll();

    ResponseEntity<? extends Object> getOne(@PathVariable N id);

    ResponseEntity<? extends Object> save(@RequestBody T entidad);

    ResponseEntity<? extends Object> update(@RequestBody T entidad, @PathVariable N id);

    ResponseEntity<? extends Object> delete(@PathVariable N id);
}
