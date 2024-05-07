package com.example.crud.DB;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "notas")
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notas_sequence")
    @SequenceGenerator(name = "notas_sequence", sequenceName = "notas_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    private String nombre_estudiante;

    private String materia;

    private Integer nota;

    private Integer salón;

    private String descripción;
}


