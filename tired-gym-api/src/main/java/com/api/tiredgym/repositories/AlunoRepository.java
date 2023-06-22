package com.api.tiredgym.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.tiredgym.models.AlunoModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class AlunoRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public AlunoModel salvarAluno(AlunoModel alunoModel) {
        String sql = "insert into alunos (cpf,nome,digital,telefone,sexo,foto,dt_nascimento,cod_plan,altura,peso) Values (:cpf, :nome,:digital,:telefone,:sexo,:foto,:dt_nascimento,:cod_plan,:altura,:peso)";
        Query query = em.createNativeQuery(sql, AlunoModel.class);
        query.setParameter("cpf", alunoModel.getCpf());
        query.setParameter("nome", alunoModel.getNome());
        query.setParameter("digital", alunoModel.getDigital());
        query.setParameter("telefone", alunoModel.getTelefone());
        query.setParameter("sexo", alunoModel.getSexo());
        query.setParameter("foto", alunoModel.getFoto());
        query.setParameter("dt_nascimento", alunoModel.getDt_nascimento());
        query.setParameter("cod_plan", alunoModel.getCod_plan());
        query.setParameter("altura", alunoModel.getAltura());
        query.setParameter("peso", alunoModel.getPeso());
        query.executeUpdate();
        return alunoModel;
    }

    public boolean existeCPF(String cpf) {
        String sql = "SELECT * FROM ALUNOS al WHERE al.cpf = :cpf";
        Query query = em.createNativeQuery(sql, AlunoModel.class);
        query.setParameter("cpf", cpf);
        try {
            query.getSingleResult();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<AlunoModel> encontreTodos() {
        String sql = "SELECT * FROM ALUNOS";
        Query query = em.createNativeQuery(sql, AlunoModel.class);
        return query.getResultList();
    }
}
