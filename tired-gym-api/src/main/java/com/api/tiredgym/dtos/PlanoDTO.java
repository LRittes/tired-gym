package com.api.tiredgym.dtos;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlanoDTO {
    @NotBlank
    private String cod_plan;

    @NotNull
    private Date dt_vencimento;

    @Min(1)
    @NotNull
    private float preco_ano;

    @Min(1)
    @NotNull
    private float preco_mes;

    @NotBlank
    private String Categoria;
}
