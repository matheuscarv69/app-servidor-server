package io.github.matheuscarv69.domain.entity;

import io.github.matheuscarv69.domain.enums.*;
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
@Table(name = "formsocial")
public class FormSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column
    private int idade;

    @Column(length = 15)
    private String telefone;

    @Column(length = 50)
    @Email(message = "O Email informado é inválido.")
    private String email;

    @Column
    private LocalDate dataEntrevista;

    @Column
    private LocalDate dataNascimento;

    @Column(length = 50)
    private String funcaoExerc;

    @Column(length = 40)
    private String tempoFuncaoExerc;

    @Column
    private String estadoCivil;

    @Column
    private String escolaridade;

    @Column
    private int numeroPessoasFam;

    @Column
    private String grauParentesco;

    @Column
    private String residencia;

    @Column
    private boolean beneficio;

    @Column(length = 40)
    private String beneficioDesc;

    @Column
    private boolean programaSocial;

    @Column(length = 50)
    private String programaSocialDesc;

    @Column
    private boolean doencaCronica; // Nao possui no form, mas e interessante por

    @Column(length = 50)
    private String doencaCronicaDesc;

    @Column
    private boolean deficienteFamilia;

    @Column(length = 50)
    private String deficienteFamiliaDesc;

    @Column
    private boolean acompMedico;

    @Column(length = 100)
    private String acompMedicoDesc;

    @Column
    private boolean suicidioFamilia;

    @Column
    private String suicidioGrauParentesco;

    @Column
    private boolean violencia;

    @Column(length = 20)
    private String violenciaDesc;

    @Column
    private boolean psicoativos;

    @Column(length = 50)
    private String psicoativosDesc;

    @Column
    private boolean conflitoFamiliar;

    @Column(length = 30)
    private String atividadeLazerDesc; // nao possui campo de sim, somente nao

    @Column
    private boolean atividadeFisica;

    @Column(length = 40)
    private String atividadeFisicaDesc;

    @Column(length = 10)
    private String qualidadeVida;

    @Column(length = 10)
    private String vacinas;

}
