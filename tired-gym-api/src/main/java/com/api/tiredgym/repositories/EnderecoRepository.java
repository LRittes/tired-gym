package com.api.tiredgym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.tiredgym.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

}
