package com.api.tiredgym.dtos;

import java.sql.Date;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlunoDTO {

    @NotBlank
    @Size(max = 11)
    private String cpf;
    @NotBlank
    private String nome;
    @NotBlank
    private String digital;
    @NotBlank
    private String telefone;
    @NotBlank
    private String sexo;
    @NotBlank
    private String foto;
    @NotNull
    private Date dt_nascimento;

    @NotEmpty
    private List<EmailDTO> emails;

    private String codPlan;
    @NotNull
    @Min(1)
    private float altura;
    @NotNull
    @Min(1)
    private float peso;
}
