package io.github.matheuscarv69.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.matheuscarv69.domain.entity.fields.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    @Column(length = 100)
    private String fullName;

    @Column(length = 15)
    private String phoneNumber;

    @Column(length = 100)
    @Email
    private String email;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "GMT")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date interviewDate;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "GMT")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date birthDate;

    @Column(length = 50)
    private String occupation;

    @Column(length = 40)
    private String occupationYears;

    @OneToOne
    @JoinColumn(name = "state_civil_id")
    private StateCivil stateCivil;

    @OneToOne
    @JoinColumn(name = "schooling_id")
    private Schooling schooling;

    @Column
    private Integer amountPeople;

    @ManyToMany
    @JoinTable(schema = "form", name = "form_kinship",
            joinColumns = @JoinColumn(name = "form_id"),
            inverseJoinColumns = @JoinColumn(name = "kinship_id"))
    private Set<Kinship> kinships = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "residence_id")
    private Residence residence;

    private String socialBenefit;

    private String socialProgram;

    private String chronicDiseases;

    private String handicappedFamily;

    private String medicalMonitoring;

    private String suicideFamily;

    private String sufferedViolence;

    private String psychoactiveSubstances;

    private Boolean familyConflict;

    private String manualActivity;

    private String socialActivity;

    private String physicalActivity;

    private String culturalActivity;

    @OneToOne
    @JoinColumn(name = "quality_life_id")
    private QualityLife qualityLife;

    private Boolean vaccinesUpToDate;

    private String comments;

}
