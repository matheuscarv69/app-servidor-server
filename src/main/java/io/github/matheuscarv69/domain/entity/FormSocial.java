package io.github.matheuscarv69.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

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
    private Integer idade;

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
    private Integer numeroPessoasFam;

    @Column
    private String grauParentesco;

    @Column
    private String residencia;

    @Column
    private String beneficio;

    @Column(length = 40)
    private String beneficioDesc;

    @Column
    private String programaSocial;

    @Column(length = 50)
    private String programaSocialDesc;

    @Column(length = 40)
    private String doencaCronicaDesc;

    @Column
    private String deficienteFamilia;

    @Column(length = 50)
    private String deficienteFamiliaDesc;

    @Column
    private String acompMedico;

    @Column(length = 100)
    private String acompMedicoDesc;

    @Column
    private String suicidioFamilia;

    @Column
    private String suicidioGrauParentesco;

    @Column(length = 30)
    private String violenciaDesc;

    @Column(length = 50)
    private String psicoativosDesc;

    @Column
    private String conflitoFamiliar;

    @Column(length = 30)
    private String atividadeLazerDesc;

    @Column
    private String atividadeFisica;

    @Column(length = 40)
    private String atividadeFisicaDesc;

    @Column(length = 10)
    private String qualidadeVida;

    @Column(length = 10)
    private String vacinas;

}
