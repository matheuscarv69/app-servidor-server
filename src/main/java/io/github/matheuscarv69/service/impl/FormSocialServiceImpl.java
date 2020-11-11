package io.github.matheuscarv69.service.impl;

import io.github.matheuscarv69.Util.DateUtil;
import io.github.matheuscarv69.domain.entity.FormSocial;
import io.github.matheuscarv69.domain.enums.*;
import io.github.matheuscarv69.domain.repository.FormSocialRepository;
import io.github.matheuscarv69.exceptions.ListIsEmptyException;
import io.github.matheuscarv69.exceptions.RegraNegocioException;
import io.github.matheuscarv69.rest.dto.FormSocialDTO;
import io.github.matheuscarv69.rest.dto.InfoFormSocialDTO;
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

        formSocial.setEstadoCivil(EstadoCivil.getEstadoCode(Integer.parseInt(dto.getEstadoCivil())));

        formSocial.setEscolaridade(Escolaridade.getEscolaridadeCode(Integer.parseInt(dto.getEscolaridade())));

        formSocial.setNumeroPessoasFam(dto.getNumeroPessoasFam());

        List<GrauParentesco> listGrauParentesco = converterCodeGrauParList(dto.getGrauParentesco());

        formSocial.setGrauParentesco(listGrauParentesco);

        formSocial.setResidencia(Residencia.getResidenciaCode(Integer.parseInt(dto.getResidencia())));

        formSocial.setBeneficio(Decisao.getDecisaoCode(Integer.parseInt(dto.getBeneficio())));
        if (Integer.parseInt(dto.getBeneficio()) == 1 && dto.getBeneficiosCadastrados().isEmpty()) {
            throw new RegraNegocioException("Campo Benefícios Cadastrados é obrigatório.");
        } else if (Integer.parseInt(dto.getBeneficio()) == 2 && dto.getBeneficiosCadastrados().isEmpty() == false) {
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


        formSocial.setProgramaSocial(Decisao.getDecisaoCode(Integer.parseInt(dto.getProgramaSocial())));
        if (Integer.parseInt(dto.getProgramaSocial()) == 1 && dto.getProgramasSociaisCadastrados().isEmpty()) {
            throw new RegraNegocioException("Campo Programas Sociais Cadastrados é obrigatório.");
        } else if (Integer.parseInt(dto.getProgramaSocial()) == 2 && dto.getProgramasSociaisCadastrados().isEmpty() == false) {
            throw new RegraNegocioException("Campo Programa Social deve estar com (Sim == 1) selecionado");
        } else if (dto.getProgramasSociaisCadastrados().contains("5") && dto.getOutroProgramaSocialDesc().isEmpty()) {
            throw new RegraNegocioException("Campo Outro Programa Social Descrição deve estar preenchido");
        } else if (!dto.getProgramasSociaisCadastrados().contains("5") && dto.getOutroProgramaSocialDesc().isEmpty() == false) {
            throw new RegraNegocioException("Campo Programas Sociais Cadastrados deve estar preenchido com (Outros == 5)");
        } else {
            List<ProgramasSociaisCadastrados> listProgramasSociaisCadastrados = converterCodeProgSocialParaList(dto.getProgramasSociaisCadastrados());
            formSocial.setProgramasSociaisCadastrados(listProgramasSociaisCadastrados);
            formSocial.setOutroProgramaSocialDesc(dto.getOutroProgramaSocialDesc());
        }


        formSocial.setDoencaCronica(Decisao.getDecisaoCode(Integer.parseInt(dto.getDoencaCronica())));
        if (Integer.parseInt(dto.getDoencaCronica()) == 1 && dto.getDoencasCronicasCadastradas().isEmpty()) {
            throw new RegraNegocioException("Campo Doenças Crônicas Cadastradas é obrigatório.");
        } else if (Integer.parseInt(dto.getDoencaCronica()) == 2 && dto.getDoencasCronicasCadastradas().isEmpty() == false) {
            throw new RegraNegocioException("Campo Doença Crônica deve estar com (Sim == 1) selecionado");
        } else if (dto.getDoencasCronicasCadastradas().contains("5") && dto.getOutraDoencaCronicasDesc().isEmpty()) {
            throw new RegraNegocioException("Campo Outra Doença Crônica Descrição deve estar preenchido");
        } else if (!dto.getDoencasCronicasCadastradas().contains("5") && dto.getOutraDoencaCronicasDesc().isEmpty() == false) {
            throw new RegraNegocioException("Campo Doenças Crônicas Cadastradas deve estar preenchido com (Outras == 5)");
        } else {
            List<DoencasCronicasCadastradas> listDoencasCronicaCadastradas = converterCodeDoencaCronicaParaList(dto.getDoencasCronicasCadastradas());
            formSocial.setDoencasCronicasCadastradas(listDoencasCronicaCadastradas);
            formSocial.setOutraDoencaCronicasDesc(dto.getOutraDoencaCronicasDesc());
        }


        formSocial.setDeficienteFamilia(Decisao.getDecisaoCode(Integer.parseInt(dto.getDeficienteFamilia())));
        if (Integer.parseInt(dto.getDeficienteFamilia()) == 1 && dto.getDeficienteFamiliaDescricao().isEmpty()) {
            throw new RegraNegocioException("Campo Deficiente Familia Descrição é obrigatório.");
        } else if (Integer.parseInt(dto.getDeficienteFamilia()) == 2 && dto.getDeficienteFamiliaDescricao().isEmpty() == false) {
            throw new RegraNegocioException("Campo Deficiente Familia deve estar com o (Sim == 1) selecionado.");
        } else {
            formSocial.setDeficienteFamiliaDescricao(dto.getDeficienteFamiliaDescricao());
        }

        formSocial.setAcompMedico(Decisao.getDecisaoCode(Integer.parseInt(dto.getAcompMedico())));
        if (Integer.parseInt(dto.getAcompMedico()) == 1 && dto.getAcompMedicoDescricao().isEmpty()) {
            throw new RegraNegocioException("Campo Acompanhamento Médico Descrição é obrigatório.");
        } else if (Integer.parseInt(dto.getAcompMedico()) == 2 && dto.getAcompMedicoDescricao().isEmpty() == false) {
            throw new RegraNegocioException("Campo Acompanhamento Médico deve estar com o (Sim == 1) selecionado.");
        } else {
            formSocial.setAcompMedicoDescricao(dto.getAcompMedicoDescricao());
        }

        formSocial.setSuicidioFamilia(Decisao.getDecisaoCode(Integer.parseInt(dto.getSuicidioFamilia())));
        if (Integer.parseInt(dto.getSuicidioFamilia()) == 1 && dto.getSuicidioGrauParentesco().isEmpty()) {
            throw new RegraNegocioException("Campo Grau de Parentesco do Suicidio da Família é obrigatório.");
        } else if (Integer.parseInt(dto.getSuicidioFamilia()) == 2 && dto.getSuicidioGrauParentesco().isEmpty() == false) {
            throw new RegraNegocioException("Campo Suícidio Familia deve estar com o (Sim == 1) selecionado");
        } else if(Integer.parseInt(dto.getSuicidioFamilia()) == 2 && dto.getSuicidioGrauParentesco().isEmpty()){
            formSocial.setSuicidioGrauParentesco(GrauParentesco.NENHUM_PARENTE);
            System.out.println("Campo nao e grau vazio");
        }else{
            formSocial.setSuicidioGrauParentesco(GrauParentesco.getGrauParentescoCode(Integer.parseInt(dto.getSuicidioGrauParentesco())));
        }

        formSocial.setViolencia(Decisao.getDecisaoCode(Integer.parseInt(dto.getViolencia())));
        if (Integer.parseInt(dto.getViolencia()) == 1 && dto.getViolenciasCadastradas().isEmpty()) {
            throw new RegraNegocioException("Campo Violências Cadastradas é obrigatório.");
        } else if (Integer.parseInt(dto.getViolencia()) == 2 && dto.getViolenciasCadastradas().isEmpty() == false) {
            throw new RegraNegocioException("Campo Violência deve estar com (Sim == 1) selecionado");
        } else if (dto.getViolenciasCadastradas().contains("6") && dto.getOutraViolenciaDescricao().isEmpty()) {
            throw new RegraNegocioException("Campo Outra Violência Descrição deve estar preenchido");
        } else if (!dto.getViolenciasCadastradas().contains("6") && dto.getOutraViolenciaDescricao().isEmpty() == false) {
            throw new RegraNegocioException("Campo Violências Cadastradas deve estar preenchido com (Outras == 6)");
        } else {
            List<ViolenciasCadastradas> listViolenciasCadastradas = converterCodeViolenciasCadParaList(dto.getViolenciasCadastradas());
            formSocial.setViolenciasCadastradas(listViolenciasCadastradas);
            formSocial.setOutraViolenciaDescricao(dto.getOutraViolenciaDescricao());
        }

        formSocial.setPsicoativos(Decisao.getDecisaoCode(Integer.parseInt(dto.getPsicoativos())));
        if (Integer.parseInt(dto.getPsicoativos()) == 1 && dto.getPsicoativosCadastrados().isEmpty()) {
            throw new RegraNegocioException("Campo Psicoativos Cadastradas é obrigatório.");
        } else if (Integer.parseInt(dto.getPsicoativos()) == 2 && dto.getPsicoativosCadastrados().isEmpty() == false) {
            throw new RegraNegocioException("Campo Psicoativos deve estar com (Sim == 1) selecionado");
        } else if (dto.getPsicoativosCadastrados().contains("4") && dto.getOutrosPsicoativosDescricao().isEmpty()) {
            throw new RegraNegocioException("Campo Outros Psicoativos Descrição deve estar preenchido");
        } else if (!dto.getPsicoativosCadastrados().contains("4") && dto.getOutrosPsicoativosDescricao().isEmpty() == false) {
            throw new RegraNegocioException("Campo Psicoativos Cadastradas deve estar preenchido com (Outros == 4)");
        } else {
            List<PsicoativosCadastrados> listPsicoativosCadastradas = converterCodePsicoativosCadParaList(dto.getPsicoativosCadastrados());
            formSocial.setPsicoativosCadastrados(listPsicoativosCadastradas);
            formSocial.setOutrosPsicoativosDescricao(dto.getOutrosPsicoativosDescricao());
        }

        formSocial.setConflitoFamiliar(Decisao.getDecisaoCode(Integer.parseInt(dto.getConflitoFamiliar())));

        formSocial.setAtividadesLazer(Decisao.getDecisaoCode(Integer.parseInt(dto.getAtividadesLazer())));
        if (Integer.parseInt(dto.getAtividadesLazer()) == 1 && dto.getAtividadeLazerCadastradas().isEmpty()) {
            throw new RegraNegocioException("Campo Atividades Lazer Cadastradas é obrigatório.");
        } else if (Integer.parseInt(dto.getAtividadesLazer()) == 2 && dto.getAtividadeLazerCadastradas().isEmpty() == false) {
            throw new RegraNegocioException("Campo Atividades Lazer deve estar com (Sim == 1) selecionado");
        } else if (dto.getAtividadeLazerCadastradas().contains("5") && dto.getOutrasAtividadeLazerDesc().isEmpty()) {
            throw new RegraNegocioException("Campo Outras Atividades Lazer Descrição deve estar preenchido");
        } else if (!dto.getAtividadeLazerCadastradas().contains("5") && dto.getOutrasAtividadeLazerDesc().isEmpty() == false) {
            throw new RegraNegocioException("Campo Atividades Lazer Cadastradas deve estar preenchido com (Outras == 5)");
        } else {
            List<AtividadeLazerCadastradas> listAtivLazeradastradas = converterCodeAtivLazerCadParaList(dto.getAtividadeLazerCadastradas());
            formSocial.setAtividadeLazerCadastradas(listAtivLazeradastradas);
            formSocial.setOutrasAtividadeLazerDesc(dto.getOutrasAtividadeLazerDesc());
        }

        formSocial.setAtividadeFisica(Decisao.getDecisaoCode(Integer.parseInt(dto.getAtividadeFisica())));
        if (Integer.parseInt(dto.getAtividadeFisica()) == 1 && dto.getAtividadeFisicaDesc().isEmpty()) {
            throw new RegraNegocioException("Campo Atividade Física Descrição é obrigatório.");
        } else if (Integer.parseInt(dto.getAtividadeFisica()) == 2 && dto.getAtividadeFisicaDesc().isEmpty() == false) {
            throw new RegraNegocioException("Campo Atividade Física deve estar com o (Sim == 1) selecionado.");
        } else {
            formSocial.setAtividadeFisicaDesc(dto.getAtividadeFisicaDesc());
        }


//        formSocial.setQualidadeVida(dto.getQualidadeVida());
        formSocial.setQualidadeVida(QualidadeVida.getQualidadeVIdaCode(Integer.parseInt(dto.getQualidadeVida())));

        formSocial.setVacinas(Vacinas.getVacinasCode(Integer.parseInt(dto.getVacinas())));

        repository.save(formSocial);

        return formSocial;
    }

    @Override
    public List<InfoFormSocialDTO> buscarForms() {
        List<FormSocial> listForms = repository.findAll();

        List<InfoFormSocialDTO> listInfoFormSocialDTO = new ArrayList<>();

        for (FormSocial formSocial : listForms) {
            listInfoFormSocialDTO.add(converterFormInfo(formSocial));
        }

        if (listInfoFormSocialDTO.isEmpty()) {
            throw new ListIsEmptyException("Nenhum formulário encontrado");
        }

        return listInfoFormSocialDTO;

    }

    public InfoFormSocialDTO converterFormInfo(FormSocial form){

        return InfoFormSocialDTO.builder()
                .id(form.getId())
                .nome(form.getNome())
                .idade(DateUtil.calculaIdade(form.getDataNascimento()))
                .dataNascismento(DateUtil.formatter.format(form.getDataNascimento()))
                .dataEntrevista(DateUtil.formatter.format(form.getDataEntrevista()))
                .telefone(form.getTelefone())
                .email(form.getEmail())
                .funcaoExerc(form.getFuncaoExerc())
                .tempoFuncaoExerc(form.getTempoFuncaoExerc())
                .estadoCivil(form.getEstadoCivil().toString())
                .escolaridade(form.getEscolaridade().toString())
                .numeroPessoasFam(form.getNumeroPessoasFam())
                .grauParentesco(form.getGrauParentesco().toString())
                .residencia(form.getResidencia().toString())
                .beneficio(form.getBeneficio().toString())
                .beneficiosCadastrados(form.getBeneficiosCadastrados().toString())
                .outroBeneficioDesc(form.getOutroBeneficioDesc())
                .programaSocial(form.getProgramaSocial().toString())
                .programasSociaisCadastrados(form.getProgramasSociaisCadastrados().toString())
                .outroProgramaSocialDesc(form.getOutroProgramaSocialDesc())
                .doencaCronica(form.getDoencaCronica().toString())
                .doencaCronicaCadastradas(form.getDoencasCronicasCadastradas().toString())
                .outraDoencaCronicaDesc(form.getOutraDoencaCronicasDesc())
                .deficienteFamilia(form.getDeficienteFamilia().toString())
                .deficienteFamiliaDescricao(form.getDeficienteFamiliaDescricao())
                .acompanhamentoMedico(form.getAcompMedico().toString())
                .acompanhamentoMedicoDesc(form.getAcompMedicoDescricao())
                .suicidioFamilia(form.getSuicidioFamilia().toString())
                .suicidioGrauParentesco(form.getSuicidioGrauParentesco().toString())
                .violencia(form.getViolencia().toString())
                .violenciasCadastradas(form.getViolenciasCadastradas().toString())
                .outraViolenciaDescricao(form.getOutraViolenciaDescricao())

                .psicoativos(form.getPsicoativos().toString())
                .psicoativosCadastrados(form.getPsicoativosCadastrados().toString())
                .outrosPsicoativosDescricao(form.getOutrosPsicoativosDescricao())

                .conflitoFamiliar(form.getConflitoFamiliar().toString())

                .atividadesLazer(form.getAtividadesLazer().toString())
                .atividadesLazerCadastradas(form.getAtividadeLazerCadastradas().toString())
                .outrasAtividadesLazerDesc(form.getOutrasAtividadeLazerDesc())
                
                .atividadeFisica(form.getAtividadeFisica().toString())
                .atividadeFisicaDesc(form.getAtividadeFisicaDesc())
                .qualidadeVida(form.getQualidadeVida().toString())
                .vacinas(form.getVacinas().toString())
                .build();
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

    public List<ProgramasSociaisCadastrados> converterCodeProgSocialParaList(String codes) {
        String[] indices = codes.split("-");
        List<ProgramasSociaisCadastrados> listaProgramasSociaisCad = new ArrayList<>();
        if (!codes.isEmpty()) {
            for (String code : indices) {
                int num = Integer.parseInt(code);
                listaProgramasSociaisCad.add(ProgramasSociaisCadastrados.getProgramasSociaisCadCode(num));
            }
        }

        return listaProgramasSociaisCad;
    }

    public List<DoencasCronicasCadastradas> converterCodeDoencaCronicaParaList(String codes) {
        String[] indices = codes.split("-");
        List<DoencasCronicasCadastradas> listaDoencaCronicasCad = new ArrayList<>();
        if (!codes.isEmpty()) {
            for (String code : indices) {
                int num = Integer.parseInt(code);
                listaDoencaCronicasCad.add(DoencasCronicasCadastradas.getDoencaCronicaCode(num));
            }
        }

        return listaDoencaCronicasCad;
    }

    public List<ViolenciasCadastradas> converterCodeViolenciasCadParaList(String codes) {
        String[] indices = codes.split("-");
        List<ViolenciasCadastradas> listaViolenciasCad = new ArrayList<>();
        if (!codes.isEmpty()) {
            for (String code : indices) {
                int num = Integer.parseInt(code);
                listaViolenciasCad.add(ViolenciasCadastradas.getViolenciaCode(num));
            }
        }

        return listaViolenciasCad;
    }

    public List<PsicoativosCadastrados> converterCodePsicoativosCadParaList(String codes) {
        String[] indices = codes.split("-");
        List<PsicoativosCadastrados> listaPsicoativosCad = new ArrayList<>();
        if (!codes.isEmpty()) {
            for (String code : indices) {
                int num = Integer.parseInt(code);
                listaPsicoativosCad.add(PsicoativosCadastrados.getPsicoativosCode(num));
            }
        }

        return listaPsicoativosCad;
    }

    public List<AtividadeLazerCadastradas> converterCodeAtivLazerCadParaList(String codes) {
        String[] indices = codes.split("-");
        List<AtividadeLazerCadastradas> listaAtivLazerCad = new ArrayList<>();
        if (!codes.isEmpty()) {
            for (String code : indices) {
                int num = Integer.parseInt(code);
                listaAtivLazerCad.add(AtividadeLazerCadastradas.getAtividadeLazerCadastradasCode(num));
            }
        }

        return listaAtivLazerCad;
    }

}