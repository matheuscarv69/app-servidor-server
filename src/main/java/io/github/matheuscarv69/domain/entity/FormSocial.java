package io.github.matheuscarv69.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.matheuscarv69.domain.enums.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @Column(length = 50)
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

    @Column(length = 14)
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Column(length = 40)
    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;

    @Column
    private Integer numeroPessoasFam;

    @ElementCollection(targetClass = GrauParentesco.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "tb_grauParentesco",
            joinColumns = @JoinColumn(name = "formsocial_ID")
            , schema = "form")
    @Column(name = "grauParentesco_ID")
    private List<GrauParentesco> grauParentesco;


    @Column(length = 15)
    @Enumerated(EnumType.STRING)
    private Residencia residencia;
    //
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Decisao beneficio;
    //

    //    @Column(length = 40)
//    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = BeneficiosCadastrados.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "tb_beneficios_Cadastrados",
            joinColumns = @JoinColumn(name = "formsocial_ID")
            , schema = "form")
    @Column(name = "beneficiosCadastrados_ID")
    private List<BeneficiosCadastrados> beneficiosCadastrados;

    @Column(length = 40)
    private String outroBeneficioDesc;

    @Column(length = 10)
    private String programaSocial;

    @Column(length = 50)
    private String programaSocialDesc;

    @Column(length = 40)
    private String doencaCronicaDesc;

    @Column(length = 10)
    private String deficienteFamilia;

    @Column(length = 50)
    private String deficienteFamiliaDesc;

    @Column(length = 10)
    private String acompMedico;

    @Column(length = 100)
    private String acompMedicoDesc;

    @Column(length = 10)
    private String suicidioFamilia;

    @Column(length = 15)
    private String suicidioGrauParentesco;

    @Column(length = 30)
    private String violenciaDesc;

    @Column(length = 50)
    private String psicoativosDesc;

    @Column(length = 10)
    private String conflitoFamiliar;

    @Column(length = 30)
    private String atividadeLazerDesc;

    @Column(length = 10)
    private String atividadeFisica;

    @Column(length = 40)
    private String atividadeFisicaDesc;

    @Column(length = 10)
    private String qualidadeVida;

    @Column(length = 10)
    private String vacinas;

}
