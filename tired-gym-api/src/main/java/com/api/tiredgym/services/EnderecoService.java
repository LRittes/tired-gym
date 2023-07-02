package com.api.tiredgym.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.tiredgym.models.EmailModel;
import com.api.tiredgym.models.Endereco;
import com.api.tiredgym.repositories.EmailRepository;
import com.api.tiredgym.repositories.EnderecoRepository;

import jakarta.transaction.Transactional;

@Service
public class EnderecoService {
    final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Transactional
    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    // public List<EmailModel> encontreTodosPorCPF(String cpf) {
    // return emailRepository.encontreTodosPorCPF(cpf);
    // }
}
