package io.github.matheuscarv69.domain.entity;

import io.github.matheuscarv69.domain.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "formsocial")
public class FormSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private LocalDate dataEntrevista;
    private Date dataNascimento;

    private int idade;
    private String telefone;
    private String email;
    private String funcaoExerc;
    private String tempoFuncaoExerc;

//    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil; // enum

//    @Enumerated(EnumType.STRING)
//    private Escolaridade escolaridade; // enum
//
//    private int numeroPessoasFam;
//    @Enumerated(EnumType.STRING)
//    private GrauParentesco grauParentesco; // enum
//
//    @Enumerated(EnumType.STRING)
//    private Residencia residencia; // enum
//
//    private boolean beneficio;
//    private String beneficioDescricao; // enum?
//
//    private boolean programaSocial;
//    private String programaSocialDescricao; // enum?
//
//    private boolean doencaCronica;
//    private String doencaCronicaDescricao; // enum
//
//    private boolean deficienteFamilia;
//    private String deficienteFamiliaDescricao;
//
//    private boolean acompMedico;
//    private String acompMedicoDescricao;
//
//    private boolean suicidioFamilia;
//    //    private String suicidioFamiliaDescricao;
//    @Enumerated(EnumType.STRING)
//    private GrauParentesco suicidioGrauParentesco; // enum
//
//    @Enumerated(EnumType.STRING)
//    private Violencia violencia; // enum
//    private String violenciaDescricao;
//
//    private boolean psicoativos; // enum
//    private String psicoativosDescricao;
//
//    private boolean conflitoFamiliar;
//
//    @Enumerated(EnumType.STRING)
//    private AtividadeLazer atividadeLazer; // enum
//    private String atividadeLazerDescricao;
//
//    private boolean atividadeFisica;
//    private String atividadeFisicaDescricao;
//
//    @Enumerated(EnumType.STRING)
//    private QualidadeVida qualidadeVida; // enum
//
//    @Enumerated(EnumType.STRING)
//    private Vacinas vacinas; // enum
}
