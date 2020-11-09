package io.github.matheuscarv69.service.impl;

import io.github.matheuscarv69.domain.entity.FormSocial;
import io.github.matheuscarv69.domain.enums.*;
import io.github.matheuscarv69.domain.repository.FormSocialRepository;
import io.github.matheuscarv69.rest.dto.FormSocialDTO;
import io.github.matheuscarv69.service.FormSocialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FormSocialServiceImpl implements FormSocialService {

    private final FormSocialRepository repository;

    @Override
    @Transactional
    public FormSocial salvar(FormSocialDTO dto) {

        FormSocial formSocial = new FormSocial();

        formSocial.setNome(dto.getNome());
        formSocial.setIdade(dto.getIdade());
        formSocial.setTelefone(dto.getTelefone());
        formSocial.setEmail(dto.getEmail());

        formSocial.setDataEntrevista(LocalDate.now());
        formSocial.setDataNascimento(LocalDate.now());

        formSocial.setFuncaoExerc(dto.getFuncaoExerc());
        formSocial.setTempoFuncaoExerc(dto.getTempoFuncaoExerc());

        formSocial.setEstadoCivil(dto.getEstadoCivil());
        formSocial.setEscolaridade(dto.getEscolaridade());

        formSocial.setNumeroPessoasFam(dto.getNumeroPessoasFam());

        formSocial.setGrauParentesco(dto.getGrauParentesco());
        formSocial.setResidencia(dto.getResidencia());

        formSocial.setBeneficio(dto.isBeneficio());
        formSocial.setBeneficioDesc(dto.getBeneficioDesc());

        formSocial.setProgramaSocial(dto.isProgramaSocial());
        formSocial.setProgramaSocialDesc(dto.getProgramaSocialDesc());

        formSocial.setDoencaCronica(dto.isDoencaCronica());
        formSocial.setDoencaCronicaDesc(dto.getDoencaCronicaDesc());

        formSocial.setDeficienteFamilia(dto.isDeficienteFamilia());
        formSocial.setDeficienteFamiliaDesc(dto.getDeficienteFamiliaDesc());

        formSocial.setAcompMedico(dto.isAcompMedico());
        formSocial.setAcompMedicoDesc(dto.getAcompMedicoDesc());

        formSocial.setSuicidioFamilia(dto.isSuicidioFamilia());
        formSocial.setSuicidioGrauParentesco(dto.getSuicidioGrauParentesco());

        formSocial.setViolencia(dto.isViolencia());
        formSocial.setViolenciaDesc(dto.getViolenciaDesc());

        formSocial.setPsicoativos(dto.isPsicoativos());
        formSocial.setPsicoativosDesc(dto.getPsicoativosDesc());

        formSocial.setConflitoFamiliar(dto.isConflitoFamiliar());

        formSocial.setAtividadeLazerDesc(dto.getAtividadeLazerDesc());

        formSocial.setAtividadeFisica(dto.isAtividadeFisica());
        formSocial.setAtividadeFisicaDesc(dto.getAtividadeFisicaDesc());

        formSocial.setQualidadeVida(dto.getQualidadeVida());

        formSocial.setVacinas(dto.getVacinas());

        repository.save(formSocial);

        return formSocial;
    }

    @Override
    public List<FormSocialDTO> buscarForms() {
        List<FormSocial> listForms = repository.findAll();

        List<FormSocialDTO> listFormDTO = new ArrayList<>();

        for(FormSocial formSocial : listForms ){
            listFormDTO.add(converterForm(formSocial));
        }

        return listFormDTO;

    }

    public FormSocialDTO converterForm(FormSocial form){

        return FormSocialDTO
                .builder()
                .id(form.getId())
                .nome(form.getNome())
                .idade(form.getIdade())
                .telefone(form.getTelefone())
                .email(form.getEmail())
                .dataEntrevista(form.getDataEntrevista().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .dataNascimento(form.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .funcaoExerc(form.getFuncaoExerc())
                .tempoFuncaoExerc(form.getTempoFuncaoExerc())
                .estadoCivil(form.getEstadoCivil())
                .escolaridade(form.getEscolaridade())
                .numeroPessoasFam(form.getNumeroPessoasFam())
                .grauParentesco(form.getGrauParentesco())
                .residencia(form.getResidencia())
                .beneficio(form.isBeneficio())
                .beneficioDesc(form.getBeneficioDesc())
                .programaSocial(form.isProgramaSocial())
                .programaSocialDesc(form.getProgramaSocialDesc())
                .doencaCronica(form.isDoencaCronica())
                .doencaCronicaDesc(form.getDoencaCronicaDesc())
                .deficienteFamilia(form.isDeficienteFamilia())
                .deficienteFamiliaDesc(form.getDeficienteFamiliaDesc())
                .acompMedico(form.isAcompMedico())
                .acompMedicoDesc(form.getAcompMedicoDesc())
                .suicidioFamilia(form.isSuicidioFamilia())
                .suicidioGrauParentesco(form.getSuicidioGrauParentesco())
                .violencia(form.isViolencia())
                .violenciaDesc(form.getViolenciaDesc())
                .psicoativos(form.isPsicoativos())
                .psicoativosDesc(form.getPsicoativosDesc())
                .atividadeLazerDesc(form.getAtividadeLazerDesc())
                .atividadeFisica(form.isAtividadeFisica())
                .atividadeFisicaDesc(form.getAtividadeFisicaDesc())
                .qualidadeVida(form.getQualidadeVida())
                .vacinas(form.getVacinas())
                .build();


    }

}
