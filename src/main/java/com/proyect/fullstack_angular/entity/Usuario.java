package com.proyect.fullstack_angular.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tausuariostest")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "email")
    private String email;


    @Column(name = "fecha_modificacion", nullable = false)
    private LocalDate fechaModificacion;

    /*@PrePersist
    protected void onCreate() {
        this.fechaAlta = LocalDate.now();
        this.fechaModificacion = LocalDate.now();
    }*/

    @PreUpdate
    protected void onUpdate() {
        this.fechaModificacion = LocalDate.now();
    }

}
