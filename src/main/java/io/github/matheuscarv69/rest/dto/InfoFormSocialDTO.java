package io.github.matheuscarv69.rest.dto;

import io.github.matheuscarv69.domain.entity.othersEntity.DeficienteFamilia;
import io.github.matheuscarv69.rest.dto.othersEntity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private List<GrauParentescoDTO> grauParentesco;
    private String residencia;
    private List<BeneficioDTO> beneficio;
    private List<ProgramaSocialDTO> programaSocial;
    private List<DoencaCronicaDTO> doencaCronica;
    private DeficienteFamiliaDTO deficienteFamilia;
    private String acompMedico;
    private SuicidioFamiliaDTO suicidioFamilia;
    private List<ViolenciaDTO> violencia;
    private List<PsicoativoDTO> psicoativos;
    private String conflitoFamiliar;
    private List<AtividadeLazerDTO> atividadesLazer;
    private String atividadeFisica;
    private String qualidadeVida;
    private String vacinas;
}
