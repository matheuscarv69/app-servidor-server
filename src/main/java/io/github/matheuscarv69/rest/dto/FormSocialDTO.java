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

    @ApiModelProperty(value = "Telefone: text", position = 2)
    private String phoneNumber;

    @ApiModelProperty(value = "Email: text", position = 3)
    @Email(message = "{campo.email.invalido}")
    private String email;

    @ApiModelProperty(value = "Data de nascimento: text dd/MM/yyyy", position = 4, required = true)
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

    @ApiModelProperty(value = "Parentes da família do entrevistado: [ FieldDTO ]", position = 10, required = true)
    @NotEmpty(message = "{campo.grau-parentesco.obrigatorio}")
    private Set<FieldDTO> kinship = new HashSet<>();

    @ApiModelProperty(value = "Tipo de Residència: index: \n 1 - Própria, 2 - Alugada, 3 - Área de Invasão, " +
            "4 - Cedida", position = 11, required = true)
    @NotNull(message = "{campo.residencia.obrigatorio}")
    private FieldDTO residence;

    @ApiModelProperty(value = "Benefício Social: text", position = 12)
    private String socialBenefit;

    @ApiModelProperty(value = "Programas Sociais: text", position = 13)
    private String socialProgram;

    @ApiModelProperty(value = "Doenças Crônicas na familía: text", position = 14)
    private String chronicDiseases;

    @ApiModelProperty(value = "Deficientes na Família: text", position = 15)
    private String handicappedFamily;

    @ApiModelProperty(value = "Acompanhamento Médico: text", position = 16)
    private String medicalMonitoring;

    @ApiModelProperty(value = "Suicídio na Familia: text", position = 17)
    private String suicideFamily;

    @ApiModelProperty(value = "Sofreu Violências: text", position = 18)
    private String sufferedViolence;

    @ApiModelProperty(value = "Uso de Psicoativos: text", position = 19)
    private String psychoactiveSubstances;

    @ApiModelProperty(value = "Conflito Familiar: boolean", position = 20)
    private Boolean familyConflict;

    @ApiModelProperty(value = "Atividade Manual: text", position = 21)
    private String manualActivity;

    @ApiModelProperty(value = "Atividade Social: text", position = 22)
    private String socialActivity;

    @ApiModelProperty(value = "Atividade Física: text", position = 23)
    private String physicalActivity;

    @ApiModelProperty(value = "Atividade Cultural: text", position = 24)
    private String culturalActivity;

    @ApiModelProperty(value = "Qualidade de Vida: index: \n 1 - Excelente, 2 - Boa, 3 - Regular, 4 - Ruim",
            position = 25, required = true)
    @NotNull(message = "{campo.qualidade-vida.obrigatorio}")
    private FieldDTO qualityLife;

    @ApiModelProperty(value = "Vacinas em dia: boolean ", position = 26, required = true)
    @NotNull(message = "{campo.vacina.obrigatorio}")
    private Boolean vaccinesUpToDate;

    @ApiModelProperty(value = "Comentários e Observações: text", position = 27)
    private String comments;
}
