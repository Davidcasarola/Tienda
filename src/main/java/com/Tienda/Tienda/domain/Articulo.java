package com.Tienda.Tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "articulo")

public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "id_articulo")

    private long idArticulo; //id_Articulo
    private long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private boolean activo;

    public Articulo() {
    }

    public Articulo(long idCategoria, String descripcion, String detalle, double precio, int existencias, boolean activo) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }



}
