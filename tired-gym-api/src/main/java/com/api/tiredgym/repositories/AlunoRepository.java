package com.api.tiredgym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.tiredgym.models.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, String> {

}
