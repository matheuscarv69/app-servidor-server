package io.github.matheuscarv69.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormSocialDTO {

    @ApiModelProperty(value = "ID do formulário", position = 1)
    private int id; //usado na conversao de formSocial p DTO

    @ApiModelProperty(value = "Nome do entrevistado ", position = 2, required = true)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @ApiModelProperty(value = "Idade do entrevistado", position = 3)
    private int idade; //usado na conversao de formSocial p DTO

    @ApiModelProperty(value = "Telefone", position = 4, required = true)
    @NotEmpty(message = "{campo.telefone.obrigatorio}")
    private String telefone;

    @ApiModelProperty(value = "Email", position = 5, required = true)
    @NotEmpty(message = "{campo.email.obrigatorio}")
    @Email(message = "{campo.email.invalido}")
    private String email;

    @ApiModelProperty(value = "Data da entrevista. Dado obtido automáticamente", position = 6)
    private String dataEntrevista;

    @ApiModelProperty(value = "Data de nascimento. Ex: 18/09/1999", position = 8, required = true)
    @NotEmpty(message = "{campo.data-nascimento.obrigatorio}")
    private String dataNascimento;

    @ApiModelProperty(value = "Função exercicida", position = 9, required = true)
    @NotEmpty(message = "{campo.funcao-exercicida.obrigatorio}")
    private String funcaoExerc;

    @ApiModelProperty(value = "Tempo de exercício da função", position = 10, required = true)
    @NotEmpty(message = "{campo.tempo-funcao-exercicida.obrigatorio}")
    private String tempoFuncaoExerc;

    @ApiModelProperty(value = "Estado cívil", allowableValues = "Solteiro(a), Casado(a), União Estável, Separado(a), Divorciado(a), Viuvo(a)", position = 11, required = true)
    @NotEmpty(message = "{campo.estado-civil.obrigatorio}")
    private String estadoCivil;

    @ApiModelProperty(value = "Escolaridade", allowableValues = "Analfabeto, Ensino Fundamental Incompleto, Ensino Fundamental Completo, Ensino Médio Incompleto, Ensino Médio Completo, Ensino Superior Incompleto, Ensino Superior Completo", position = 12, required = true)
    @NotEmpty(message = "{campo.escolaridade.obrigatorio}")
    private String escolaridade;

    @ApiModelProperty(value = "Quantidade de pessoas na familía", position = 13, required = true)
    @NotNull(message = "{campo.numero-pessoas-fam.obrigatorio}")
    @Range(min = 1, max = 30, message = "{campo.numero-pessoas-fam.invalido}")
    private Integer numeroPessoasFam;

    @ApiModelProperty(value = "Grau de parentesco do entrevistado em relação à familía", allowableValues = "Pai, Mãe, Esposo(a), Avos, Filho(a), Irmão(ã), Tio(a), Sobrinho(a), Primo(a), Sogro(a), Enteado(a), Outros", position = 14, required = true)
    @NotEmpty(message = "{campo.grau-parentesco.obrigatorio}")
    private String grauParentesco;

    @ApiModelProperty(value = "Tipo de Residència", allowableValues = "Própria, Alugada, Área de Invasão, Cedida", position = 15, required = true)
    @NotEmpty(message = "{campo.residencia.obrigatorio}")
    private String residencia;

    @ApiModelProperty(value = "Recebe algum beneficio?", allowableValues = "Sim, Não", position = 16, required = true)
    @NotEmpty(message = "{campo.beneficio.obrigatorio}")
    private String beneficio;
    @ApiModelProperty(value = "Tipo do Benefício", allowableValues = "Benefício de Prestação Continuada, Bolsa familía, Crédito Social, Outros (Descrito em texto)", position = 17, required = true)
    private String beneficioDesc;

    @ApiModelProperty(value = "Participa de algum programa social?", allowableValues = "Sim, Não", position = 18, required = true)
    @NotEmpty(message = "{campo.programa-social.obrigatorio}")
    private String programaSocial;

    @ApiModelProperty(value = "Programas Sociais", allowableValues = "Jovem Aprendiz, CREA-CRAS, CAPS I-II-III e AD, Outros (Descrito em texto)", position = 19, required = true)
    private String programaSocialDesc;

    @ApiModelProperty(value = "Doenças Crônicas na familía.", allowableValues = "Câncer, Depressão, Diabetes, Hipertensão, Outros (Descrito em texto)", position = 20, required = true)
    @NotEmpty(message = "{campo.doenca-cronica-desc.obrigatorio}")
    private String doencaCronicaDesc;

    @ApiModelProperty(value = "Há Deficientes na familía?", allowableValues = "Sim, Não", position = 21, required = true)
    @NotEmpty(message = "{campo.deficientes-fam.obrigatorio}")
    private String deficienteFamilia;

    @ApiModelProperty(value = "Quem é o Deficiente na familía? e qual a deficiência?", position = 22)
    private String deficienteFamiliaDesc;

    @ApiModelProperty(value = "Faz Acompanhamento Médico?", allowableValues = "Sim, Não", position = 23, required = true)
    @NotEmpty(message = "{campo.acomp-medico.obrigatorio}")
    private String acompMedico;

    @ApiModelProperty(value = "Qual a especialidade médica do acompanhamento?", position = 24)
    private String acompMedicoDesc;

    @ApiModelProperty(value = "Ocorrência de suicídio na familía", allowableValues = "Sim, Não", position = 25, required = true)
    @NotEmpty(message = "{campo.suicidio-fam.obrigatorio}")
    private String suicidioFamilia;

    @ApiModelProperty(value = "Grau de parentesco do familiar do suicídio", allowableValues = "Pai, Mãe, Esposo(a), Avos, Filho(a), Irmão(ã), Tio(a), Sobrinho(a), Primo(a), Sogro(a), Enteado(a), Outros", position = 26)
    private String suicidioGrauParentesco;

    @ApiModelProperty(value = "Sofreu Violência", allowableValues = "Não, Física, Verbal, Psicologica, Sexual, Patrimonial, Outros", position = 27, required = true)
    @NotEmpty(message = "{campo.violencia-desc.obrigatorio}")
    private String violenciaDesc;

    @ApiModelProperty(value = "Uso de Psicoativos", allowableValues = "Não, Álcool, Cigarro, Drogras Ilicítas, Quais(Descrito em texto)", position = 28, required = true)
    @NotEmpty(message = "{campo.psicoativos-desc.obrigatorio}")
    private String psicoativosDesc;

    @ApiModelProperty(value = "Ocorrência de Conflito Familiar", allowableValues = "Sim, Não", position = 29, required = true)
    @NotEmpty(message = "{campo.conflito-familiar.obrigatorio}")
    private String conflitoFamiliar;

    @ApiModelProperty(value = "Atividades de lazer realizadas", allowableValues = "Não, Atividades Manuais, Atividades Sociais, Atividades Físicas/Esportivas, Atividades Culturais, Outros(Descrito em texto)", position = 30, required = true)
    @NotEmpty(message = "{campo.atividade-lazer-desc.obrigatorio}")
    private String atividadeLazerDesc;

    @ApiModelProperty(value = "Realiza Atividade Física", allowableValues = "Sim, Não", position = 31, required = true)
    @NotEmpty(message = "{campo.atividade-fisica.obrigatorio}")
    private String atividadeFisica;

    @ApiModelProperty(value = "Qual Atividade Física é realizada? (Descrito em texto)", position = 32)
    private String atividadeFisicaDesc;

    @ApiModelProperty(value = "Qualidade de Vida", allowableValues = "Excelente, Regular, Boa, Ruim", position = 33, required = true)
    @NotEmpty(message = "{campo.qualidade-vida.obrigatorio}")
    private String qualidadeVida;

    @ApiModelProperty(value = "Vacinas em dia", allowableValues = "Sim, Não, Não sabe", position = 34, required = true)
    @NotEmpty(message = "{campo.vacinas.obrigatorio}")
    private String vacinas;


}
