package io.github.matheuscarv69.service.impl;

import io.github.matheuscarv69.Util.DateUtil;
import io.github.matheuscarv69.domain.entity.FormSocial;
import io.github.matheuscarv69.domain.enums.*;
import io.github.matheuscarv69.domain.repository.FormSocialRepository;
import io.github.matheuscarv69.exceptions.ListIsEmptyException;
import io.github.matheuscarv69.exceptions.RegraNegocioException;
import io.github.matheuscarv69.rest.dto.FormSocialDTO;
import io.github.matheuscarv69.service.FormSocialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
        formSocial.setTelefone(dto.getTelefone());
        formSocial.setEmail(dto.getEmail());
        formSocial.setDataEntrevista(new Date());

        Date date = DateUtil.formataStringData(dto.getDataNascimento());
        formSocial.setDataNascimento(date);

        formSocial.setFuncaoExerc(dto.getFuncaoExerc());
        formSocial.setTempoFuncaoExerc(dto.getTempoFuncaoExerc());

        formSocial.setEstadoCivil(EstadoCivil.getEstadoCode(dto.getEstadoCivil()));

        formSocial.setEscolaridade(Escolaridade.getEscolaridadeCode(dto.getEscolaridade()));

        formSocial.setNumeroPessoasFam(dto.getNumeroPessoasFam());

        List<GrauParentesco> listGrauParentesco = converterCodeGrauParList(dto.getGrauParentesco());

        formSocial.setGrauParentesco(listGrauParentesco);

        formSocial.setResidencia(Residencia.getResidenciaCode(dto.getResidencia()));

        formSocial.setBeneficio(Decisao.getDecisaoCode(dto.getBeneficio()));

        if (dto.getBeneficio() == 1 && dto.getBeneficiosCadastrados().isEmpty()) {
            throw new RegraNegocioException("Campo Benefícios Cadastrados é obrigatório.");
        } else if (dto.getBeneficio() == 2 && dto.getBeneficiosCadastrados().isEmpty() == false) {
            throw new RegraNegocioException("Campo Benefício deve estar com (Sim == 1) selecionado");
        } else if (dto.getBeneficiosCadastrados().contains("4") && dto.getOutroBeneficioDesc().isEmpty()) {
            throw new RegraNegocioException("Campo Outro Benefício Descrição deve estar preenchido");
        } else if (!dto.getBeneficiosCadastrados().contains("4") && dto.getOutroBeneficioDesc().isEmpty() == false) {
            throw new RegraNegocioException("Campo Benefícios Cadastrados deve estar preenchido com (Outros == 4");
        } else {
            List<BeneficiosCadastrados> listBeneficiosCadastrados = converterCodeBenefParaList(dto.getBeneficiosCadastrados());
            formSocial.setBeneficiosCadastrados(listBeneficiosCadastrados);
            formSocial.setOutroBeneficioDesc(dto.getOutroBeneficioDesc());
        }
//
        formSocial.setProgramaSocial(dto.getProgramaSocial());
        if (dto.getProgramaSocial().equals("Sim") && dto.getProgramaSocialDesc().isEmpty()) {
            throw new RegraNegocioException("Campo Programa Social Descrição é obrigatório.");
        } else if (dto.getProgramaSocial().equals("Não") && dto.getProgramaSocialDesc().isEmpty() == false) {
            throw new RegraNegocioException("Campo Programa Social deve estar com (Sim) selecionado.");
        } else {
            formSocial.setProgramaSocialDesc(dto.getProgramaSocialDesc());
        }

        formSocial.setDoencaCronicaDesc(dto.getDoencaCronicaDesc());

        formSocial.setDeficienteFamilia(dto.getDeficienteFamilia());
        if (dto.getDeficienteFamilia().equals("Sim") && dto.getDeficienteFamiliaDesc().isEmpty()) {
            throw new RegraNegocioException("Campo Deficiente Familia Descrição é obrigatório.");
        } else if (dto.getDeficienteFamilia().equals("Não") && dto.getDeficienteFamiliaDesc().isEmpty() == false) {
            throw new RegraNegocioException("Campo Deficiente Familia é deve estar com o (Sim) selecionado.");
        } else {
            formSocial.setDeficienteFamiliaDesc(dto.getDeficienteFamiliaDesc());
        }

        formSocial.setAcompMedico(dto.getAcompMedico());
        if (dto.getAcompMedico().equals("Sim") && dto.getAcompMedicoDesc().isEmpty()) {
            throw new RegraNegocioException("Campo Acompanhamento Médico Descrição é obrigatório.");
        } else if (dto.getAcompMedico().equals("Não") && dto.getAcompMedicoDesc().isEmpty() == false) {
            throw new RegraNegocioException("Campo Acompanhamento Médico deve estar com o (Sim) selecionado.");
        } else {
            formSocial.setAcompMedicoDesc(dto.getAcompMedicoDesc());
        }


        formSocial.setSuicidioFamilia(dto.getSuicidioFamilia());
        if (dto.getSuicidioFamilia().equals("Sim") && dto.getSuicidioGrauParentesco().isEmpty()) {
            throw new RegraNegocioException("Campo Grau de Parentesco da Família é obrigatório.");
        } else if (dto.getSuicidioFamilia().equals("Não") && dto.getSuicidioGrauParentesco().isEmpty() == false) {
            throw new RegraNegocioException("Campo Suícidio Familia deve estar com o (Sim) selecionado");
        } else {
            formSocial.setSuicidioGrauParentesco(dto.getSuicidioGrauParentesco());
        }

        formSocial.setViolenciaDesc(dto.getViolenciaDesc());

        formSocial.setPsicoativosDesc(dto.getPsicoativosDesc());

        formSocial.setConflitoFamiliar(dto.getConflitoFamiliar());

        formSocial.setAtividadeLazerDesc(dto.getAtividadeLazerDesc());

        formSocial.setAtividadeFisica(dto.getAtividadeFisica());
        if (dto.getAtividadeFisica().equals("Sim") && dto.getAtividadeFisicaDesc().isEmpty()) {
            throw new RegraNegocioException("Campo Atividade Física Descrição é obrigátório");
        } else if (dto.getAtividadeFisica().equals("Não") && dto.getAtividadeFisicaDesc().isEmpty() == false) {
            throw new RegraNegocioException("Campo Atividade Física deve estar com o (Sim) selecionado.");
        } else {
            formSocial.setAtividadeFisicaDesc(dto.getAtividadeFisicaDesc());
        }

        formSocial.setQualidadeVida(dto.getQualidadeVida());

        formSocial.setVacinas(dto.getVacinas());

        repository.save(formSocial);

        return formSocial;
    }

    public List<GrauParentesco> converterCodeGrauParList(String codes) {
        String[] indices = codes.split("-");
        List<GrauParentesco> listaGrauPar = new ArrayList<>();
        for (String code : indices) {
            int num = Integer.parseInt(code);
            listaGrauPar.add(GrauParentesco.getGrauParentescoCode(num));
        }
        return listaGrauPar;
    }

    public List<BeneficiosCadastrados> converterCodeBenefParaList(String codes) {
        String[] indices = codes.split("-");
        List<BeneficiosCadastrados> listaBeneficiosCad = new ArrayList<>();
        if (!codes.isEmpty()) {
            for (String code : indices) {
                int num = Integer.parseInt(code);
                listaBeneficiosCad.add(BeneficiosCadastrados.getBeneficiosCadastradosCode(num));
            }
        }

        return listaBeneficiosCad;
    }

    @Override
    public List<FormSocialDTO> buscarForms() {
        List<FormSocial> listForms = repository.findAll();

        List<FormSocialDTO> listFormDTO = new ArrayList<>();

        for (FormSocial formSocial : listForms) {
//            listFormDTO.add(converterForm(formSocial));
        }

        if (listFormDTO.isEmpty()) {
            throw new ListIsEmptyException("Nenhum formulário encontrado");
        }

        return listFormDTO;

    }

//    public FormSocialDTO converterForm(FormSocial form) {
//
//        return FormSocialDTO
//                .builder()
//                .id(form.getId())
//                .nome(form.getNome())
//                .idade(DateUtil.calculaIdade(form.getDataNascimento()))
//                .telefone(form.getTelefone())
//                .email(form.getEmail())
//                .dataNascimento(DateUtil.formatter.format(form.getDataNascimento()))
//                .dataEntrevista(DateUtil.formatter.format(form.getDataEntrevista()))
//                .funcaoExerc(form.getFuncaoExerc())
//                .tempoFuncaoExerc(form.getTempoFuncaoExerc())
////                .estadoCivil(form.getEstadoCivil().toString())
////                .escolaridade(form.getEscolaridade())
//                .numeroPessoasFam(form.getNumeroPessoasFam())
//                .grauParentesco(form.getGrauParentesco().toString())
////                .residencia(form.getResidencia().toString()) precisa de um inforDTO
////                .beneficio(form.getBeneficio())
//                .beneficioDesc(form.getBeneficioDesc())
//                .programaSocial(form.getProgramaSocial())
//                .programaSocialDesc(form.getProgramaSocialDesc())
//                .doencaCronicaDesc(form.getDoencaCronicaDesc())
//                .deficienteFamilia(form.getDeficienteFamilia())
//                .deficienteFamiliaDesc(form.getDeficienteFamiliaDesc())
//                .acompMedico(form.getAcompMedico())
//                .acompMedicoDesc(form.getAcompMedicoDesc())
//                .suicidioFamilia(form.getSuicidioFamilia())
//                .suicidioGrauParentesco(form.getSuicidioGrauParentesco())
//                .violenciaDesc(form.getViolenciaDesc())
//                .psicoativosDesc(form.getPsicoativosDesc())
//                .conflitoFamiliar(form.getConflitoFamiliar())
//                .atividadeLazerDesc(form.getAtividadeLazerDesc())
//                .atividadeFisica(form.getAtividadeFisica())
//                .atividadeFisicaDesc(form.getAtividadeFisicaDesc())
//                .qualidadeVida(form.getQualidadeVida())
//                .vacinas(form.getVacinas())
//                .build();
//
//
//    }
}