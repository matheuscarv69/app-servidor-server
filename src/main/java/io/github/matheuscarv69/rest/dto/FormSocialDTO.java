package io.github.matheuscarv69.rest.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormSocialDTO {

    private int id; //usado na conversao de formSocial p DTO

    @NotEmpty(message = "Campo Nome é obrigatório.")
    private String nome;

    private int idade; //usado na conversao de formSocial p DTO

    @NotEmpty(message = "Campo Telefone é obrigatório.")
    private String telefone;

    @NotEmpty(message = "Campo Email é obrigatório.")
    private String email;

    private String dataEntrevista; // usado na conversao de formSocial p DTO
//    @NotEmpty(message = "Campo Data de Nascimento é obrigatório.")
    private String dataNascimento;

    @NotEmpty(message = "Campo Função Exercicida é obrigatório.")
    private String funcaoExerc;

    @NotEmpty(message = "Campo Tempo de Exercício é obrigatório.")
    private String tempoFuncaoExerc;

    @NotEmpty(message = "Campo Estado Cívil é obrigatório.")
    private String estadoCivil;

    @NotEmpty(message = "Campo Escolaridade é obrigatório.")
    private String escolaridade;

//    @NotEmpty(message = "Campo Número de Pessoas na Família é obrigatório.")
    private int numeroPessoasFam;

    @NotEmpty(message = "Campo Grau de Parentesco é obrigatório.")
    private String grauParentesco;

    @NotEmpty(message = "Campo Residência é obrigatório.")
    private String residencia;

//    @NotEmpty(message = "Campo Recebe algum Benefício é obrigatório.")
    private boolean beneficio;
    private String beneficioDesc;

//    @NotEmpty(message = "Campo Participa de Programa Social é obrigatório.")
    private boolean programaSocial;
    private String programaSocialDesc;

//    @NotEmpty(message = "Campo Doença Crônica na Família é obrigatório.")
    private boolean doencaCronica; // Nao possui no form, mas e interessante por
    private String doencaCronicaDesc;

//    @NotEmpty(message = "Campo Deficientes na família é obrigatório.")
    private boolean deficienteFamilia;
    private String deficienteFamiliaDesc;

//    @NotEmpty(message = "Campo Recebe Acompanhamento Médico é obrigatório.")
    private boolean acompMedico;
    private String acompMedicoDesc;

//    @NotEmpty(message = "Campo Ocorrência de Suicídio é obrigatório.")
    private boolean suicidioFamilia;
    private String suicidioGrauParentesco;

//    @NotEmpty(message = "Campo Ocorrência de Violência é obrigatório.")
    private boolean violencia;
    private String violenciaDesc;

//    @NotEmpty(message = "Campo Consumo de Psicoativos é obrigatório.")
    private boolean psicoativos; // repensar a abordagem
    private String psicoativosDesc;

//    @NotEmpty(message = "Campo Conflito Familiar é obrigatório.")
    private boolean conflitoFamiliar;

    @NotEmpty(message = "Campo Atividades de Lazer é obrigatório.")
    private String atividadeLazerDesc; // nao possui campo de sim, somente nao

//    @NotEmpty(message = "Campo Atividades Físicas é obrigatório.")
    private boolean atividadeFisica;
    private String atividadeFisicaDesc;

    @NotEmpty(message = "Campo Qualidade de Vida é obrigatório.")
    private String qualidadeVida;

    @NotEmpty(message = "Campo Vacinas é obrigatório.")
    private String vacinas;


}
