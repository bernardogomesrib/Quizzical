package com.ifpe.quizzical.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifpe.quizzical.entities.MateriaEAssunto;
import com.ifpe.quizzical.entities.Questao;
import com.ifpe.quizzical.entities.RespostaUsuario;
import com.ifpe.quizzical.repositories.RepositoryQuestao;
import com.ifpe.quizzical.repositories.RepositoryRespostaUsuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/questao")
@Tag(name = "api de perguntas")
public class Controller {
    @Autowired
    private RepositoryQuestao rsq;
    @Autowired
    private RepositoryRespostaUsuario rus;
    @Operation(summary = "Busca uma pergunta completa com base no seu ID",method = "GET")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/buscar/{id}")
    public Optional<Questao> pegaicarai(@PathVariable long id){
        return rsq.findById(id);
    }
    @Operation(summary = "Cadastra uma pergunta completa como for informada",method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro de Questão realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar cadastro de questão"),
        })
    @PreAuthorize("hasRole('ADM')")
    @PostMapping("/cadastrar/")
    public Questao cadastrar(@RequestBody Questao qst){
            return rsq.save(qst);
    }
    @Operation(summary = "Procura Respostas de um usuário a uma pergunta",method = "GET")
    @PreAuthorize("hasRole('ADM')")
    @GetMapping("/respostasdousuario/{idUsuario}/{idPergunta}")
    public List<RespostaUsuario> procuraRespostasDoUsuarioParaPegunta(@PathVariable long idUsuario,@PathVariable long idPergunta){
        return rus.FindRespostaDoUsuarioParaPergunta(idUsuario, idPergunta);
    }
    @Operation(summary = "Busca rodas as respostas de usuário de uma pergunta",method = "GET")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/respostausuario/questao/{id}")
    public List<RespostaUsuario> pegarRespostasDousuarioPorPergunta(@PathVariable long id){
        return rus.FindByquestao_id(id);
    }
    @Operation(summary = "Pega todas as respostas de um usuário",method = "GET")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/respostausuario/usuario/{id}")
    public List<RespostaUsuario> pegarRespostasDousuarioPorUsuario(@PathVariable long id){
        return rus.FindByUsuarioId(id);
    }
    @Operation(summary = "Busca todas as perguntas com base na materia e assunto",method = "GET")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/buscar/{materia}/{assunto}/")
    public List<Questao> procuraQuestaoporMateriaEAssunto(@PathVariable String materia,@PathVariable String assunto){
        return rsq.findByAssuntoEMateria(materia, assunto);
    }
    @Operation(summary = "Busca uma pergunta com base na materia, assunto e o id da pergunta",method = "GET")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/buscar/{materia}/{assunto}/{id}")
    public Questao procuraQuestaoporMateriaEAssunto(@PathVariable String materia,@PathVariable String assunto,@PathVariable long id){
        return rsq.findByAssuntoMateriaeId(materia, assunto,id);
    }
    @Operation(summary = "Mostra a quantidade de matérias e assuntos no banco de dados",method = "GET")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/informacoes/")
    public List<MateriaEAssunto> pegaInformacoesdobanco(){
        return rsq.findMateriaEAssunto();
    }
}
