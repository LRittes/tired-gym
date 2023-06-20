package com.api.tiredgym.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ALUNOS")
public class AlunoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    protected String cpf;
    @Column(nullable = false)
    protected String nome;
    @Column(nullable = false)
    protected String digital;
    @Column(nullable = false)
    protected String telefone;
    @Column(nullable = false, length = 1)
    protected String sexo;
    @Column(nullable = false)
    protected String foto;
    @Column(nullable = false)
    protected String dtNascimento;
    @Column
    private String codPlan;
    @Column(nullable = false)
    private String altura;
    @Column(nullable = false)
    private String peso;

}
