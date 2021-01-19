package io.github.matheuscarv69.rest.dto;

import io.github.matheuscarv69.domain.entity.fields.Kinship;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoFormSocialDTO {

    private Integer id;
    private String fullName;
    private String phoneNumber;
    private Integer age;
    private String email;
    private String interviewDate;
    private String birthDate;
    private String occupation;
    private String occupationYears;
    private String stateCivil;
    private String schooling;
    private Integer amountPeople;
    private Set<Kinship> kinships = new HashSet<>();
    private String residence;
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

    private String vaccinesUpToDate;
    private String comments;

}
