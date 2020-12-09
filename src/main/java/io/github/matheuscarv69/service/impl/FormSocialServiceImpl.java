package io.github.matheuscarv69.service.impl;

import io.github.matheuscarv69.domain.entity.FormSocial;
import io.github.matheuscarv69.domain.entity.othersEntity.*;
import io.github.matheuscarv69.domain.repository.*;
import io.github.matheuscarv69.exceptions.*;
import io.github.matheuscarv69.rest.dto.FormSocialDTO;
import io.github.matheuscarv69.service.FormSocialService;
import io.github.matheuscarv69.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FormSocialServiceImpl implements FormSocialService {

    private final FormSocialRepository repository;
    private final EstadoCivilRepository estadoCivilRepository;
    private final EscolaridadeRepository escolaridadeRepository;
    private final ResidenciaRepository residenciaRepository;
    private final GrauParentescoRepository grauParentescoRepository;
    private final BeneficioRepository beneficioRepository;
    private final ProgramaSocialRepository programaSocialRepository;

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

        //estadoCivil
        formSocial.setEstadoCivil(persistEstadoCivil(dto));

        // escolaridade
        formSocial.setEscolaridade(persistEscolaridade(dto));

        // grauParentesco
        List<GrauParentesco> listParentescos = convertIndexGrauParentesco(dto);

        // numero de pessoas familia
        formSocial.setNumeroPessoasFam(dto.getNumeroPessoasFam());

        // residencia
        formSocial.setResidencia(persistResidencia(dto));

        // beneficios
        List<Beneficio> listBeneficios = convertIndexBeneficio(dto);

        // criar lógica para inserir os programas sociais
        List<ProgramaSocial> listProgramas = convertIndexProgramaSocial(dto);


        repository.save(formSocial);
        System.out.println("Form salvo: " + formSocial.toString());

        // salva os ids na table associativa
        formSocial.getGrauParentescos().addAll(listParentescos);
        formSocial.getBeneficios().addAll(listBeneficios);
        formSocial.getProgramasSociais().addAll(listProgramas);
        repository.save(formSocial);

        return formSocial;


//        formSocial.setProgramaSocial(Decisao.getDecisaoCode(Integer.parseInt(dto.getProgramaSocial())));
//        if (Integer.parseInt(dto.getProgramaSocial()) == 1 && dto.getProgramasSociaisCadastrados().isEmpty()) {
//            throw new RegraNegocioException("Campo Programas Sociais Cadastrados é obrigatório.");
//        } else if (Integer.parseInt(dto.getProgramaSocial()) == 2 && dto.getProgramasSociaisCadastrados().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Programa Social deve estar com (Sim == 1) selecionado");
//        } else if (dto.getProgramasSociaisCadastrados().contains("5") && dto.getOutroProgramaSocialDesc().isEmpty()) {
//            throw new RegraNegocioException("Campo Outro Programa Social Descrição deve estar preenchido");
//        } else if (!dto.getProgramasSociaisCadastrados().contains("5") && dto.getOutroProgramaSocialDesc().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Programas Sociais Cadastrados deve estar preenchido com (Outros == 5)");
//        } else {
//            List<ProgramasSociaisCadastrados> listProgramasSociaisCadastrados = converterCodeProgSocialParaList(dto.getProgramasSociaisCadastrados());
//            formSocial.setProgramasSociaisCadastrados(listProgramasSociaisCadastrados);
//            formSocial.setOutroProgramaSocialDesc(dto.getOutroProgramaSocialDesc());
//        }
//
//
//        formSocial.setDoencaCronica(Decisao.getDecisaoCode(Integer.parseInt(dto.getDoencaCronica())));
//        if (Integer.parseInt(dto.getDoencaCronica()) == 1 && dto.getDoencasCronicasCadastradas().isEmpty()) {
//            throw new RegraNegocioException("Campo Doenças Crônicas Cadastradas é obrigatório.");
//        } else if (Integer.parseInt(dto.getDoencaCronica()) == 2 && dto.getDoencasCronicasCadastradas().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Doença Crônica deve estar com (Sim == 1) selecionado");
//        } else if (dto.getDoencasCronicasCadastradas().contains("5") && dto.getOutraDoencaCronicasDesc().isEmpty()) {
//            throw new RegraNegocioException("Campo Outra Doença Crônica Descrição deve estar preenchido");
//        } else if (!dto.getDoencasCronicasCadastradas().contains("5") && dto.getOutraDoencaCronicasDesc().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Doenças Crônicas Cadastradas deve estar preenchido com (Outras == 5)");
//        } else {
//            List<DoencasCronicasCadastradas> listDoencasCronicaCadastradas = converterCodeDoencaCronicaParaList(dto.getDoencasCronicasCadastradas());
//            formSocial.setDoencasCronicasCadastradas(listDoencasCronicaCadastradas);
//            formSocial.setOutraDoencaCronicasDesc(dto.getOutraDoencaCronicasDesc());
//        }
//
//
//        formSocial.setDeficienteFamilia(Decisao.getDecisaoCode(Integer.parseInt(dto.getDeficienteFamilia())));
//        if (Integer.parseInt(dto.getDeficienteFamilia()) == 1 && dto.getDeficienteFamiliaDescricao().isEmpty()) {
//            throw new RegraNegocioException("Campo Deficiente Familia Descrição é obrigatório.");
//        } else if (Integer.parseInt(dto.getDeficienteFamilia()) == 2 && dto.getDeficienteFamiliaDescricao().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Deficiente Familia deve estar com o (Sim == 1) selecionado.");
//        } else {
//            formSocial.setDeficienteFamiliaDescricao(dto.getDeficienteFamiliaDescricao());
//        }
//
//        formSocial.setAcompMedico(Decisao.getDecisaoCode(Integer.parseInt(dto.getAcompMedico())));
//        if (Integer.parseInt(dto.getAcompMedico()) == 1 && dto.getAcompMedicoDescricao().isEmpty()) {
//            throw new RegraNegocioException("Campo Acompanhamento Médico Descrição é obrigatório.");
//        } else if (Integer.parseInt(dto.getAcompMedico()) == 2 && dto.getAcompMedicoDescricao().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Acompanhamento Médico deve estar com o (Sim == 1) selecionado.");
//        } else {
//            formSocial.setAcompMedicoDescricao(dto.getAcompMedicoDescricao());
//        }
//
//        formSocial.setSuicidioFamilia(Decisao.getDecisaoCode(Integer.parseInt(dto.getSuicidioFamilia())));
//        if (Integer.parseInt(dto.getSuicidioFamilia()) == 1 && dto.getSuicidioGrauParentesco().isEmpty()) {
//            throw new RegraNegocioException("Campo Grau de Parentesco do Suicidio da Família é obrigatório.");
//        } else if (Integer.parseInt(dto.getSuicidioFamilia()) == 2 && dto.getSuicidioGrauParentesco().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Suícidio Familia deve estar com o (Sim == 1) selecionado");
//        } else if(Integer.parseInt(dto.getSuicidioFamilia()) == 2 && dto.getSuicidioGrauParentesco().isEmpty()){
//            formSocial.setSuicidioGrauParentesco(GrauParentesco.NENHUM_PARENTE);
//            System.out.println("Campo nao e grau vazio");
//        }else{
//            formSocial.setSuicidioGrauParentesco(GrauParentesco.getGrauParentescoCode(Integer.parseInt(dto.getSuicidioGrauParentesco())));
//        }
//
//        formSocial.setViolencia(Decisao.getDecisaoCode(Integer.parseInt(dto.getViolencia())));
//        if (Integer.parseInt(dto.getViolencia()) == 1 && dto.getViolenciasCadastradas().isEmpty()) {
//            throw new RegraNegocioException("Campo Violências Cadastradas é obrigatório.");
//        } else if (Integer.parseInt(dto.getViolencia()) == 2 && dto.getViolenciasCadastradas().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Violência deve estar com (Sim == 1) selecionado");
//        } else if (dto.getViolenciasCadastradas().contains("6") && dto.getOutraViolenciaDescricao().isEmpty()) {
//            throw new RegraNegocioException("Campo Outra Violência Descrição deve estar preenchido");
//        } else if (!dto.getViolenciasCadastradas().contains("6") && dto.getOutraViolenciaDescricao().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Violências Cadastradas deve estar preenchido com (Outras == 6)");
//        } else {
//            List<ViolenciasCadastradas> listViolenciasCadastradas = converterCodeViolenciasCadParaList(dto.getViolenciasCadastradas());
//            formSocial.setViolenciasCadastradas(listViolenciasCadastradas);
//            formSocial.setOutraViolenciaDescricao(dto.getOutraViolenciaDescricao());
//        }
//
//        formSocial.setPsicoativos(Decisao.getDecisaoCode(Integer.parseInt(dto.getPsicoativos())));
//        if (Integer.parseInt(dto.getPsicoativos()) == 1 && dto.getPsicoativosCadastrados().isEmpty()) {
//            throw new RegraNegocioException("Campo Psicoativos Cadastradas é obrigatório.");
//        } else if (Integer.parseInt(dto.getPsicoativos()) == 2 && dto.getPsicoativosCadastrados().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Psicoativos deve estar com (Sim == 1) selecionado");
//        } else if (dto.getPsicoativosCadastrados().contains("4") && dto.getOutrosPsicoativosDescricao().isEmpty()) {
//            throw new RegraNegocioException("Campo Outros Psicoativos Descrição deve estar preenchido");
//        } else if (!dto.getPsicoativosCadastrados().contains("4") && dto.getOutrosPsicoativosDescricao().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Psicoativos Cadastradas deve estar preenchido com (Outros == 4)");
//        } else {
//            List<PsicoativosCadastrados> listPsicoativosCadastradas = converterCodePsicoativosCadParaList(dto.getPsicoativosCadastrados());
//            formSocial.setPsicoativosCadastrados(listPsicoativosCadastradas);
//            formSocial.setOutrosPsicoativosDescricao(dto.getOutrosPsicoativosDescricao());
//        }
//
//        formSocial.setConflitoFamiliar(Decisao.getDecisaoCode(Integer.parseInt(dto.getConflitoFamiliar())));
//
//        formSocial.setAtividadesLazer(Decisao.getDecisaoCode(Integer.parseInt(dto.getAtividadesLazer())));
//        if (Integer.parseInt(dto.getAtividadesLazer()) == 1 && dto.getAtividadeLazerCadastradas().isEmpty()) {
//            throw new RegraNegocioException("Campo Atividades Lazer Cadastradas é obrigatório.");
//        } else if (Integer.parseInt(dto.getAtividadesLazer()) == 2 && dto.getAtividadeLazerCadastradas().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Atividades Lazer deve estar com (Sim == 1) selecionado");
//        } else if (dto.getAtividadeLazerCadastradas().contains("5") && dto.getOutrasAtividadeLazerDesc().isEmpty()) {
//            throw new RegraNegocioException("Campo Outras Atividades Lazer Descrição deve estar preenchido");
//        } else if (!dto.getAtividadeLazerCadastradas().contains("5") && dto.getOutrasAtividadeLazerDesc().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Atividades Lazer Cadastradas deve estar preenchido com (Outras == 5)");
//        } else {
//            List<AtividadeLazerCadastradas> listAtivLazeradastradas = converterCodeAtivLazerCadParaList(dto.getAtividadeLazerCadastradas());
//            formSocial.setAtividadeLazerCadastradas(listAtivLazeradastradas);
//            formSocial.setOutrasAtividadeLazerDesc(dto.getOutrasAtividadeLazerDesc());
//        }
//
//        formSocial.setAtividadeFisica(Decisao.getDecisaoCode(Integer.parseInt(dto.getAtividadeFisica())));
//        if (Integer.parseInt(dto.getAtividadeFisica()) == 1 && dto.getAtividadeFisicaDesc().isEmpty()) {
//            throw new RegraNegocioException("Campo Atividade Física Descrição é obrigatório.");
//        } else if (Integer.parseInt(dto.getAtividadeFisica()) == 2 && dto.getAtividadeFisicaDesc().isEmpty() == false) {
//            throw new RegraNegocioException("Campo Atividade Física deve estar com o (Sim == 1) selecionado.");
//        } else {
//            formSocial.setAtividadeFisicaDesc(dto.getAtividadeFisicaDesc());
//        }
//
//
////        formSocial.setQualidadeVida(dto.getQualidadeVida());
//        formSocial.setQualidadeVida(QualidadeVida.getQualidadeVIdaCode(Integer.parseInt(dto.getQualidadeVida())));
//
//        formSocial.setVacinas(Vacinas.getVacinasCode(Integer.parseInt(dto.getVacinas())));

    }


    @Override
    public List<FormSocial> buscarForms() {
//        List<FormSocial> listForms = repository.findAll();
//        return listForms;
        return repository.findAll();
    }

    public EstadoCivil persistEstadoCivil(FormSocialDTO dto) {
        EstadoCivil estadoCivil = new EstadoCivil();

        if (dto.getEstadoCivil() < 1 || dto.getEstadoCivil() > 6) {
            throw new EstadoCivilException("ID do Estado Civil é inválido");
        }

        Optional<EstadoCivil> estadoBD = estadoCivilRepository.findById(dto.getEstadoCivil());

        if (estadoBD.isPresent()) {
            estadoCivil.setId(estadoBD.get().getId());
            estadoCivil.setEstado(estadoBD.get().getEstado());
        }

        return estadoCivil;
    }

    public Escolaridade persistEscolaridade(FormSocialDTO dto) {
        Escolaridade escolaridade = new Escolaridade();

        if (dto.getEscolaridade() < 1 || dto.getEscolaridade() > 7) {
            throw new EscolaridadeException("ID da Escolaridade é inválido");
        }

        Optional<Escolaridade> escolaridadeBD = escolaridadeRepository.findById(dto.getEscolaridade());

        if (escolaridadeBD.isPresent()) {
            escolaridade.setId(escolaridadeBD.get().getId());
            escolaridade.setEscolaridade(escolaridadeBD.get().getEscolaridade());
        }

        return escolaridade;
    }

    public Residencia persistResidencia(FormSocialDTO dto) {
        Residencia residencia = new Residencia();

        if (dto.getResidencia() < 1 || dto.getResidencia() > 4) {
            throw new ResidenciaException("ID da Residência é inválido");
        }

        Optional<Residencia> residenciaBD = residenciaRepository.findById(dto.getResidencia());

        if (residenciaBD.isPresent()) {
            residencia.setId(residenciaBD.get().getId());
            residencia.setResidencia(residenciaBD.get().getResidencia());
        }

        return residencia;
    }

    public List<GrauParentesco> convertIndexGrauParentesco(FormSocialDTO dto) {
        List<GrauParentesco> listGrauParentesco = new ArrayList<>();

        for (Integer index : dto.getGrauParentesco()) {
            if (index < 1 || index > 12) {
                throw new GrauParentescoException("Algum dos ID's de Grau Parentesco é inválido. (1-12)");
            }

            GrauParentesco grauParentesco = new GrauParentesco();

            Optional<GrauParentesco> grauParentescoBD = grauParentescoRepository.findById(index);

            if (grauParentescoBD.isPresent()) {
                grauParentesco.setId(grauParentescoBD.get().getId());
                grauParentesco.setGrauParentesco(grauParentescoBD.get().getGrauParentesco());
                listGrauParentesco.add(grauParentesco);
            }
        }

        return listGrauParentesco;
    }

    public List<Beneficio> convertIndexBeneficio(FormSocialDTO dto) {
        List<Beneficio> listBeneficios = new ArrayList<>();

        for (Integer index : dto.getBeneficio()) {
            Beneficio beneficio = new Beneficio();

            if (index < 1 || index > 5) {
                throw new BeneficioException("Algum dos ID's de Beneficio é inválido. (1-5)");
            } else if (index == 1 && dto.getBeneficio().size() > 1) {
                throw new BeneficioException("O campo ID 1 (Nenhum) está selecionado, por isso não é possível adicionar os outros benefícios disponíveis (1-5)");
            } else if (index == 5 && dto.getOutroBeneficio().isEmpty()) {
                throw new BeneficioException("O ID 5 (Outros) está selecionado e o campo Outro Benefício está vazio, preencha-o");
            } else if (!dto.getBeneficio().contains(5) && !dto.getOutroBeneficio().isEmpty()) {
                throw new BeneficioException("O ID 5 (Outros) não está selecionado, selecione-o para poder preencher o campo Outro Benefício");
            }

            Optional<Beneficio> beneficioBD = beneficioRepository.findById(index);

            if (beneficioBD.isPresent() && beneficioBD.get().getId() != 5) {
                beneficio.setId(beneficioBD.get().getId());
                beneficio.setBeneficio(beneficioBD.get().getBeneficio());

                listBeneficios.add(beneficio);
            }

            if (beneficioBD.get().getId() == 5) {
                beneficio.setBeneficio(dto.getOutroBeneficio());
                beneficioRepository.save(beneficio);
                listBeneficios.add(beneficio);
            }
        }
        return listBeneficios;
    }

    public List<ProgramaSocial> convertIndexProgramaSocial(FormSocialDTO dto) {
        List<ProgramaSocial> listProgramas = new ArrayList<>();

        for (Integer index : dto.getProgramaSocial()) {
            ProgramaSocial programaSocial = new ProgramaSocial();

            if (index < 1 || index > 5) {
                throw new ProgramaSocialException("Algum dos ID's dos Programas Sociais é inválido. (1-5)");
            } else if (index == 1 && dto.getProgramaSocial().size() > 1) {
                throw new ProgramaSocialException("O campo ID 1 (Não) está selecionado, por isso não é possível adicionar os outros Programas Sociais disponíveis (1-5)");
            } else if (index == 5 && dto.getOutroProgramaSocial().isEmpty()) {
                throw new ProgramaSocialException("O ID 5 (Outros) está selecionado e o campo Outro Programa Social está vazio, preencha-o ");
            } else if (!dto.getProgramaSocial().contains(5) && !dto.getOutroProgramaSocial().isEmpty()) {
                throw new ProgramaSocialException("O ID 5 (Outros) não está selecionado, selecione-o para poder preencher o campo Outro Programa Social");
            }

            Optional<ProgramaSocial> programaSocialBD = programaSocialRepository.findById(index);

            if (programaSocialBD.isPresent() && programaSocialBD.get().getId() != 5) {
                programaSocial.setId(programaSocialBD.get().getId());
                programaSocial.setProgramaSocial(programaSocialBD.get().getProgramaSocial());

                listProgramas.add(programaSocial);
            }

            if (programaSocialBD.get().getId() == 5) {
                programaSocial.setProgramaSocial(dto.getOutroProgramaSocial());
                programaSocialRepository.save(programaSocial);
                listProgramas.add(programaSocial);
            }
        }
        return listProgramas;
    }


//
//    public InfoFormSocialDTO converterFormInfo(FormSocial form){
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
//                .estadoCivil(form.getEstadoCivil().toString())
//                .escolaridade(form.getEscolaridade().toString())
//                .numeroPessoasFam(form.getNumeroPessoasFam())
//                .grauParentesco(form.getGrauParentesco().toString())
//                .residencia(form.getResidencia().toString())
//                .beneficio(form.getBeneficio().toString())
//                .beneficiosCadastrados(form.getBeneficiosCadastrados().toString())
//                .outroBeneficioDesc(form.getOutroBeneficioDesc())
//                .programaSocial(form.getProgramaSocial().toString())
//                .programasSociaisCadastrados(form.getProgramasSociaisCadastrados().toString())
//                .outroProgramaSocialDesc(form.getOutroProgramaSocialDesc())
//                .doencaCronica(form.getDoencaCronica().toString())
//                .doencaCronicaCadastradas(form.getDoencasCronicasCadastradas().toString())
//                .outraDoencaCronicaDesc(form.getOutraDoencaCronicasDesc())
//                .deficienteFamilia(form.getDeficienteFamilia().toString())
//                .deficienteFamiliaDescricao(form.getDeficienteFamiliaDescricao())
//                .acompanhamentoMedico(form.getAcompMedico().toString())
//                .acompanhamentoMedicoDesc(form.getAcompMedicoDescricao())
//                .suicidioFamilia(form.getSuicidioFamilia().toString())
//                .suicidioGrauParentesco(form.getSuicidioGrauParentesco().toString())
//                .violencia(form.getViolencia().toString())
//                .violenciasCadastradas(form.getViolenciasCadastradas().toString())
//                .outraViolenciaDescricao(form.getOutraViolenciaDescricao())
//
//                .psicoativos(form.getPsicoativos().toString())
//                .psicoativosCadastrados(form.getPsicoativosCadastrados().toString())
//                .outrosPsicoativosDescricao(form.getOutrosPsicoativosDescricao())
//
//                .conflitoFamiliar(form.getConflitoFamiliar().toString())
//
//                .atividadesLazer(form.getAtividadesLazer().toString())
//                .atividadesLazerCadastradas(form.getAtividadeLazerCadastradas().toString())
//                .outrasAtividadesLazerDesc(form.getOutrasAtividadeLazerDesc())
//
//                .atividadeFisica(form.getAtividadeFisica().toString())
//                .atividadeFisicaDesc(form.getAtividadeFisicaDesc())
//                .qualidadeVida(form.getQualidadeVida().toString())
//                .vacinas(form.getVacinas().toString())
//                .build();
//    }
//
//    public List<GrauParentesco> converterCodeGrauParList(String codes) {
//        String[] indices = codes.split("-");
//        List<GrauParentesco> listaGrauPar = new ArrayList<>();
//        for (String code : indices) {
//            int num = Integer.parseInt(code);
//            listaGrauPar.add(GrauParentesco.getGrauParentescoCode(num));
//        }
//        return listaGrauPar;
//    }
//
//    public List<BeneficiosCadastrados> converterCodeBenefParaList(String codes) {
//        String[] indices = codes.split("-");
//        List<BeneficiosCadastrados> listaBeneficiosCad = new ArrayList<>();
//        if (!codes.isEmpty()) {
//            for (String code : indices) {
//                int num = Integer.parseInt(code);
//                listaBeneficiosCad.add(BeneficiosCadastrados.getBeneficiosCadastradosCode(num));
//            }
//        }
//
//        return listaBeneficiosCad;
//    }
//
//    public List<ProgramasSociaisCadastrados> converterCodeProgSocialParaList(String codes) {
//        String[] indices = codes.split("-");
//        List<ProgramasSociaisCadastrados> listaProgramasSociaisCad = new ArrayList<>();
//        if (!codes.isEmpty()) {
//            for (String code : indices) {
//                int num = Integer.parseInt(code);
//                listaProgramasSociaisCad.add(ProgramasSociaisCadastrados.getProgramasSociaisCadCode(num));
//            }
//        }
//
//        return listaProgramasSociaisCad;
//    }
//
//    public List<DoencasCronicasCadastradas> converterCodeDoencaCronicaParaList(String codes) {
//        String[] indices = codes.split("-");
//        List<DoencasCronicasCadastradas> listaDoencaCronicasCad = new ArrayList<>();
//        if (!codes.isEmpty()) {
//            for (String code : indices) {
//                int num = Integer.parseInt(code);
//                listaDoencaCronicasCad.add(DoencasCronicasCadastradas.getDoencaCronicaCode(num));
//            }
//        }
//
//        return listaDoencaCronicasCad;
//    }
//
//    public List<ViolenciasCadastradas> converterCodeViolenciasCadParaList(String codes) {
//        String[] indices = codes.split("-");
//        List<ViolenciasCadastradas> listaViolenciasCad = new ArrayList<>();
//        if (!codes.isEmpty()) {
//            for (String code : indices) {
//                int num = Integer.parseInt(code);
//                listaViolenciasCad.add(ViolenciasCadastradas.getViolenciaCode(num));
//            }
//        }
//
//        return listaViolenciasCad;
//    }
//
//    public List<PsicoativosCadastrados> converterCodePsicoativosCadParaList(String codes) {
//        String[] indices = codes.split("-");
//        List<PsicoativosCadastrados> listaPsicoativosCad = new ArrayList<>();
//        if (!codes.isEmpty()) {
//            for (String code : indices) {
//                int num = Integer.parseInt(code);
//                listaPsicoativosCad.add(PsicoativosCadastrados.getPsicoativosCode(num));
//            }
//        }
//
//        return listaPsicoativosCad;
//    }
//
//    public List<AtividadeLazerCadastradas> converterCodeAtivLazerCadParaList(String codes) {
//        String[] indices = codes.split("-");
//        List<AtividadeLazerCadastradas> listaAtivLazerCad = new ArrayList<>();
//        if (!codes.isEmpty()) {
//            for (String code : indices) {
//                int num = Integer.parseInt(code);
//                listaAtivLazerCad.add(AtividadeLazerCadastradas.getAtividadeLazerCadastradasCode(num));
//            }
//        }
//
//        return listaAtivLazerCad;
//    }

}