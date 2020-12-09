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
import java.util.List;

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
    @NotNull(message = "{campo.estado-civil.obrigatorio}")
    private Integer estadoCivil;

    @ApiModelProperty(value = "Escolaridade: index",
            allowableValues = "1 - Analfabeto, 2 - Ensino Fundamental Incompleto, 3 - Ensino Fundamental Completo, 4 - Ensino Médio Incompleto, 5 - Ensino Médio Completo, 6 - Ensino Superior Incompleto, 7 - Ensino Superior Completo", position = 8, required = true)
    @NotNull(message = "{campo.escolaridade.obrigatorio}")
    private Integer escolaridade;

    @ApiModelProperty(value = "Quantidade de pessoas na familía", position = 9, required = true)
    @NotNull(message = "{campo.numero-pessoas-fam.obrigatorio}")
    @Range(min = 1, max = 30, message = "{campo.numero-pessoas-fam.invalido}")
    private Integer numeroPessoasFam;

    @ApiModelProperty(value = "Parentes da família do entrevistado: [index]",
            allowableValues = "1 - Esposo(a), 2 - Filhos(as), 3 - Sogro(a), 4 - Irmão(ã), 5 - Pai, 6 - Mãe, 7 - Tio(a), 8 - Sobrinho(a), 9 - Avos, 10 - Enteado(a), 11 - Primo(a), 12 - Outros", position = 10, required = true)
    @NotEmpty(message = "{campo.grau-parentesco.obrigatorio}")
    private List<Integer> grauParentesco;

    @ApiModelProperty(value = "Tipo de Residència: index",
            allowableValues = "1 - Própria, 2 - Alugada, 3 - Área de Invasão, 4 - Cedida", position = 11, required = true)
    @NotNull(message = "{campo.residencia.obrigatorio}")
    private Integer residencia;

    @ApiModelProperty(value = "Tipo de Benefício: index",
            allowableValues = "1 - Nenhum, 2 - Prestação Continuada, 3 - Bolsa Família, 4 - Crédito Social, 5 - Outros", position = 12, required = true)
    @NotEmpty(message = "{campo.beneficio.obrigatorio}")
    private List<Integer> beneficio;

    @ApiModelProperty(value = "Outro Benefício: text", position = 13)
    private String outroBeneficio;

    @ApiModelProperty(value = "Programas Sociais: [index]",
            allowableValues = "1 - Não, 2 - Jovem Aprendiz, 3 - CREA-CRAS, 4 - CAPS I-II-III e AD, 5 - Programa da Prefeitura ou Outros (Descrito na propriedade outroProgramaSocial)", position = 14)
    @NotEmpty(message = "{campo.programa-social.obrigatorio}")
    private List<Integer> programaSocial;

    @ApiModelProperty(value = "Outro Programa Social: text", position = 15)
    private String outroProgramaSocial;


}
