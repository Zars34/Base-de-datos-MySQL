package com.digitalers.gestion.controllers;

import com.digitalers.gestion.models.Entidad;
import com.digitalers.gestion.services.ServicioImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class ControladorImp<T extends Entidad, S extends ServicioImp<T, Integer>>
        implements Controller<T, Integer> {
    protected S servicio;

    public ControladorImp(S servicio) {this.servicio = servicio;}

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR - Registros no encontrados");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR - Registro no encontrado");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody T entidad) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entidad));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR - Registro no guardado\n" + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody T entidad, @PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(entidad, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR - Registro no actualizado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR - Registro no borrado");
        }
    }


}
