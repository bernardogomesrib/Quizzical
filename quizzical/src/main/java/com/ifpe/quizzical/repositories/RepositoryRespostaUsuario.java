package com.ifpe.quizzical.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifpe.quizzical.entities.RespostaUsuario;

public interface RepositoryRespostaUsuario extends JpaRepository<RespostaUsuario,Long>{
    @Query("SELECT a FROM RespostaUsuario a WHERE a.questao.id = :idquestao")
    List<RespostaUsuario> FindByquestao_id(@Param("idquestao") Long idquestao);
    @Query("SELECT a FROM RespostaUsuario a WHERE a.idUsuario = :idquestao")
    List<RespostaUsuario> FindByUsuarioId(@Param("idquestao") Long idquestao);
    @Query("SELECT a FROM RespostaUsuario a WHERE a.idUsuario = :idUsuario and a.questao.id = :idquestao")
    List<RespostaUsuario> FindRespostaDoUsuarioParaPergunta(@Param("idUsuario") long idUsuario,@Param("idquestao") long idquestao);
}
