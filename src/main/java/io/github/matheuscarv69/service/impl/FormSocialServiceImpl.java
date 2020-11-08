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

        formSocial.setEstadoCivil(EstadoCivil.valueOf(dto.getEstadoCivil().toUpperCase()));
        formSocial.setEscolaridade(Escolaridade.valueOf(dto.getEscolaridade().toUpperCase()));

        formSocial.setNumeroPessoasFam(dto.getNumeroPessoasFam());

        formSocial.setGrauParentesco(GrauParentesco.valueOf(dto.getGrauParentesco().toUpperCase()));
        formSocial.setResidencia(Residencia.valueOf(dto.getResidencia().toUpperCase()));

        formSocial.setBeneficio(dto.isBeneficio());
        formSocial.setBeneficioDescricao(dto.getBeneficioDescricao());
        formSocial.setProgramaSocial(dto.isProgramaSocial());
        formSocial.setProgramaSocialDescricao(dto.getProgramaSocialDescricao());
        formSocial.setDoencaCronica(dto.isDoencaCronica());
        formSocial.setDoencaCronicaDescricao(dto.getDoencaCronicaDescricao());

        formSocial.setDeficienteFamilia(dto.isDeficienteFamilia());
        formSocial.setDeficienteFamiliaDescricao(dto.getDeficienteFamiliaDesc());

        formSocial.setAcompMedico(dto.isAcompMedico());
        formSocial.setAcompMedicoDescricao(dto.getAcompMedicoDescricao());

        formSocial.setSuicidioFamilia(dto.isSuicidioFamilia());
        formSocial.setSuicidioGrauParentesco(GrauParentesco.valueOf(dto.getGrauParentesco().toUpperCase()));

        formSocial.setViolencia(Violencia.valueOf(dto.getViolencia().toUpperCase()));// conversar sobre isso
        formSocial.setViolenciaDescricao(dto.getViolenciaDescricao());

        formSocial.setPsicoativos(dto.isPsicoativos());
        formSocial.setPsicoativosDescricao(dto.getPsicoativosDescricao());
        formSocial.setConflitoFamiliar(dto.isConflitoFamiliar());

        formSocial.setAtividadeLazer(AtividadeLazer.valueOf(dto.getAtividadeLazer().toUpperCase()));
        formSocial.setAtividadeLazerDescricao(dto.getAtividadeLazerDescricao());

        formSocial.setAtividadeFisica(dto.isAtividadeFisica());
        formSocial.setAtividadeFisicaDescricao(dto.getAtividadeFisicaDescricao());

        formSocial.setQualidadeVida(QualidadeVida.valueOf(dto.getQualidadeVida().toUpperCase()));
        formSocial.setVacinas(Vacinas.valueOf(dto.getVacinas().toUpperCase()));





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
                .estadoCivil(form.getEstadoCivil().name())
                .escolaridade(form.getEscolaridade().name())
                .numeroPessoasFam(form.getNumeroPessoasFam())
                .grauParentesco(form.getGrauParentesco().name())
                .residencia(form.getResidencia().name())
                .beneficio(form.isBeneficio())
                .beneficioDescricao(form.getBeneficioDescricao())
                .programaSocial(form.isProgramaSocial())
                .programaSocialDescricao(form.getProgramaSocialDescricao())
                .doencaCronica(form.isDoencaCronica())
                .doencaCronicaDescricao(form.getDoencaCronicaDescricao())
                .deficienteFamilia(form.isDeficienteFamilia())
                .deficienteFamiliaDesc(form.getDeficienteFamiliaDescricao())
                .acompMedico(form.isAcompMedico())
                .acompMedicoDescricao(form.getAcompMedicoDescricao())
                .suicidioFamilia(form.isSuicidioFamilia())
                .suicidioGrauParentesco(form.getSuicidioGrauParentesco().name())
                .violencia(form.getViolencia().name())
                .violenciaDescricao(form.getViolenciaDescricao())
                .psicoativos(form.isPsicoativos())
                .psicoativosDescricao(form.getPsicoativosDescricao())
                .atividadeLazer(form.getAtividadeLazer().name())
                .atividadeLazerDescricao(form.getAtividadeLazerDescricao())
                .atividadeFisica(form.isAtividadeFisica())
                .atividadeFisicaDescricao(form.getAtividadeFisicaDescricao())
                .qualidadeVida(form.getQualidadeVida().name())
                .vacinas(form.getVacinas().name())
                .build();


    }

}
