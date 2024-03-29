package com.Tienda.Tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCliente; // Se hace asi porque en la base de datos "C" cambia a _c

    String nombre, apellidos, correo, telefono;
    @JoinColumn(name = "id_credito", referencedColumnName = "id_credito")
    @ManyToOne
    public Credito credito;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }

}
