package io.github.matheuscarv69.service.impl;

import io.github.matheuscarv69.domain.entity.FormSocial;
import io.github.matheuscarv69.domain.entity.fields.*;
import io.github.matheuscarv69.domain.repository.FormSocialRepository;
import io.github.matheuscarv69.domain.repository.fieldsRepositories.*;
import io.github.matheuscarv69.exceptions.*;
import io.github.matheuscarv69.rest.dto.FieldDTO;
import io.github.matheuscarv69.rest.dto.FormSocialDTO;
import io.github.matheuscarv69.rest.dto.InfoFormSocialDTO;
import io.github.matheuscarv69.service.FormSocialService;
import io.github.matheuscarv69.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
        formSocial.setPhoneNumber(dto.getPhoneNumber());
        formSocial.setEmail(dto.getEmail());
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
        formSocial.setSocialBenefit(dto.getSocialBenefit());
        formSocial.setSocialProgram(dto.getSocialProgram());
        formSocial.setChronicDiseases(dto.getChronicDiseases());
        formSocial.setHandicappedFamily(dto.getHandicappedFamily());
        formSocial.setMedicalMonitoring(dto.getMedicalMonitoring());
        formSocial.setSuicideFamily(dto.getSuicideFamily());
        formSocial.setSufferedViolence(dto.getSufferedViolence());
        formSocial.setPsychoactiveSubstances(dto.getPsychoactiveSubstances());
        formSocial.setFamilyConflict(dto.getFamilyConflict());

        formSocial.setManualActivity(dto.getManualActivity());
        formSocial.setSocialActivity(dto.getSocialActivity());
        formSocial.setPhysicalActivity(dto.getPhysicalActivity());
        formSocial.setCulturalActivity(dto.getCulturalActivity());

        formSocial.setQualityLife(instantiateQualityLife(dto.getQualityLife()));

        formSocial.setVaccinesUpToDate(dto.getVaccinesUpToDate());
        formSocial.setComments(dto.getComments());
        
        repository.save(formSocial);

        return formSocial;
    }

    @Override
    public List<InfoFormSocialDTO> buscarForms() {
        List<FormSocial> listForms = repository.findAll();

        List<InfoFormSocialDTO> listInfoForm = new ArrayList<>();
//
//        for (FormSocial form : listForms) {
//            listInfoForm.add(convertFormSocialInfo(form));
//        }

        return listInfoForm;
    }


    public StateCivil instantiateStateCivil(FieldDTO stateCivilDTO) {
        StateCivil stateCivil = new StateCivil();

        if (stateCivilDTO.getId() < 1 || stateCivilDTO.getId() > 6) {
            throw new StateCivilException("ID do Estado Civil é inválido. (1-6)");
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

            Optional<Kinship> KinshipBD = kinshipRepository.findById(index.getId());

            if (KinshipBD.isPresent()) {
                kinship.setId(KinshipBD.get().getId());
                kinship.setKinship(KinshipBD.get().getKinship());
                kinshipSet.add(kinship);
            }
        }

        return kinshipSet;
    }


//    public InfoFormSocialDTO convertFormSocialInfo(FormSocial form) {
//
//        List<KinshipDTO> listKinship = new ArrayList<>();
//        for (Kinship grau : form.getKinships()) {
//            KinshipDTO KinshipDTO = new KinshipDTO();
//            KinshipDTO.setKinship(grau.getKinship());
//            listKinship.add(KinshipDTO);
//        }
//
//        List<BeneficioDTO> listBeneficios = new ArrayList<>();
//        for (Beneficio beneficio : form.getBeneficios()) {
//            BeneficioDTO beneficioDTO = new BeneficioDTO();
//            beneficioDTO.setBeneficio(beneficio.getBeneficio());
//            listBeneficios.add(beneficioDTO);
//        }
//
//        List<ProgramaSocialDTO> listProgramas = new ArrayList<>();
//        for (ProgramaSocial programa : form.getProgramasSociais()) {
//            ProgramaSocialDTO programaSocialDTO = new ProgramaSocialDTO();
//            programaSocialDTO.setProgramaSocial(programa.getProgramaSocial());
//            listProgramas.add(programaSocialDTO);
//        }
//
//        List<DoencaCronicaDTO> listDoencas = new ArrayList<>();
//        for (DoencaCronica doenca : form.getDoencaCronicas()) {
//            DoencaCronicaDTO doencaDTO = new DoencaCronicaDTO();
//            doencaDTO.setDoencaCronica(doenca.getDoencaCronica());
//            listDoencas.add(doencaDTO);
//        }
//
//        DeficienteFamiliaDTO deficienteFamiliaDTO = new DeficienteFamiliaDTO();
//        deficienteFamiliaDTO.setPessoa(form.getDeficienteFamilia().getPessoa());
//        deficienteFamiliaDTO.setDeficiencia(form.getDeficienteFamilia().getDeficiencia());
//
//        SuicidioFamiliaDTO suicidioFamiliaDTO = new SuicidioFamiliaDTO();
//        suicidioFamiliaDTO.setSuicidio(form.getSuicidioFamilia().getSuicidio());
//        if (form.getSuicidioFamilia().getKinshipSuicidio() == null) {
//            suicidioFamiliaDTO.setKinshipSuicidio("Não há");
//        } else {
//            suicidioFamiliaDTO.setKinshipSuicidio(form.getSuicidioFamilia()
//                    .getKinshipSuicidio().getKinship());
//        }
//
//        List<ViolenciaDTO> listViolencias = new ArrayList<>();
//        for (Violencia violencia : form.getViolencias()) {
//            ViolenciaDTO violenciaDTO = new ViolenciaDTO();
//            violenciaDTO.setViolencia(violencia.getViolencia());
//            listViolencias.add(violenciaDTO);
//        }
//
//        List<PsicoativoDTO> listPsicoativos = new ArrayList<>();
//        for (Psicoativo psicoativo : form.getPsicoativos()) {
//            PsicoativoDTO psicoativoDTO = new PsicoativoDTO();
//            psicoativoDTO.setPsicoativo(psicoativo.getPsicoativo());
//            listPsicoativos.add(psicoativoDTO);
//        }
//
//        List<AtividadeLazerDTO> listAtividadeLazer = new ArrayList<>();
//        for (AtividadeLazer atividadeLazer : form.getAtividadesLazer()) {
//            AtividadeLazerDTO atividadeLazerDTO = new AtividadeLazerDTO();
//            atividadeLazerDTO.setAtividadeLazer(atividadeLazer.getAtividadeLazer());
//            listAtividadeLazer.add(atividadeLazerDTO);
//        }
//
//        return InfoFormSocialDTO.builder()
//                .id(form.getId())
//                .nome(form.getNome())
//                .idade(DateUtil.calculaIdade(form.getDataNascimento()))
//                .dataNascismento(DateUtil.formatter.format(form.getDataNascimento()))
//                .dataEntrevista(DateUtil.formatter.format(form.getDataEntrevista()))
//                .telefone(form.getTelefone())
//                .email(form.getEmail())
//                .funcaoExerc(form.getFuncaoExerc())
//                .tempoFuncaoExerc(form.getTempoFuncaoExerc())
//                .estadoCivil(form.getEstadoCivil().getEstadoCivil())
//                .Schooling(form.getSchooling().getSchooling())
//                .numeroPessoasFam(form.getNumeroPessoasFam())
//                .Kinship(listKinship)
//                .residencia(form.getResidencia().getResidencia())
//                .beneficio(listBeneficios)
//                .programaSocial(listProgramas)
//                .doencaCronica(listDoencas)
//                .deficienteFamilia(deficienteFamiliaDTO)
//                .acompMedico(form.getAcompMedico().getEspecialidadeMedica())
//                .suicidioFamilia(suicidioFamiliaDTO)
//                .violencia(listViolencias)
//                .psicoativos(listPsicoativos)
//                .conflitoFamiliar(form.getConflitoFamiliar().getConflito())
//                .atividadesLazer(listAtividadeLazer)
//                .atividadeFisica(form.getAtividadeFisica().getAtividadeFisica())
//                .qualidadeVida(form.getQualidadeVida().getQualidadeVida())
//                .vacinas(form.getVacina().getVacina())
//                .build();
//    }

}