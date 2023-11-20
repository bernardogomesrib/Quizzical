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
public class RespostaUsuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "questao_id")
    @JsonBackReference
    private Questao questao;
    private long idUsuario;
    private String resposta;
    private String explicacao;
    private boolean correta;
    
}
