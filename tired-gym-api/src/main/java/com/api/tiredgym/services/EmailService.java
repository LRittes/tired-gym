package com.api.tiredgym.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.tiredgym.models.EmailModel;
import com.api.tiredgym.repositories.EmailRepository;

import jakarta.transaction.Transactional;

@Service
public class EmailService {
    final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Transactional
    public EmailModel salvarEmail(EmailModel emailModel) {
        return emailRepository.save(emailModel);
    }

    // public List<EmailModel> encontreTodosPorCPF(String cpf) {
    // return emailRepository.encontreTodosPorCPF(cpf);
    // }
}
