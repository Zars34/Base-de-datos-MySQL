package com.digitalers.gestion.controllers;

import com.digitalers.gestion.models.Curso;
import com.digitalers.gestion.services.CursoServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cursos")
public class CursoController extends ControladorImp<Curso, CursoServiceImp>{
    public CursoController(CursoServiceImp servicio){
        super(servicio);
    }

    //Aqui es donde tenemos que agregar la funcionalidad
    @GetMapping("/integrantes/{id}")
    public ResponseEntity<?> getAll(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.mostrarEstudiantes(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR - Registros no encontrados");
        }
    }

}
