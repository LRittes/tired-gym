package com.api.tiredgym.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EMAIL")
public class EmailModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int cod_e;
    @ManyToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    private AlunoModel aluno;
    @Column(nullable = false)
    private String email;
}
