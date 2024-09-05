package com.digitalers.gestion.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso extends Entidad{

    @Column(nullable = false)
    private String nombre;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_instructor", referencedColumnName = "id")
    private Instructor instructor;

}
