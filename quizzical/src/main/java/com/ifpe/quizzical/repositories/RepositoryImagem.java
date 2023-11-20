package com.ifpe.quizzical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.quizzical.entities.Imagem;

public interface RepositoryImagem extends JpaRepository<Imagem,Long> {
}
