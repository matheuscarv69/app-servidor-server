package io.github.matheuscarv69.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.Date;

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
    private String estadoCivil;

    @Column(length = 40)
    private String escolaridade;

    @Column
    private Integer numeroPessoasFam;

    @Column(length = 15)
    private String grauParentesco;

    @Column(length = 15)
    private String residencia;

    @Column(length = 10)
    private String beneficio;

    @Column(length = 40)
    private String beneficioDesc;

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
