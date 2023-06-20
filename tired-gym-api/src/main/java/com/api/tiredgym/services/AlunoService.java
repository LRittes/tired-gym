package com.api.tiredgym.services;

import org.springframework.stereotype.Service;

import com.api.tiredgym.models.AlunoModel;
import com.api.tiredgym.repositories.AlunoRepository;

import jakarta.transaction.Transactional;

@Service
public class AlunoService {
    final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public AlunoModel salvarAluno(AlunoModel alunoModel) {
        return alunoRepository.save(alunoModel);
    }
}
