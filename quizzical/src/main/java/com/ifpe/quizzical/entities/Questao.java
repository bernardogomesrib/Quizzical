package com.ifpe.quizzical.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;


@SqlResultSetMapping(
    name = "MateriaEAssuntoMapping",
    classes = @ConstructorResult(
        targetClass = MateriaEAssunto.class,
        columns = {
            @ColumnResult(name = "materia", type = String.class),
            @ColumnResult(name = "assunto", type = String.class),
            @ColumnResult(name = "quantidade", type = Integer.class)
        }
    )
)
@NamedNativeQuery(
    name = "Questao.findMateriaEAssunto",
    query = "SELECT materia, assunto, COUNT(*) as quantidade FROM questao GROUP BY materia, assunto",
    resultSetMapping = "MateriaEAssuntoMapping"
)

@Entity
public class Questao {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String materia;
    private String assunto;
    private String tipo;
    private int ordem;
    private String pergunta;
    @OneToMany(mappedBy = "questao",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Imagem>imagens;
    @OneToMany(mappedBy = "questao",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Texto>textos;
    @OneToMany(mappedBy = "questao",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<RespostaArquivo>respostaArquivos;
    @OneToMany(mappedBy = "questao",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<RespostaEmTexto>respostaEmTextos;
    @OneToMany(mappedBy = "questao",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<RespostaFunc>respostaFuncs;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }
    public String getAssunto() {
        return assunto;
    }
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getOrdem() {
        return ordem;
    }
    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
    public String getPergunta() {
        return pergunta;
    }
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
    public List<Imagem> getImagens() {
        return imagens;
    }
    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }
    public List<Texto> getTextos() {
        return textos;
    }
    public void setTextos(List<Texto> textos) {
        this.textos = textos;
    }
    public List<RespostaArquivo> getRespostaArquivos() {
        return respostaArquivos;
    }
    public void setRespostaArquivos(List<RespostaArquivo> respostaArquivos) {
        this.respostaArquivos = respostaArquivos;
    }
    public List<RespostaEmTexto> getRespostaEmTextos() {
        return respostaEmTextos;
    }
    public void setRespostaEmTextos(List<RespostaEmTexto> respostaEmTextos) {
        this.respostaEmTextos = respostaEmTextos;
    }
    public List<RespostaFunc> getRespostaFuncs() {
        return respostaFuncs;
    }
    public void setRespostaFuncs(List<RespostaFunc> respostaFuncs) {
        this.respostaFuncs = respostaFuncs;
    }
    public Questao(){}
    public Questao(Object ob){
        this.id = Long.parseLong(ob.toString());
    }
    public Questao  (long id,String materia,String assunto,int ordem,String tipo,String pergunta,List<Imagem> imagens,List<Texto> textos,List<RespostaArquivo> respostaArquivos,List<RespostaEmTexto>  respostaEmTextos,List<RespostaFunc> respostaFuncs)
    {
        this.id = id;
        this.ordem = ordem;
        this.textos = textos;
        this.imagens = imagens;
        this.materia = materia;
        this.assunto = assunto;
        this.pergunta = pergunta;
        this.respostaFuncs = respostaFuncs;
        this.respostaArquivos = respostaArquivos;
        this.respostaEmTextos = respostaEmTextos;
        this.tipo = tipo;

    } 
}
