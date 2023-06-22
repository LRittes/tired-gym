package com.api.tiredgym.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tiredgym.dtos.AlunoDTO;
import com.api.tiredgym.dtos.EmailDTO;
import com.api.tiredgym.models.AlunoModel;
import com.api.tiredgym.models.EmailModel;
import com.api.tiredgym.services.AlunoService;
import com.api.tiredgym.services.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/aluno")
public class AlunoController {
    final AlunoService alunoService;
    final EmailService emailService;

    public AlunoController(AlunoService alunoService, EmailService emailService) {
        this.alunoService = alunoService;
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity<Object> pegueTodosAlunos() {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.encontreTodos());

    }

    @PostMapping
    public ResponseEntity<Object> salvarAluno(@RequestBody @Valid AlunoDTO alunoDTO) {
        if (alunoService.existeCPF(alunoDTO.getCpf())) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Aluno já cadastrado!");
        }

        var alunoModel = new AlunoModel();
        BeanUtils.copyProperties(alunoDTO, alunoModel);

        var alunoModelSaved = new AlunoModel();
        BeanUtils.copyProperties(alunoService.salvarAluno(alunoModel), alunoModelSaved);

        Date date = alunoModelSaved.getDt_nascimento();

        ObjectMapper obM = new ObjectMapper();
        var alunoHash = obM.convertValue(alunoModelSaved, HashMap.class);
        alunoHash.remove("emails");

        List<HashMap<String, Object>> emails = new ArrayList<>();

        for (EmailDTO emailDTO : alunoDTO.getEmails()) {
            var emailModel = new EmailModel();
            BeanUtils.copyProperties(emailDTO, emailModel);

            emailModel.setAluno(alunoModel);

            EmailModel emailSaved = emailService.salvarEmail(emailModel);

            HashMap<String, Object> emailHash = new HashMap<>();

            emailHash.put("cod_e", emailSaved.getCod_e());
            emailHash.put("cpf", emailSaved.getAluno().getCpf());
            emailHash.put("email", emailSaved.getEmail());

            emails.add(emailHash);
        }

        alunoHash.put("emails", emails);

        alunoHash.remove("dt_nascimento");
        alunoHash.put("dt_nascimento", date);

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoHash);
    }
}
