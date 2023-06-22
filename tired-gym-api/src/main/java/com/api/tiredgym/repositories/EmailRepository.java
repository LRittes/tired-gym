package com.api.tiredgym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.tiredgym.models.EmailModel;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, String> {
}
