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
    @NotEmpty(message = "Campo Nome é obrigatório.")
    private String nome;

    @ApiModelProperty(value = "Idade do entrevistado", position = 3)
    private int idade; //usado na conversao de formSocial p DTO

    @ApiModelProperty(value = "Telefone", position = 4, required = true)
    @NotEmpty(message = "Campo Telefone é obrigatório.")
    private String telefone;

    @ApiModelProperty(value = "Email", position = 5, required = true)
    @NotEmpty(message = "Campo Email é obrigatório.")
    @Email(message = "O Email informado é inválido.")
    private String email;

    @ApiModelProperty(value = "Data da entrevista. Dado obtido automáticamente", position = 6)
    private String dataEntrevista;

    @ApiModelProperty(value = "Data de nascimento. Ex: 18/09/1999", position = 8, required = true)
    @NotEmpty(message = "Campo Data de Nascimento é obrigatório.")
    private String dataNascimento;

    @ApiModelProperty(value = "Função exercicida", position = 9, required = true)
    @NotEmpty(message = "Campo Função Exercicida é obrigatório.")
    private String funcaoExerc;

    @ApiModelProperty(value = "Tempo de exercício da função", position = 10, required = true)
    @NotEmpty(message = "Campo Tempo de Exercício é obrigatório.")
    private String tempoFuncaoExerc;

    @ApiModelProperty(value = "Estado cívil", allowableValues = "Solteiro(a), Casado(a), União Estável, Separado(a), Divorciado(a), Viuvo(a)", position = 11, required = true)
    @NotEmpty(message = "Campo Estado Cívil é obrigatório.")
    private String estadoCivil;

    @ApiModelProperty(value = "Escolaridade", allowableValues = "Analfabeto, Ensino Fundamental Incompleto, Ensino Fundamental Completo, Ensino Médio Incompleto, Ensino Médio Completo, Ensino Superior Incompleto, Ensino Superior Completo", position = 12, required = true)
    @NotEmpty(message = "Campo Escolaridade é obrigatório.")
    private String escolaridade;

    @ApiModelProperty(value = "Quantidade de pessoas na familía", position = 13, required = true)
    @NotNull(message = "Campo Número de Pessoas na Família é obrigatório.")
    @Range(min = 1, max = 30, message = "Número de pessoas informado é inválido.")
    private Integer numeroPessoasFam;

    @ApiModelProperty(value = "Grau de parentesco do entrevistado em relação à familía", allowableValues = "Pai, Mãe, Esposo(a), Avos, Filho(a), Irmão(ã), Tio(a), Sobrinho(a), Primo(a), Sogro(a), Enteado(a), Outros", position = 14, required = true)
    @NotEmpty(message = "Campo Grau de Parentesco é obrigatório.")
    private String grauParentesco;

    @ApiModelProperty(value = "Tipo de Residència", allowableValues = "Própria, Alugada, Área de Invasão, Cedida", position = 15, required = true)
    @NotEmpty(message = "Campo Residência é obrigatório.")
    private String residencia;

    @ApiModelProperty(value = "Recebe algum beneficio?", allowableValues = "Sim, Não", position = 16, required = true)
    @NotEmpty(message = "Campo Recebe algum Benefício é obrigatório.")
    private String beneficio;
    @ApiModelProperty(value = "Tipo do Benefício", allowableValues = "Benefício de Prestação Continuada, Bolsa familía, Crédito Social, Outros (Descrito em texto)", position = 17, required = true)
    private String beneficioDesc;

    @ApiModelProperty(value = "Participa de algum programa social?", allowableValues = "Sim, Não", position = 18, required = true)
    @NotEmpty(message = "Campo Participa de Programa Social é obrigatório.")
    private String programaSocial;

    @ApiModelProperty(value = "Programas Sociais", allowableValues = "Jovem Aprendiz, CREA-CRAS, CAPS I-II-III e AD, Outros (Descrito em texto)", position = 19, required = true)
    private String programaSocialDesc;

    @ApiModelProperty(value = "Doenças Crônicas na familía.", allowableValues = "Câncer, Depressão, Diabetes, Hipertensão, Outros (Descrito em texto)", position = 20, required = true)
    @NotEmpty(message = "Campo Doença Crônica Descrição na Família é obrigatório.")
    private String doencaCronicaDesc;

    @ApiModelProperty(value = "Há Deficientes na familía?", allowableValues = "Sim, Não", position = 21, required = true)
    @NotEmpty(message = "Campo Deficientes na família é obrigatório.")
    private String deficienteFamilia;

    @ApiModelProperty(value = "Quem é o Deficiente na familía? e qual a deficiência?", position = 22)
    private String deficienteFamiliaDesc;

    @ApiModelProperty(value = "Faz Acompanhamento Médico?", allowableValues = "Sim, Não", position = 23, required = true)
    @NotEmpty(message = "Campo Recebe Acompanhamento Médico é obrigatório.")
    private String acompMedico;

    @ApiModelProperty(value = "Qual a especialidade médica do acompanhamento?", position = 24)
    private String acompMedicoDesc;

    @ApiModelProperty(value = "Ocorrência de suicídio na familía", allowableValues = "Sim, Não", position = 25, required = true)
    @NotEmpty(message = "Campo Ocorrência de Suicídio é obrigatório.")
    private String suicidioFamilia;

    @ApiModelProperty(value = "Grau de parentesco do familiar do suicídio", allowableValues = "Pai, Mãe, Esposo(a), Avos, Filho(a), Irmão(ã), Tio(a), Sobrinho(a), Primo(a), Sogro(a), Enteado(a), Outros", position = 26)
    private String suicidioGrauParentesco;

    @ApiModelProperty(value = "Sofreu Violência", allowableValues = "Não, Física, Verbal, Psicologica, Sexual, Patrimonial, Outros", position = 27, required = true)
    @NotEmpty(message = "Campo Violência Descrição é obrigatório.")
    private String violenciaDesc;

    @ApiModelProperty(value = "Uso de Psicoativos", allowableValues = "Não, Álcool, Cigarro, Drogras Ilicítas, Quais(Descrito em texto)", position = 28, required = true)
    @NotEmpty(message = "Campo Consumo de Psicoativos é obrigatório.")
    private String psicoativosDesc;

    @ApiModelProperty(value = "Ocorrência de Conflito Familiar", allowableValues = "Sim, Não", position = 29, required = true)
    @NotEmpty(message = "Campo Conflito Familiar é obrigatório.")
    private String conflitoFamiliar;

    @ApiModelProperty(value = "Atividades de lazer realizadas", allowableValues = "Não, Atividades Manuais, Atividades Sociais, Atividades Físicas/Esportivas, Atividades Culturais, Outros(Descrito em texto)", position = 30, required = true)
    @NotEmpty(message = "Campo Atividades de Lazer é obrigatório.")
    private String atividadeLazerDesc;

    @ApiModelProperty(value = "Realiza Atividade Física", allowableValues = "Sim, Não", position = 31, required = true)
    @NotEmpty(message = "Campo Atividades Físicas é obrigatório.")
    private String atividadeFisica;

    @ApiModelProperty(value = "Qual Atividade Física é realizada? (Descrito em texto)", position = 32)
    private String atividadeFisicaDesc;

    @ApiModelProperty(value = "Qualidade de Vida", allowableValues = "Excelente, Regular, Boa, Ruim", position = 33, required = true)
    @NotEmpty(message = "Campo Qualidade de Vida é obrigatório.")
    private String qualidadeVida;

    @ApiModelProperty(value = "Vacinas em dia", allowableValues = "Sim, Não, Não sabe", position = 34, required = true)
    @NotEmpty(message = "Campo Vacinas é obrigatório.")
    private String vacinas;


}
