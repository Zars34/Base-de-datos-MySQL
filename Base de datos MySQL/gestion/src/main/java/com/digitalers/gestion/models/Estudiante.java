package com.digitalers.gestion.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.bytecode.enhance.internal.bytebuddy.EnhancerImpl;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "estudiantes")
public class Estudiante extends Entidad {


    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false,
    name = "fecha_nacimiento")
    private LocalDate fechaDeNacimiento;

    @OneToOne(optional = true)
    @JoinColumn(name = "id_contacto", referencedColumnName = "id")
    private Contacto contacto;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos = new ArrayList<>();

}
