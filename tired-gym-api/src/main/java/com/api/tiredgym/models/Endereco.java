package com.api.tiredgym.models;

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
@Table(name = "Endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int cod_en;
    @ManyToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    private AlunoModel aluno;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private int numero;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String uf;
}
