package com.api.tiredgym.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PLANO")
public class PlanoModel implements Serializable {
    @Id
    @Column(nullable = false)
    private String cod_plan;

    @Column(nullable = false)
    private Date dt_vencimento;

    @Column(nullable = false)
    private float preco_ano;

    @Column(nullable = false)
    private float preco_mes;

    @Column(nullable = false)
    private String Categoria;
}
