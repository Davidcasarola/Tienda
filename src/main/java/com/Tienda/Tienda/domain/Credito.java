package com.Tienda.Tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "credito")
@Entity

public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credito")
    private long idCredito; //id_credito
    public double limite;

    public Credito() {
    }

    public Credito(double limit) {
        this.limite = limite;
    }

}
