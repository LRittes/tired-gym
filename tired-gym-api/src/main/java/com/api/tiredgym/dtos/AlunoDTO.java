package com.api.tiredgym.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AlunoDTO {

    @NotBlank
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
    @NotBlank
    private String dtNascimento;

    private String codPlan;
    @NotBlank
    private String altura;
    @NotBlank
    private String peso;
}
