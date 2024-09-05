package com.digitalers.gestion.controllers;

import com.digitalers.gestion.models.Estudiante;
import com.digitalers.gestion.services.EstudianteServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/estudiantes")
public class EstudianteController extends ControladorImp<Estudiante, EstudianteServiceImp>{
    public EstudianteController(EstudianteServiceImp servicio){
        super(servicio);
    }
    @GetMapping("/cursos/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.mostrarCursos(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR - Registro no encontrado");
        }
    }

}
