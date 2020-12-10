package io.github.matheuscarv69.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.matheuscarv69.domain.entity.othersEntity.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
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

    @OneToOne
    @JoinColumn(name = "estado_civil_id")
    private EstadoCivil estadoCivil;

    @OneToOne
    @JoinColumn(name = "escolaridade_id")
    private Escolaridade escolaridade;

    @Column
    private Integer numeroPessoasFam;

    @ManyToMany
    @JoinTable(schema = "form", name = "form_grauparentesco",
            joinColumns = @JoinColumn(name = "form_id"),
            inverseJoinColumns = @JoinColumn(name = "grauparentesco_id"))
    private List<GrauParentesco> grauParentescos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "residencia_id")
    private Residencia residencia;

    @ManyToMany
    @JoinTable(schema = "form", name = "form_beneficios",
            joinColumns = @JoinColumn(name = "form_id"),
            inverseJoinColumns = @JoinColumn(name = "beneficios_id"))
    private List<Beneficio> beneficios = new ArrayList<>();

    @ManyToMany
    @JoinTable(schema = "form", name = "form_programa_social",
            joinColumns = @JoinColumn(name = "form_id"),
            inverseJoinColumns = @JoinColumn(name = "programaSocial_id"))
    private List<ProgramaSocial> programasSociais = new ArrayList<>();


    @ManyToMany
    @JoinTable(schema = "form", name = "form_doenca_cronica",
            joinColumns = @JoinColumn(name = "form_id"),
            inverseJoinColumns = @JoinColumn(name = "doencaCronica_id"))
    private List<DoencaCronica> doencaCronicas =  new ArrayList<>();



}
