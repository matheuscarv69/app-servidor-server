package io.github.matheuscarv69.rest.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormSocialDTO {

    private int id;

    private String nome;

    private int idade;

    private String telefone;

    private String email;

    private String dataEntrevista;
    private String dataNascimento;

    private String funcaoExerc;

    private String tempoFuncaoExerc;

    private String estadoCivil;

    private String escolaridade;

    private int numeroPessoasFam;

    private String grauParentesco;

    private String residencia;

    private boolean beneficio;
    private String beneficioDescricao;

    private boolean programaSocial;
    private String programaSocialDescricao;

    private boolean doencaCronica;
    private String doencaCronicaDescricao;

    private boolean deficienteFamilia;
    private String deficienteFamiliaDesc;

    private boolean acompMedico;
    private String acompMedicoDescricao;

    private boolean suicidioFamilia;
    private String suicidioGrauParentesco;

    private String violencia;
    private String violenciaDescricao;

    private boolean psicoativos; // repensar a abordagem
    private String psicoativosDescricao;

    private boolean conflitoFamiliar;

    private String atividadeLazer;
    private String atividadeLazerDescricao;

    private boolean atividadeFisica;
    private String atividadeFisicaDescricao;

    private String qualidadeVida;

    private String vacinas;



}
