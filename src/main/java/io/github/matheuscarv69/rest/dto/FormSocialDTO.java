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

    @ApiModelProperty(value = "Nome do entrevistado ", position = 1, required = true)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @ApiModelProperty(value = "Telefone", position = 2, required = true)
    @NotEmpty(message = "{campo.telefone.obrigatorio}")
    private String telefone;

    @ApiModelProperty(value = "Email", position = 3, required = true)
    @NotEmpty(message = "{campo.email.obrigatorio}")
    @Email(message = "{campo.email.invalido}")
    private String email;

    @ApiModelProperty(value = "Data de nascimento. Ex: 18/09/1999", position = 4, required = true)
    @NotEmpty(message = "{campo.data-nascimento.obrigatorio}")
    private String dataNascimento;

    @ApiModelProperty(value = "Função exercicida", position = 5, required = true)
    @NotEmpty(message = "{campo.funcao-exercicida.obrigatorio}")
    private String funcaoExerc;

    @ApiModelProperty(value = "Tempo de exercício da função", position = 6, required = true)
    @NotEmpty(message = "{campo.tempo-funcao-exercicida.obrigatorio}")
    private String tempoFuncaoExerc;

    @ApiModelProperty(value = "Estado cívil: index",
            allowableValues = "1 - Solteiro(a), 2 - Casado(a), 3 - União Estável, 4 - Separado(a), 5 - Divorciado(a), 6 - Viuvo(a)", position = 7, required = true)
    @NotEmpty(message = "{campo.estado-civil.obrigatorio}")
    private String estadoCivil;

    @ApiModelProperty(value = "Escolaridade: index",
            allowableValues = "1 - Analfabeto, 2 - Ensino Fundamental Incompleto, 3 - Ensino Fundamental Completo, 4 - Ensino Médio Incompleto, 5 - Ensino Médio Completo, 6 - Ensino Superior Incompleto, 7 - Ensino Superior Completo", position = 8, required = true)
    @NotEmpty(message = "{campo.escolaridade.obrigatorio}")
    private String escolaridade;

    @ApiModelProperty(value = "Quantidade de pessoas na familía", position = 9, required = true)
    @NotNull(message = "{campo.numero-pessoas-fam.obrigatorio}")
    @Range(min = 1, max = 30, message = "{campo.numero-pessoas-fam.invalido}")
    private Integer numeroPessoasFam;

    @ApiModelProperty(value = "Parentes da família do entrevistado: [index]",
            allowableValues = "1 - Esposo(a), 2 - Filhos(as), 3 - Sogro(a), 4 - Irmão(ã), 5 - Pai, 6 - Mãe, 7 - Tio(a), 8 - Sobrinho(a), 9 - Avos, 10 - Enteado(a), 11 - Primo(a), 12 - Outros", position = 10, required = true)
    @NotEmpty(message = "{campo.grau-parentesco.obrigatorio}")
    private String grauParentesco;

    @ApiModelProperty(value = "Tipo de Residència: index",
            allowableValues = "1 - Própria, 2 - Alugada, 3 - Área de Invasão, 4 - Cedida", position = 11, required = true)
    @NotEmpty(message = "{campo.residencia.obrigatorio}")
    private String residencia;

    @ApiModelProperty(value = "Recebe algum beneficio?: index",
            allowableValues = "1 - Sim, 2 -Não", position = 12, required = true)
    @NotEmpty(message = "{campo.beneficio.obrigatorio}")
    private String beneficio;

    @ApiModelProperty(value = "Tipo do Benefício: [index]",
            allowableValues = "1 - Benefício de Prestação Continuada, 2 - Bolsa familía, 3 - Crédito Social, 4 - Outros (Descrito na propriedade outroBeneficioDesc)", position = 13, required = true)
    private String beneficiosCadastrados;

    @ApiModelProperty(value = "Descrição do Outro Benefício: Ex: Vale Alimentação", position = 14)
    private String outroBeneficioDesc;

    @ApiModelProperty(value = "Participa de algum programa social?: index",
            allowableValues = "1 - Sim, 2 - Não", position = 15, required = true)
    @NotEmpty(message = "{campo.programa-social.obrigatorio}")
    private String programaSocial;

    @ApiModelProperty(value = "Programas Sociais: [index]",
            allowableValues = "1 - Jovem Aprendiz, 2 - Programa da Prefeitura, 3 - CREA-CRAS, 4 - CAPS I-II-III e AD, 5 - Outros (Descrito na propriedade outroProgramaSocialDesc)", position = 16, required = true)
    private String programasSociaisCadastrados;

    @ApiModelProperty(value = "Descrição do Outro Programa Social: Ex: Auxílio Emergêncial", position = 17)
    private String outroProgramaSocialDesc;

    @ApiModelProperty(value = "Possui algum Doença Crônica na família: index",
            allowableValues = "1 - Sim, 2 - Não", position = 18, required = true)
    @NotEmpty(message = "{campo.doenca-cronica.obrigatorio}")
    private String doencaCronica;

    @ApiModelProperty(value = "Doenças Crônicas na familía.",
            allowableValues = "1 - Cancêr, 2 - Diabetes, 3 - Depressão, 4 - Hipertensão, 5 - Outras(Descrito na propriedade outraDoencaCronicasDesc", position = 19, required = true)
    private String doencasCronicasCadastradas;

    @ApiModelProperty(value = "Descrição da Outra Doença Crônica: Ex: Bronquite", position = 20)
    private String outraDoencaCronicasDesc;

    @ApiModelProperty(value = "Há Deficientes na familía?: index",
            allowableValues = "1 - Sim, 2 - Não", position = 21, required = true)
    @NotEmpty(message = "{campo.deficientes-fam.obrigatorio}")
    private String deficienteFamilia;

    @ApiModelProperty(value = "Quem é o Deficiente na familía? e qual a deficiência?: ex: filho, paralítico", position = 22)
    private String deficienteFamiliaDescricao;
    //
    @ApiModelProperty(value = "Faz Acompanhamento Médico?: index",
            allowableValues = "1 - Sim, 2 - Não", position = 23, required = true)
    @NotEmpty(message = "{campo.acomp-medico.obrigatorio}")
    private String acompMedico;

    @ApiModelProperty(value = "Qual a especialidade médica do acompanhamento?: ex: Oftalmologista", position = 24)
    private String acompMedicoDescricao;

    @ApiModelProperty(value = "Ocorrência de suicídio na familía: index",
            allowableValues = "1 - Sim, 2 - Não", position = 25, required = true)
    @NotEmpty(message = "{campo.suicidio-fam.obrigatorio}")
    private String suicidioFamilia;

    @ApiModelProperty(value = "Grau de parentesco do familiar do suicídio: index",
            allowableValues = "1 - Esposo(a), 2 - Filhos(as), 3 - Sogro(a), 4 - Irmão(ã), 5 - Pai, 6 - Mãe, 7 - Tio(a), 8 - Sobrinho(a), 9 - Avos, 10 - Enteado(a), 11 - Primo(a), 12 - Outros", position = 26)
    private String suicidioGrauParentesco;

    @ApiModelProperty(value = "Sofreu violência: index",
            allowableValues = "1 - Sim, 2 - Não", position = 27, required = true)
    @NotEmpty(message = "{campo.violencia-desc.obrigatorio")
    private String violencia;

    @ApiModelProperty(value = "Violências sofridas: [index]",
            allowableValues = "1 - Física, 2 - Verbal, 3 - Psicologica, 4 - Sexual, 5 - Patrimonial, 6 - Outros(Descrito na propriedade OutraViolenciaDescricao)", position = 28)
    private String violenciasCadastradas;

    @ApiModelProperty(value = "Descrição de outro tipo de Violência sofrida: ", position = 29)
    private String outraViolenciaDescricao;

    @ApiModelProperty(value = "Consumo de Psicoativos: index",
            allowableValues = "1 - Sim, 2 - Não", position = 30, required = true)
    @NotEmpty(message = "{campo.psicoativos-desc.obrigatorio}")
    private String psicoativos;

    @ApiModelProperty(value = "Uso de Psicoativos: index",
            allowableValues = "1 - Álcool, 2 - Cigarro, 3 - Drogras Ilicítas, 4 - Outros(Descrito na propriedade outrosPsicoativosDescricao)", position = 31)
    private String psicoativosCadastrados;

    @ApiModelProperty(value = "Descrição de outro tipo de consumo: ", position = 32)
    private String outrosPsicoativosDescricao;

    @ApiModelProperty(value = "Ocorrência de Conflito Familiar: index",
            allowableValues = "1 - Sim, 2 - Não", position = 33, required = true)
    @NotEmpty(message = "{campo.conflito-familiar.obrigatorio}")
    private String conflitoFamiliar;


    @ApiModelProperty(value = "Realiza Atividades de lazer?: index",
            allowableValues = "1 - Sim, 2 - Não", position = 34)
    @NotEmpty(message = "{campo.atividade-lazer-desc.obrigatorio}")
    private String atividadesLazer;

    @ApiModelProperty(value = "Atividades de lazer realizadas: index",
            allowableValues = "1 - Atividades Manuais, 2 - Atividades Sociais, 3 - Atividades Físicas/Esportivas, 4 - Atividades Culturais, 5 - Outros(Descrito na propriedade outrosAtivLazerDescricao)", position = 34, required = true)
    private String atividadeLazerCadastradas;

    @ApiModelProperty(value = "Descrição de outro tipo de Atividade de Lazer", position = 36)
    private String outrasAtividadeLazerDesc;


//
    @ApiModelProperty(value = "Realiza Atividade Física: index",
            allowableValues = "1 - Sim, 2 - Não", position = 37, required = true)
    @NotEmpty(message = "{campo.atividade-fisica.obrigatorio}")
    private String atividadeFisica;
//
    @ApiModelProperty(value = "Qual Atividade Física é realizada? (Descrito em texto)", position = 38)
    private String atividadeFisicaDesc;

    @ApiModelProperty(value = "Qualidade de Vida: index",
            allowableValues = "1 - Excelente, 2 - Regular, 3 - Boa, 4 - Ruim", position = 39, required = true)
    @NotEmpty(message = "{campo.qualidade-vida.obrigatorio}")
    private String qualidadeVida;

    @ApiModelProperty(value = "Vacinas em dia: index",
            allowableValues = "1 - Sim, 2 - Não, 3 - Não sabe", position = 40, required = true)
    @NotEmpty(message = "{campo.vacinas.obrigatorio}")
    private String vacinas;


}
