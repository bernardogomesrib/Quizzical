package com.ifpe.quizzical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.quizzical.entities.RespostaArquivo;

public interface RepositoryRespostaEmArquivo extends JpaRepository<RespostaArquivo,Long> {
}
