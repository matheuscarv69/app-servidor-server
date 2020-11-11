package io.github.matheuscarv69.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.matheuscarv69.domain.enums.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "formSocial", schema = "form")
public class FormSocial {

    @ApiModelProperty(value = "ID do formulário")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "Nome da pessoa")
    @Column(name = "nome", length = 100)
    private String nome;

    @Column(length = 15)
    private String telefone;

    @Column(length = 70)
    @Email
    private String email;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "GMT")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataEntrevista;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "GMT")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataNascimento;

    @Column(length = 50)
    private String funcaoExerc;

    @Column(length = 40)
    private String tempoFuncaoExerc;

    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;

    @Column
    private Integer numeroPessoasFam;

    @ElementCollection(targetClass = GrauParentesco.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "tb_grauParentesco",
            joinColumns = @JoinColumn(name = "formsocial_ID")
            , schema = "form")
    @Column(name = "grauParentesco_ID", length = 20)
    private List<GrauParentesco> grauParentesco;

    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private Residencia residencia;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Decisao beneficio;

    @ElementCollection(targetClass = BeneficiosCadastrados.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "tb_beneficios_Cadastrados",
            joinColumns = @JoinColumn(name = "formsocial_ID")
            , schema = "form")
    @Column(name = "beneficiosCadastrados_ID", length = 60)
    private List<BeneficiosCadastrados> beneficiosCadastrados;

    @Column(length = 70)
    private String outroBeneficioDesc;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Decisao programaSocial;

    @ElementCollection(targetClass = ProgramasSociaisCadastrados.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "tb_programasSoc_Cadastrados",
            joinColumns = @JoinColumn(name = "formsocial_ID")
            , schema = "form")
    @Column(name = "ProgramasSocCadastrados_ID", length = 40)
    private List<ProgramasSociaisCadastrados> programasSociaisCadastrados;

    @Column(length = 70)
    private String outroProgramaSocialDesc;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Decisao doencaCronica;

    @ElementCollection(targetClass = DoencasCronicasCadastradas.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "tb_doencaCron_Cadastrados",
            joinColumns = @JoinColumn(name = "formsocial_ID")
            , schema = "form")
    @Column(name = "DoencaCronCadastrados_ID", length = 20)
    private List<DoencasCronicasCadastradas> doencasCronicasCadastradas;

    @Column(length = 70)
    private String outraDoencaCronicasDesc;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Decisao deficienteFamilia;

    @Column(length = 50)
    private String deficienteFamiliaDescricao;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Decisao acompMedico;

    @Column(length = 100)
    private String acompMedicoDescricao;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Decisao suicidioFamilia;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private GrauParentesco suicidioGrauParentesco;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Decisao violencia;

    @ElementCollection(targetClass = ViolenciasCadastradas.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "tb_Violencias_Cadastrados",
            joinColumns = @JoinColumn(name = "formsocial_ID")
            , schema = "form")
    @Column(name = "Violencias_ID", length = 20)
    private List<ViolenciasCadastradas> violenciasCadastradas;

    @Column(length = 50)
    private String outraViolenciaDescricao;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Decisao psicoativos;

    @ElementCollection(targetClass = PsicoativosCadastrados.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "tb_Psicoativos_Cadastrados",
            joinColumns = @JoinColumn(name = "formsocial_ID")
            , schema = "form")
    @Column(name = "Psicoativos_ID", length = 20)
    private List<PsicoativosCadastrados> psicoativosCadastrados;

    @Column(length = 50)
    private String outrosPsicoativosDescricao;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Decisao conflitoFamiliar;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Decisao atividadesLazer;

    @ElementCollection(targetClass = PsicoativosCadastrados.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "tb_AtivLazer_Cadastrados",
            joinColumns = @JoinColumn(name = "formsocial_ID")
            , schema = "form")
    @Column(name = "AtivLazer_ID", length = 40)
    private List<AtividadeLazerCadastradas> atividadeLazerCadastradas;

    @Column(length = 50)
    private String outrasAtividadeLazerDesc;

//
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Decisao atividadeFisica;

    @Column(length = 50)
    private String atividadeFisicaDesc;
//

    @Column(length = 15)
    @Enumerated(EnumType.STRING)
    private QualidadeVida qualidadeVida;

    //
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Vacinas vacinas;

}
