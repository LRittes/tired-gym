package com.api.tiredgym.services;

import java.util.List;

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

    public List<AlunoModel> encontreTodos() {
        return alunoRepository.encontreTodos();
    }

    public List<AlunoModel> encontreTodosNoPlano(String categoria) throws Exception {
        try {
            return alunoRepository.encontreTodosNoPlano(categoria);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public AlunoModel salvarAluno(AlunoModel alunoModel) {
        return alunoRepository.salvarAluno(alunoModel);
    }

    public boolean existeCPF(String cpf) {
        return alunoRepository.existeCPF(cpf);
    }
}
