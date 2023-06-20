package com.api.tiredgym.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tiredgym.dtos.AlunoDTO;
import com.api.tiredgym.models.AlunoModel;
import com.api.tiredgym.services.AlunoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/aluno")
public class AlunoController {
    final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarAluno(@RequestBody @Valid AlunoDTO alunoDTO) {
        var alunoModel = new AlunoModel();
        BeanUtils.copyProperties(alunoDTO, alunoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvarAluno(alunoModel));
    }
}
