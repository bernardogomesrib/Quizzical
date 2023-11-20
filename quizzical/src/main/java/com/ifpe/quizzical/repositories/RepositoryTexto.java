package com.ifpe.quizzical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.quizzical.entities.Texto;

public interface RepositoryTexto extends JpaRepository<Texto,Long> {
}
