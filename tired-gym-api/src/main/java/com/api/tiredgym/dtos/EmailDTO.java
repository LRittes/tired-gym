package com.api.tiredgym.dtos;

import com.api.tiredgym.models.AlunoModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmailDTO {
    @NotBlank
    @Size(max = 11)
    private String cpf;
    @NotBlank
    private String email;
    private AlunoModel aluno;
}
