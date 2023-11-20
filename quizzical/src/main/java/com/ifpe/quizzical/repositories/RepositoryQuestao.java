package com.ifpe.quizzical.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifpe.quizzical.entities.MateriaEAssunto;
import com.ifpe.quizzical.entities.Questao;


public interface RepositoryQuestao extends JpaRepository<Questao,Long> {
    Optional<Questao> findById(Long id);
    @Query("SELECT ob FROM Questao ob WHERE ob.assunto = :assunto")
    List<Questao> findByAssunto(@Param("assunto") String assunto);
    @Query("SELECT ob FROM Questao ob WHERE ob.assunto = :assunto AND ob.materia = :materia")
    List<Questao> findByAssuntoEMateria(@Param("materia")String materia, @Param("assunto") String assunto);
    @Query("SELECT ob FROM Questao ob WHERE ob.assunto = :assunto AND ob.materia = :materia AND id = :id")
    Questao findByAssuntoMateriaeId(@Param("materia")String materia, @Param("assunto") String assunto,@Param("id")long id);
    @Query(nativeQuery = true)
    List<MateriaEAssunto> findMateriaEAssunto();
}
