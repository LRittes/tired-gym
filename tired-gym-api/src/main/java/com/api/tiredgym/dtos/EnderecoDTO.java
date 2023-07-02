package com.api.tiredgym.dtos;

import com.api.tiredgym.models.AlunoModel;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EnderecoDTO {

    @NotBlank
    private String rua;
    @NotBlank
    private String bairro;
    @Min(1)
    private int numero;
    @NotBlank
    private String cidade;
    @NotBlank
    @Size(max = 2)
    private String uf;
    private AlunoModel aluno;
}
