package com.ifpe.quizzical.entities;

import java.util.List;

import lombok.Data;

@Data
public class ResultadoQuizz {
    private long idUsuario;
    private double acerto;
    private int pontuacao;
    private List<Assunto> assuntosParaMelhorar;
    private List<Materia> materiasParaMelhorar;
    private List<Assunto> assuntosBons;
    private List<Materia> materiasBoas;
    private List<Assunto> assuntosExelentes;
    private List<Materia> materiasExelentes;
     
}
