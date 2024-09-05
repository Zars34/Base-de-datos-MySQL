package com.digitalers.gestion.controllers;

import com.digitalers.gestion.models.Instructor;
import com.digitalers.gestion.services.InstructorServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/instructores")
public class InstructorController extends ControladorImp<Instructor, InstructorServiceImp>{
    public InstructorController(InstructorServiceImp servicio){
        super(servicio);
    }

    @GetMapping("/cursos/{id}")
    public ResponseEntity<?> getAll(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.mostrarCursosPorInstructor(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR - Registros no encontrados\n" + e.getMessage());
        }
    }

}
