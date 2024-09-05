package com.digitalers.gestion.controllers;

import com.digitalers.gestion.models.Contacto;
import com.digitalers.gestion.services.ContactoServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/contactos")
public class ContactoController extends ControladorImp<Contacto, ContactoServiceImp> {
    public ContactoController(ContactoServiceImp servicio) {super(servicio);}

    @GetMapping("/estudiante/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.mostrarEstudiante(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR - Registros no encontrados");
        }
    }

}
