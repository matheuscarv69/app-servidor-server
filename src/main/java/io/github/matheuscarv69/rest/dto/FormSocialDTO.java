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
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormSocialDTO {

    @ApiModelProperty(value = "Nome do entrevistado: text", position = 1, required = true)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String fullName;

    @ApiModelProperty(value = "Telefone: text", position = 2, required = true)
    @NotEmpty(message = "{campo.telefone.obrigatorio}")
    private String phoneNumber;

    @ApiModelProperty(value = "Email: text", position = 3, required = true)
    @NotEmpty(message = "{campo.email.obrigatorio}")
    @Email(message = "{campo.email.invalido}")
    private String email;

    @ApiModelProperty(value = "Data de nascimento: text Ex: 18/09/1999", position = 4, required = true)
    @NotEmpty(message = "{campo.data-nascimento.obrigatorio}")
    private String birthDate;

    @ApiModelProperty(value = "Função exercicida: text", position = 5, required = true)
    @NotEmpty(message = "{campo.funcao-exercicida.obrigatorio}")
    private String occupation;

    @ApiModelProperty(value = "Tempo de exercício da função: text", position = 6, required = true)
    @NotEmpty(message = "{campo.tempo-funcao-exercicida.obrigatorio}")
    private String occupationYears;

    @ApiModelProperty(value = "Estado cívil: index: \n " +
            "1 - Solteiro(a), 2 - Casado(a), 3 - União Estável, 4 - Separado(a), 5 - Divorciado(a), 6 - Viuvo(a)",
            position = 7, required = true)
    @NotNull(message = "{campo.estado-civil.obrigatorio}")
    private FieldDTO stateCivil;

    @ApiModelProperty(value = "Escolaridade: index: \n " +
            "1 - Analfabeto, 2 - Ensino Fundamental Incompleto, 3 - Ensino Fundamental Completo, " +
            "4 - Ensino Médio Incompleto, 5 - Ensino Médio Completo, 6 - Ensino Superior Incompleto, " +
            "7 - Ensino Superior Completo", position = 8, required = true)
    @NotNull(message = "{campo.escolaridade.obrigatorio}")
    private FieldDTO schooling;

    @ApiModelProperty(value = "Quantidade de pessoas na familía", position = 9, required = true)
    @NotNull(message = "{campo.numero-pessoas-fam.obrigatorio}")
    @Range(min = 1, max = 30, message = "{campo.numero-pessoas-fam.invalido}")
    private Integer amountPeople;

    @ApiModelProperty(value = "Parentes da família do entrevistado: [index]: \n 1 - Esposo(a), 2 - Filhos(as), " +
            "3 - Sogro(a), 4 - Irmão(ã), 5 - Pai, 6 - Mãe, 7 - Tio(a), 8 - Sobrinho(a), 9 - Avos, " +
            "10 - Enteado(a), 11 - Primo(a), 12 - Outros", position = 10, required = true)
    @NotEmpty(message = "{campo.grau-parentesco.obrigatorio}")
    private Set<FieldDTO> kinship = new HashSet<>();

    @ApiModelProperty(value = "Tipo de Residència: index: \n 1 - Própria, 2 - Alugada, 3 - Área de Invasão, " +
            "4 - Cedida", position = 11, required = true)
    @NotNull(message = "{campo.residencia.obrigatorio}")
    private FieldDTO residence;

    @ApiModelProperty(value = "Tipo de Benefício: index: \n 1 - Nenhum, 2 - Prestação Continuada, 3 - Bolsa Família," +
            "4 - Crédito Social, 5 - Outros(Se selecionado, é preciso preencher o campo: Outro Beneficío)",
            position = 12, required = true)
    @NotEmpty(message = "{campo.beneficio.obrigatorio}")
    private String socialBenefit;


    @ApiModelProperty(value = "Programas Sociais: [index]: \n 1 - Não, 2 - Jovem Aprendiz, 3 - CREA-CRAS, " +
            "4 - CAPS I-II-III e AD, 5 - Programa da Prefeitura ou Outros(Se selecionado, é preciso preencher o campo: " +
            " Outro Programa Social)",
            position = 14, required = true)
    @NotEmpty(message = "{campo.programa-social.obrigatorio}")
    private String socialProgram;


    @ApiModelProperty(value = "Doenças Crônicas na familía: [index]: \n 1 - Nenhuma, 2 - Cancêr, 3 - Diabetes, " +
            "4 - Depressão, 5 - Hipertensão, 6 - Outras(Se selecionado, é preciso preencher o " +
            "campo: Outra Doença Crônica)",
            position = 16, required = true)
    @NotEmpty(message = "{campo.doenca-cronica.obrigatorio}")
    private String chronicDiseases;


    @ApiModelProperty(value = "Deficientes na Família: index: \n 1 - Não, 2 - Sim (Se selecionado, é preciso " +
            "preencher os campos: Pessoa Deficiente e Deficiência)", position = 18, required = true)
    @NotNull(message = "{campo.deficientes-fam.obrigatorio}")
    private String handicappedFamily;


    @ApiModelProperty(value = "Acompanhamento Médico: index: \n 1 - Não, 2 - Sim (Se selecionado, é preciso " +
            "preencher o campo: Especialidade Acompanhamento Médico", position = 21, required = true)
    @NotNull(message = "{campo.acomp-medico.obrigatorio}")
    private String medicalMonitoring;


    @ApiModelProperty(value = "Suicídio na Familia: index: \n 1 - Não, 2 - Sim (Se selecionado, é preciso " +
            "preencher o campo: Grau Parentesco do Suicídio", position = 23, required = true)
    @NotNull(message = "{campo.suicidio-fam.obrigatorio}")
    private String suicideFamily;


    @ApiModelProperty(value = "Violências: [index]: \n 1 - Nenhuma, 2 - Física, 3 - Verbal, 4 - Psicologica, " +
            "5 - Sexual, 6 - Patrimonial, 7 - Outra(Se selecionado, é preciso preencher o campo: Outra Violência)",
            position = 25, required = true)
    @NotEmpty(message = "{campo.violencia-desc.obrigatorio}")
    private String sufferedViolence;


    @ApiModelProperty(value = "Psicoativos: [index]: \n 1 - Nenhum, 2 - Álcool, 3 - Cigarro, 4 - Drogas Ilicítas, " +
            "5 - Outros(Se selecionado, é preciso preencher o campo: Outro Psicoativo)", position = 27, required = true)
    @NotEmpty(message = "{campo.psicoativos-desc.obrigatorio}")
    private String psychoactiveSubstances;

    @ApiModelProperty(value = "Conflito Familiar: index: \n 1 - Não, 2 - Sim", position = 29, required = true)
    @NotNull(message = "{campo.conflito-familiar.obrigatorio}")
    private Boolean familyConflict;

//    @ApiModelProperty(value = "Atividade Lazer: [index]: \n 1 - Nenhuma, 2 - Atividades Manuais, 3 - Atividades Sociais," +
//            " 4 - Atividades Físicas ou esportivas, 5 - Atividades Culturais, 6 - Outras(Se selecionado, é preciso preencher" +
//            " o campo: Outra Atividade Lazer)", position = 30, required = true)
//    @NotEmpty(message = "{campo.atividade-lazer-desc.obrigatorio}")
//    private List<Integer> atividadeLazer;
    private String manualActivity;

    private String socialActivity;

    private String physicalActivity;

    private String culturalActivity;

    @ApiModelProperty(value = "Qualidade de Vida: index: \n 1 - Excelente, 2 - Boa, 3 - Regular, 4 - Ruim",
            position = 34, required = true)
    @NotNull(message = "{campo.qualidade-vida.obrigatorio}")
    private FieldDTO qualityLife;

    @ApiModelProperty(value = "Vacina: index: \n 1 - Não, 2 - Sim, 3 - Não sabe",
            position = 35, required = true)
    @NotNull(message = "{campo.vacina.obrigatorio}")
    private Boolean vaccinesUpToDate;

    private String comments;
}
