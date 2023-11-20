package com.ifpe.quizzical.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class RespostaArquivo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private boolean correta;
    private String explicacao;
    private String link;
    private String tipo;
    private String transcricao;
    @ManyToOne
    @JoinColumn(name = "questao_id")
    @JsonBackReference
    private Questao questao;
   
    
}
