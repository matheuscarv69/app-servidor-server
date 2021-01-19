package io.github.matheuscarv69.service.impl;

import io.github.matheuscarv69.domain.entity.FormSocial;
import io.github.matheuscarv69.domain.entity.fields.*;
import io.github.matheuscarv69.domain.repository.FormSocialRepository;
import io.github.matheuscarv69.domain.repository.fieldsRepositories.*;
import io.github.matheuscarv69.exceptions.*;
import io.github.matheuscarv69.rest.dto.FieldDTO;
import io.github.matheuscarv69.rest.dto.FormSocialDTO;
import io.github.matheuscarv69.service.FormSocialService;
import io.github.matheuscarv69.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FormSocialServiceImpl implements FormSocialService {

    @Autowired
    private FormSocialRepository repository;

    @Autowired
    private StateCivilRepository stateCivilRepository;

    @Autowired
    private SchoolingRepository schoolingRepository;

    @Autowired
    private ResidenceRepository residenceRepository;

    @Autowired
    private KinshipRepository kinshipRepository;

    @Autowired
    private QualityLifeRepository qualityLifeRepository;

    @Override
    @Transactional
    public FormSocial salvar(FormSocialDTO dto) {

        FormSocial formSocial = new FormSocial();

        formSocial.setFullName(dto.getFullName());
        formSocial.setPhoneNumber(dto.getPhoneNumber() != null ? dto.getPhoneNumber() : null);
        formSocial.setEmail(dto.getEmail() != null ? dto.getEmail() : null);
        formSocial.setInterviewDate(new Date());
        Date birthDate = DateUtil.formataStringData(dto.getBirthDate());
        formSocial.setBirthDate(birthDate);
        formSocial.setOccupation(dto.getOccupation());
        formSocial.setOccupationYears(dto.getOccupationYears());
        formSocial.setStateCivil(instantiateStateCivil(dto.getStateCivil()));
        formSocial.setSchooling(instantiateSchooling(dto.getSchooling()));
        formSocial.setAmountPeople(dto.getAmountPeople());
        Set<Kinship> kinshipSet = convertIndexKinship(dto.getKinship());
        formSocial.getKinships().addAll(kinshipSet); // association objects
        formSocial.setResidence(instantiateResidence(dto.getResidence()));
        formSocial.setSocialBenefit(dto.getSocialBenefit() != null ? dto.getSocialBenefit() : null);
        formSocial.setSocialProgram(dto.getSocialProgram() != null ? dto.getSocialProgram() : null);
        formSocial.setChronicDiseases(dto.getChronicDiseases() != null ? dto.getChronicDiseases() : null);
        formSocial.setHandicappedFamily(dto.getHandicappedFamily() != null ? dto.getHandicappedFamily() : null);
        formSocial.setMedicalMonitoring(dto.getMedicalMonitoring() != null ? dto.getMedicalMonitoring() : null);
        formSocial.setSuicideFamily(dto.getSuicideFamily() != null ? dto.getSuicideFamily() : null);
        formSocial.setSufferedViolence(dto.getSufferedViolence() != null ? dto.getSufferedViolence() : null);
        formSocial.setPsychoactiveSubstances(dto.getPsychoactiveSubstances() != null ? dto.getPsychoactiveSubstances() : null);
        formSocial.setFamilyConflict(dto.getFamilyConflict());
        formSocial.setManualActivity(dto.getManualActivity() != null ? dto.getManualActivity() : null);
        formSocial.setSocialActivity(dto.getSocialActivity() != null ? dto.getSocialActivity() : null);
        formSocial.setPhysicalActivity(dto.getPhysicalActivity() != null ? dto.getPhysicalActivity() : null);
        formSocial.setCulturalActivity(dto.getCulturalActivity() != null ? dto.getCulturalActivity() : null);
        formSocial.setQualityLife(instantiateQualityLife(dto.getQualityLife()));
        formSocial.setVaccinesUpToDate(dto.getVaccinesUpToDate());
        formSocial.setComments(dto.getComments() != null ? dto.getComments() : null);

        repository.save(formSocial);

        return formSocial;
    }

    @Override
    public List<FormSocialDTO> buscarForms() {
        List<FormSocial> listForms = repository.findAll();

        List<FormSocialDTO> listInfoForm = new ArrayList<>();

        for (FormSocial form : listForms) {
            listInfoForm.add(formSocialToDTO(form));
        }

        return listInfoForm;
    }


    public StateCivil instantiateStateCivil(FieldDTO stateCivilDTO) {
        StateCivil stateCivil = new StateCivil();

        if (stateCivilDTO.getId() < 1 || stateCivilDTO.getId() > 6) {
            throw new StateCivilException(" ID do Estado Civil é inválido. (1-6)");
        }

        Optional<StateCivil> estadoBD = stateCivilRepository.findById(stateCivilDTO.getId());

        if (estadoBD.isPresent()) {
            stateCivil.setId(estadoBD.get().getId());
            stateCivil.setStateCivil(estadoBD.get().getStateCivil());
        }

        return stateCivil;
    }

    public Schooling instantiateSchooling(FieldDTO schoolingDTO) {
        Schooling Schooling = new Schooling();

        if (schoolingDTO.getId() < 1 || schoolingDTO.getId() > 7) {
            throw new SchoolingException("ID da Schooling é inválido. (1-7)");
        }

        Optional<Schooling> SchoolingBD = schoolingRepository.findById(schoolingDTO.getId());

        if (SchoolingBD.isPresent()) {
            Schooling.setId(SchoolingBD.get().getId());
            Schooling.setSchooling(SchoolingBD.get().getSchooling());
        }

        return Schooling;
    }

    public Residence instantiateResidence(FieldDTO residenceDTO) {
        Residence residence = new Residence();

        if (residenceDTO.getId() < 1 || residenceDTO.getId() > 4) {
            throw new ResidenceException("ID da Residência é inválido. (1-4)");
        }

        Optional<Residence> residenceBD = residenceRepository.findById(residenceDTO.getId());

        if (residenceBD.isPresent()) {
            residence.setId(residenceBD.get().getId());
            residence.setResidence(residenceBD.get().getResidence());
        }

        return residence;
    }

    public QualityLife instantiateQualityLife(FieldDTO qualityLifeDTO) {
        QualityLife qualityLife = new QualityLife();

        if (qualityLifeDTO.getId() < 1 || qualityLifeDTO.getId() > 4) {
            throw new QualityLifeException("ID da Qualidade de vida é inválido. (1-4)");
        }

        Optional<QualityLife> qualityLifeBD = qualityLifeRepository.findById(qualityLifeDTO.getId());

        if (qualityLifeBD.isPresent()) {
            qualityLife.setId(qualityLifeBD.get().getId());
            qualityLife.setQualityLife(qualityLifeBD.get().getQualityLife());
        }

        return qualityLife;
    }

    public Set<Kinship> convertIndexKinship(Set<FieldDTO> kinshipSetDTO) {
        Set<Kinship> kinshipSet = new HashSet<>();

        for (FieldDTO index : kinshipSetDTO) {
            if (index.getId() < 1 || index.getId() > 12) {
                throw new KinshipException("Algum dos ID's de Grau Parentesco é inválido. (1-12)");
            }

            Kinship kinship = new Kinship();

            Optional<Kinship> kinshipBD = kinshipRepository.findById(index.getId());

            if (kinshipBD.isPresent()) {
                kinship.setId(kinshipBD.get().getId());
                kinship.setKinship(kinshipBD.get().getKinship());
                kinshipSet.add(kinship);
            }
        }

        return kinshipSet;
    }

    public FormSocialDTO formSocialToDTO(FormSocial form) {

        FormSocialDTO info = FormSocialDTO
                .builder()
                .id(form.getId())
                .fullName(form.getFullName())
                .age(DateUtil.calculaIdade(form.getBirthDate()))
                .birthDate(DateUtil.formatter.format(form.getBirthDate()))
                .interviewDate(DateUtil.formatter.format(form.getInterviewDate()))
                .phoneNumber(form.getPhoneNumber())
                .email(form.getEmail())
                .occupation(form.getOccupation())
                .occupationYears(form.getOccupationYears())
                .stateCivil(FieldDTO.builder().id(form.getStateCivil().getId()).value(form.getStateCivil().getStateCivil()).build())
                .schooling(FieldDTO.builder().id(form.getSchooling().getId()).value(form.getSchooling().getSchooling()).build())
                .amountPeople(form.getAmountPeople())
                .kinship(form.getKinships().stream().map(k ->
                        FieldDTO.builder()
                                .id(k.getId())
                                .value(k.getKinship())
                                .build())
                        .collect(Collectors.toSet()))
                .residence(FieldDTO.builder().id(form.getResidence().getId()).value(form.getResidence().getResidence()).build())
                .socialBenefit(form.getSocialBenefit())
                .socialProgram(form.getSocialProgram())
                .chronicDiseases(form.getChronicDiseases())
                .handicappedFamily(form.getHandicappedFamily())
                .medicalMonitoring(form.getMedicalMonitoring())
                .suicideFamily(form.getSuicideFamily())
                .sufferedViolence(form.getSufferedViolence())
                .psychoactiveSubstances(form.getPsychoactiveSubstances())
                .familyConflict(form.getFamilyConflict())
                .manualActivity(form.getManualActivity())
                .socialActivity(form.getSocialActivity())
                .physicalActivity(form.getPhysicalActivity())
                .culturalActivity(form.getCulturalActivity())
                .qualityLife(FieldDTO.builder().id(form.getQualityLife().getId()).value(form.getQualityLife().getQualityLife()).build())
                .vaccinesUpToDate(form.getVaccinesUpToDate())
                .comments(form.getComments())
                .build();

        return info;
    }

}