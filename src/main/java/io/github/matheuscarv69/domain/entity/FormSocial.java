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

    @Column(name="nome", length = 100)
    private String nome;

    @Column
    private int idade;

    @Column(length = 15)
    private String telefone;

    @Column(length = 50)
    private String email;

    @Column
    private LocalDate dataEntrevista;

    @Column
    private LocalDate dataNascimento;

    @Column(length = 50)
    private String funcaoExerc;

    @Column(length = 40)
    private String tempoFuncaoExerc;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil; // enum

    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade; // enum

    @Column
    private int numeroPessoasFam;

    @Enumerated(EnumType.STRING)
    private GrauParentesco grauParentesco; // enum

    @Enumerated(EnumType.STRING)
    private Residencia residencia; // enum

    @Column
    private boolean beneficio;

    @Column(length = 40)
    private String beneficioDescricao; // enum?

    @Column
    private boolean programaSocial;

    @Column(length = 40)
    private String programaSocialDescricao; // enum?

    @Column
    private boolean doencaCronica;

    @Column(length = 40)
    private String doencaCronicaDescricao; // enum

    @Column
    private boolean deficienteFamilia;

    @Column(length = 50)
    private String deficienteFamiliaDescricao;

    @Column
    private boolean acompMedico;

    @Column(length = 50)
    private String acompMedicoDescricao;

    @Column
    private boolean suicidioFamilia;

    @Enumerated(EnumType.STRING)
    private GrauParentesco suicidioGrauParentesco; // enum

    @Enumerated(EnumType.STRING)
    private Violencia violencia; // enum

    @Column(length = 50)
    private String violenciaDescricao;

    @Column
    private boolean psicoativos; // enum

    @Column(length = 50)
    private String psicoativosDescricao;

    @Column
    private boolean conflitoFamiliar;

    @Enumerated(EnumType.STRING)
    private AtividadeLazer atividadeLazer; // enum

    @Column(length = 40)
    private String atividadeLazerDescricao;

    @Column
    private boolean atividadeFisica;

    @Column(length = 40)
    private String atividadeFisicaDescricao;

    @Enumerated(EnumType.STRING)
    private QualidadeVida qualidadeVida; // enum

    @Enumerated(EnumType.STRING)
    private Vacinas vacinas; // enum
}
