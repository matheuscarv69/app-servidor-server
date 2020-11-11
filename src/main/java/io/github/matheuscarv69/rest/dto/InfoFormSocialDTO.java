package io.github.matheuscarv69.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoFormSocialDTO {

    private Integer id;
    private String nome;
    private Integer idade;
    private String dataNascismento;
    private String dataEntrevista;
    private String telefone;
    private String email;
    private String funcaoExerc;
    private String tempoFuncaoExerc;
    private String estadoCivil;
    private String escolaridade;
    private Integer numeroPessoasFam;
    private String grauParentesco;
    private String residencia;
    private String beneficio;
    private String beneficiosCadastrados;
    private String outroBeneficioDesc;
    private String programaSocial;
    private String programasSociaisCadastrados;
    private String outroProgramaSocialDesc;
    private String doencaCronica;
    private String doencaCronicaCadastradas;
    private String outraDoencaCronicaDesc;

    private String deficienteFamilia;
    private String deficienteFamiliaDescricao;
    private String acompanhamentoMedico;
    private String acompanhamentoMedicoDesc;

    private String suicidioFamilia;
    private String suicidioGrauParentesco;

    private String violencia;
    private String violenciasCadastradas;
    private String outraViolenciaDescricao;

    private String psicoativos;
    private String psicoativosCadastrados;
    private String outrosPsicoativosDescricao;

    private String conflitoFamiliar;

    private String atividadesLazer;
    private String atividadesLazerCadastradas;
    private String outrasAtividadesLazerDesc;

    private String atividadeFisica;
    private String atividadeFisicaDesc;

    private String qualidadeVida;

    private String vacinas;
}
