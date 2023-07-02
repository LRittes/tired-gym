package com.api.tiredgym.controllers;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tiredgym.dtos.PlanoDTO;
import com.api.tiredgym.models.PlanoModel;
import com.api.tiredgym.services.PlanoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/plano")
public class PlanoController {
    final PlanoService planoService;

    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @GetMapping
    public ResponseEntity<Object> pegarTodos() {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(planoService.pegarTodos());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
        }
    }

    @PostMapping
    public ResponseEntity<Object> salvarPlano(@RequestBody @Valid PlanoDTO planoDTO) {
        var planoModel = new PlanoModel();
        BeanUtils.copyProperties(planoDTO, planoModel);

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(planoService.salvarPlano(planoModel));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
        }
    }
}
