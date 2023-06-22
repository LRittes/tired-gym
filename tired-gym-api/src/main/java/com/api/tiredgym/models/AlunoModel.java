package com.api.tiredgym.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ALUNOS")
public class AlunoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String cpf;
    @Column(nullable = false)
    private String nome;
    @OneToMany(mappedBy = "aluno")
    private List<EmailModel> emails;
    @Column(nullable = false)
    private String digital;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false, length = 1)
    private String sexo;
    @Column(nullable = false)
    private String foto;
    @Column(nullable = false)
    private Date dt_nascimento;
    @Column
    private String cod_plan;
    @Column(nullable = false)
    private float altura;
    @Column(nullable = false)
    private float peso;

}
