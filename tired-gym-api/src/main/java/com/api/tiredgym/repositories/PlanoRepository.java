package com.api.tiredgym.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.tiredgym.models.AlunoModel;
import com.api.tiredgym.models.PlanoModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class PlanoRepository {
    @PersistenceContext
    private EntityManager em;

    public List<PlanoModel> pegarTodosPlanos() {
        String sql = "SELECT * FROM PLANO";
        Query query = em.createNativeQuery(sql, PlanoModel.class);

        return query.getResultList();
    }

    @Transactional
    public PlanoModel salvarPlano(PlanoModel planoModel) throws Exception {
        String sql = "insert into Plano (cod_plan, dt_vencimento,preco_ano,preco_mes,categoria) values (:cod_plan,:dt_vencimento,:preco_ano,:preco_mes,:categoria)";

        Query query = em.createNativeQuery(sql, PlanoModel.class);
        query.setParameter("cod_plan", planoModel.getCod_plan());
        query.setParameter("dt_vencimento", planoModel.getDt_vencimento());
        query.setParameter("preco_ano", planoModel.getPreco_ano());
        query.setParameter("preco_mes", planoModel.getPreco_mes());
        query.setParameter("categoria", planoModel.getCategoria());
        try {
            query.executeUpdate();
            return planoModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
