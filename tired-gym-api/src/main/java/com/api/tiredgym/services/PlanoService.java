package com.api.tiredgym.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.tiredgym.models.PlanoModel;
import com.api.tiredgym.repositories.PlanoRepository;

import jakarta.transaction.Transactional;

@Service
public class PlanoService {
    private PlanoRepository planoRepository;

    PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public List<PlanoModel> pegarTodos() throws Exception {
        try {
            return planoRepository.pegarTodosPlanos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public PlanoModel salvarPlano(PlanoModel planoModel) throws Exception {
        try {
            return planoRepository.salvarPlano(planoModel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
