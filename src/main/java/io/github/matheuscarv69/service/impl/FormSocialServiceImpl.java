package io.github.matheuscarv69.service.impl;

import io.github.matheuscarv69.domain.entity.FormSocial;
import io.github.matheuscarv69.domain.repository.FormSocialRepository;
import io.github.matheuscarv69.exceptions.CampoInvalidoException;
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

//        if(dto.getIdade() > 0){
//            formSocial.setIdade(dto.getIdade());
//        }else{
//            throw  new CampoInvalidoException("Valor informado é inválido.");
//        }

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

        formSocial.setBeneficio(dto.getBeneficio());
        if(dto.getBeneficio().equals("Sim") && dto.getBeneficioDesc().isEmpty()){
            throw new CampoInvalidoException("Campo Benefício Descrição é obrigatório.");
        }else if(dto.getBeneficio().equals("Não") && dto.getBeneficioDesc().isEmpty() == false){
            throw new CampoInvalidoException("Campo Benefício deve estar com (Sim) selecionado");
        }else{
            formSocial.setBeneficioDesc(dto.getBeneficioDesc());
        }

        formSocial.setProgramaSocial(dto.getProgramaSocial());
        if(dto.getProgramaSocial().equals("Sim") && dto.getProgramaSocialDesc().isEmpty()){
            throw new CampoInvalidoException("Campo Programa Social Descrição é obrigatório.");
        }else if(dto.getProgramaSocial().equals("Não") && dto.getProgramaSocialDesc().isEmpty() == false){
            throw new CampoInvalidoException("Campo Programa Social deve estar com (Sim) selecionado.");
        }else {
            formSocial.setProgramaSocialDesc(dto.getProgramaSocialDesc());
        }

        formSocial.setDoencaCronicaDesc(dto.getDoencaCronicaDesc());

        formSocial.setDeficienteFamilia(dto.getDeficienteFamilia());
        if(dto.getDeficienteFamilia().equals("Sim") && dto.getDeficienteFamiliaDesc().isEmpty()){
            throw new CampoInvalidoException("Campo Deficiente Familia Descrição é obrigatório.");
        }else if(dto.getDeficienteFamilia().equals("Não") && dto.getDeficienteFamiliaDesc().isEmpty()==false){
            throw new CampoInvalidoException("Campo Deficiente Familia é deve estar com o (Sim) selecionado.");
        }else {
            formSocial.setDeficienteFamiliaDesc(dto.getDeficienteFamiliaDesc());
        }

        formSocial.setAcompMedico(dto.getAcompMedico());
        if(dto.getAcompMedico().equals("Sim") && dto.getAcompMedicoDesc().isEmpty()){
            throw new CampoInvalidoException("Campo Acompanhamento Médico Descrição é obrigatório.");
        }else if(dto.getAcompMedico().equals("Não") && dto.getAcompMedicoDesc().isEmpty()==false){
            throw new CampoInvalidoException("Campo Acompanhamento Médico deve estar com o (Sim) selecionado.");
        }else{
            formSocial.setAcompMedicoDesc(dto.getAcompMedicoDesc());
        }


        formSocial.setSuicidioFamilia(dto.getSuicidioFamilia());
        if(dto.getSuicidioFamilia().equals("Sim") && dto.getSuicidioGrauParentesco().isEmpty()){
            throw new CampoInvalidoException("Campo Grau de Parentesco da Família é obrigatório.");
        }else if(dto.getSuicidioFamilia().equals("Não") && dto.getSuicidioGrauParentesco().isEmpty()==false){
            throw new CampoInvalidoException("Campo Suícidio Familia deve estar com o (Sim) selecionado");
        }else {
            formSocial.setSuicidioGrauParentesco(dto.getSuicidioGrauParentesco());
        }

        formSocial.setViolenciaDesc(dto.getViolenciaDesc());

        formSocial.setPsicoativosDesc(dto.getPsicoativosDesc());

        formSocial.setConflitoFamiliar(dto.getConflitoFamiliar());

        formSocial.setAtividadeLazerDesc(dto.getAtividadeLazerDesc());


        formSocial.setAtividadeFisica(dto.getAtividadeFisica());
        if(dto.getAtividadeFisica().equals("Sim") && dto.getAtividadeFisicaDesc().isEmpty()){
            throw new CampoInvalidoException("Campo Atividade Física Descrição é obrigátório");
        }else if(dto.getAtividadeFisica().equals("Não") && dto.getAtividadeFisicaDesc().isEmpty()==false){
            throw new CampoInvalidoException("Campo Atividade Física deve estar com o (Sim) selecionado.");
        }else{
            formSocial.setAtividadeFisicaDesc(dto.getAtividadeFisicaDesc());
        }

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
                .beneficio(form.getBeneficio())
                .beneficioDesc(form.getBeneficioDesc())
                .programaSocial(form.getProgramaSocial())
                .programaSocialDesc(form.getProgramaSocialDesc())
                .doencaCronicaDesc(form.getDoencaCronicaDesc())
                .deficienteFamilia(form.getDeficienteFamilia())
                .deficienteFamiliaDesc(form.getDeficienteFamiliaDesc())
                .acompMedico(form.getAcompMedico())
                .acompMedicoDesc(form.getAcompMedicoDesc())
                .suicidioFamilia(form.getSuicidioFamilia())
                .suicidioGrauParentesco(form.getSuicidioGrauParentesco())
                .violenciaDesc(form.getViolenciaDesc())
                .psicoativosDesc(form.getPsicoativosDesc())
                .conflitoFamiliar(form.getConflitoFamiliar())
                .atividadeLazerDesc(form.getAtividadeLazerDesc())
                .atividadeFisica(form.getAtividadeFisica())
                .atividadeFisicaDesc(form.getAtividadeFisicaDesc())
                .qualidadeVida(form.getQualidadeVida())
                .vacinas(form.getVacinas())
                .build();
    }

}
