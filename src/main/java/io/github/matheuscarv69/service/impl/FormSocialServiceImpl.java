package io.github.matheuscarv69.service.impl;

import io.github.matheuscarv69.domain.entity.FormSocial;
import io.github.matheuscarv69.domain.entity.othersEntity.*;
import io.github.matheuscarv69.domain.repository.FormSocialRepository;
import io.github.matheuscarv69.domain.repository.othersEntityRepository.*;
import io.github.matheuscarv69.exceptions.*;
import io.github.matheuscarv69.rest.dto.FormSocialDTO;
import io.github.matheuscarv69.rest.dto.InfoFormSocialDTO;
import io.github.matheuscarv69.rest.dto.othersEntity.*;
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
    private final DoencaCronicaRepository doencaCronicaRepository;
    private final DeficienteFamiliaRepository deficienteFamiliaRepository;
    private final AcompMedicoRepository acompMedicoRepository;
    private final SuicidioFamiliaRepository suicidioFamiliaRepository;
    private final ViolenciaRepository violenciaRepository;
    private final PsicoativoRepository psicoativoRepository;
    private final ConflitoFamiliarRepository conflitoFamiliarRepository;
    private final AtividadeLazerRepository atividadeLazerRepository;
    private final AtividadeFisicaRepository atividadeFisicaRepository;
    private final QualidadeVidaRepository qualidadeVidaRepository;
    private final VacinaRepository vacinaRepository;

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

        // estadoCivil
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

        // programas sociais
        List<ProgramaSocial> listProgramas = convertIndexProgramaSocial(dto);

        // doenca cronicas
        List<DoencaCronica> listDoenca = convertIndexDoencaCronica(dto);

        // deficiente na familia
        formSocial.setDeficienteFamilia(persistDeficienteFamilia(dto));

        // acompanhamento medico
        formSocial.setAcompMedico(persistAcompMedico(dto));

        // suicidio familia
        formSocial.setSuicidioFamilia(persistSuicidioFam(dto));

        // violencias
        List<Violencia> listViolencia = convertIndexViolencia(dto);

        // psicoativos
        List<Psicoativo> listPsicoativo = convertIndexPsicoativo(dto);

        // conflito familiar
        formSocial.setConflitoFamiliar(persistConflitoFamiliar(dto));

        // atividades lazer
        List<AtividadeLazer> listAtividadeLazer = convertIndexAtividadeLazer(dto);

        // atividade fisica
        formSocial.setAtividadeFisica(persistAtividadeFisica(dto));

        // qualidade de vida
        formSocial.setQualidadeVida(persistQualidadeVida(dto));

        // vacina
        formSocial.setVacina(persistVacina(dto));

        repository.save(formSocial);

        // salva os ids nas tabelas associativas
        formSocial.getGrauParentescos().addAll(listParentescos);
        formSocial.getBeneficios().addAll(listBeneficios);
        formSocial.getProgramasSociais().addAll(listProgramas);
        formSocial.getDoencaCronicas().addAll(listDoenca);
        formSocial.getViolencias().addAll(listViolencia);
        formSocial.getPsicoativos().addAll(listPsicoativo);
        formSocial.getAtividadesLazer().addAll(listAtividadeLazer);
        repository.save(formSocial);

        return formSocial;
    }

    @Override
    public List<InfoFormSocialDTO> buscarForms() {
        List<FormSocial> listForms = repository.findAll();

        List<InfoFormSocialDTO> listInfoForm = new ArrayList<>();

        for (FormSocial form : listForms) {
            listInfoForm.add(convertFormSocialInfo(form));
        }

        return listInfoForm;
    }


    public EstadoCivil persistEstadoCivil(FormSocialDTO dto) {
        EstadoCivil estadoCivil = new EstadoCivil();

        if (dto.getEstadoCivil() < 1 || dto.getEstadoCivil() > 6) {
            throw new EstadoCivilException("ID do Estado Civil é inválido. (1-6)");
        }

        Optional<EstadoCivil> estadoBD = estadoCivilRepository.findById(dto.getEstadoCivil());

        if (estadoBD.isPresent()) {
            estadoCivil.setId(estadoBD.get().getId());
            estadoCivil.setEstadoCivil(estadoBD.get().getEstadoCivil());
        }

        return estadoCivil;
    }

    public Escolaridade persistEscolaridade(FormSocialDTO dto) {
        Escolaridade escolaridade = new Escolaridade();

        if (dto.getEscolaridade() < 1 || dto.getEscolaridade() > 7) {
            throw new EscolaridadeException("ID da Escolaridade é inválido. (1-7)");
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
            throw new ResidenciaException("ID da Residência é inválido. (1-4)");
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

    public List<DoencaCronica> convertIndexDoencaCronica(FormSocialDTO dto) {
        List<DoencaCronica> listDoenca = new ArrayList<>();

        for (Integer index : dto.getDoencaCronica()) {
            DoencaCronica doencaCronica = new DoencaCronica();

            if (index < 1 || index > 6) {
                throw new DoencaCronicaException("Algum dos ID's das Doenças Crônicas é inválido. (1-6)");
            } else if (index == 1 && dto.getDoencaCronica().size() > 1) {
                throw new DoencaCronicaException("O ID 1 (Nenhuma) está selecionado, por isso não é possível adicionar as outras Doenças Crônicas disponíveis (1-6)");
            } else if (index == 6 && dto.getOutraDoencaCronica().isEmpty()) {
                throw new DoencaCronicaException("O ID 6 (Outras) está selecionado e o campo Outra Doença Crônica está vazio, preencha-o ");
            } else if (!dto.getDoencaCronica().contains(6) && !dto.getOutraDoencaCronica().isEmpty()) {
                throw new DoencaCronicaException("O ID 6 (Outras) não está selecionado, selecione-o para poder preencher o campo Outra Doença Crônica");
            }

            Optional<DoencaCronica> doencaCronicaBD = doencaCronicaRepository.findById(index);

            if (doencaCronicaBD.isPresent() && doencaCronicaBD.get().getId() != 6) {
                doencaCronica.setId(doencaCronicaBD.get().getId());
                doencaCronica.setDoencaCronica(doencaCronicaBD.get().getDoencaCronica());

                listDoenca.add(doencaCronica);
            }

            if (doencaCronicaBD.get().getId() == 6) {
                doencaCronica.setDoencaCronica(dto.getOutraDoencaCronica());
                doencaCronicaRepository.save(doencaCronica);
                listDoenca.add(doencaCronica);
            }
        }
        return listDoenca;
    }

    public DeficienteFamilia persistDeficienteFamilia(FormSocialDTO dto) {
        DeficienteFamilia deficienteFamilia = new DeficienteFamilia();

        if (dto.getDeficienteFamilia() < 1 || dto.getDeficienteFamilia() > 2) {
            throw new DeficienteFamiliaException("ID do Deficiente da Familia é inválido. (1-2)");
        } else if (dto.getDeficienteFamilia() == 2 && dto.getPessoaDeficiente().isEmpty() && dto.getDeficiencia().isEmpty()) {
            throw new DeficienteFamiliaException("O ID 2 (Sim) está selecionado, mas os campos Pessoa Deficiente e Deficiência estão vazios, preencha-os");
        } else if (dto.getDeficienteFamilia() != 2 && !dto.getPessoaDeficiente().isEmpty() && !dto.getDeficiencia().isEmpty()) {
            throw new DeficienteFamiliaException("O ID 2 (Sim) não está selecionado, selecione-o para poder preencher os campos Pessoa Deficiente e Deficiência");
        }

        Optional<DeficienteFamilia> deficienteBD = deficienteFamiliaRepository.findById(dto.getDeficienteFamilia());

        if (deficienteBD.get().getId() == 1) {
            deficienteFamilia.setId(deficienteBD.get().getId());
            deficienteFamilia.setPessoa(deficienteBD.get().getPessoa());
            deficienteFamilia.setDeficiencia(deficienteBD.get().getDeficiencia());
        } else if (deficienteBD.get().getId() == 2) {
            deficienteFamilia.setPessoa(dto.getPessoaDeficiente());
            deficienteFamilia.setDeficiencia(dto.getDeficiencia());
        }

        deficienteFamiliaRepository.save(deficienteFamilia);
        return deficienteFamilia;
    }

    public AcompMedico persistAcompMedico(FormSocialDTO dto) {
        AcompMedico acompMedico = new AcompMedico();

        if (dto.getAcompMedico() < 1 || dto.getAcompMedico() > 2) {
            throw new AcompMedicoException("ID do Acompanhamento Médico é inválido. (1-2)");
        } else if (dto.getAcompMedico() == 2 && dto.getEspecialidadeAcompMedico().isEmpty()) {
            throw new AcompMedicoException("O ID 2 (Sim) está selecionado, mas o campo Especialidade Acompanhamento Médico esta vazio, preencha-o");
        } else if (dto.getAcompMedico() != 2 && !dto.getEspecialidadeAcompMedico().isEmpty()) {
            throw new AcompMedicoException("O ID 2 (Sim) não está selecionado, selecione-o para poder preencher o campo Especialidade Acompanhamento Médico");
        }

        Optional<AcompMedico> acompanhamentoBD = acompMedicoRepository.findById(dto.getAcompMedico());

        if (acompanhamentoBD.get().getId() == 1) {
            acompMedico.setId(acompanhamentoBD.get().getId());
            acompMedico.setEspecialidadeMedica(acompanhamentoBD.get().getEspecialidadeMedica());
        } else if (acompanhamentoBD.get().getId() == 2) {
            acompMedico.setEspecialidadeMedica(dto.getEspecialidadeAcompMedico());
        }
        acompMedicoRepository.save(acompMedico);
        return acompMedico;

    }

    public SuicidioFamilia persistSuicidioFam(FormSocialDTO dto) {
        SuicidioFamilia suicidioFamilia = new SuicidioFamilia();
        GrauParentesco grauParentesco = new GrauParentesco();

        if (dto.getSuicidioFamilia() < 1 || dto.getSuicidioFamilia() > 2) {
            throw new SuicidioFamiliaException("ID do Suicidio Familia é inválido. (1-2)");
        }

        if (dto.getSuicidioFamilia() == 2 && !dto.getGrauParentescoSuicidio().isPresent()) {
            throw new SuicidioFamiliaException("O ID 2 (Sim) está selecionado, mas o campo Grau Parentesco Suicidio está vazio, preencha-o");
        } else if (dto.getSuicidioFamilia() != 2 && dto.getGrauParentescoSuicidio().isPresent()) {
            throw new SuicidioFamiliaException("O ID 2 (Sim) não está selecionado, selecione-o para poder preencher o campo Grau Parentesco Suicídio");
        }
        // verifica se o grau parentesco suicidio não é vazio e se é válido
        if (dto.getGrauParentescoSuicidio().isPresent()) {
            if (dto.getGrauParentescoSuicidio().get() < 1 || dto.getGrauParentescoSuicidio().get() > 12) {
                throw new GrauParentescoException("ID do Grau Parentesco Suicídio é inválido. (1-12)");
            }

            Optional<GrauParentesco> grauParentescoBD = grauParentescoRepository.findById(dto.getGrauParentescoSuicidio().get());
            grauParentesco.setId(grauParentescoBD.get().getId());
            grauParentesco.setGrauParentesco(grauParentescoBD.get().getGrauParentesco());
        }

        Optional<SuicidioFamilia> suicidioBD = suicidioFamiliaRepository.findById(dto.getSuicidioFamilia());

        if (suicidioBD.get().getId() == 1) {
            suicidioFamilia.setId(suicidioBD.get().getId());
            suicidioFamilia.setSuicidio(suicidioBD.get().getSuicidio());
        } else if (suicidioBD.get().getId() == 2) {
            suicidioFamilia.setSuicidio(suicidioBD.get().getSuicidio());
            suicidioFamilia.setGrauParentescoSuicidio(grauParentesco);
        }

        suicidioFamiliaRepository.save(suicidioFamilia);

        return suicidioFamilia;

    }

    public List<Violencia> convertIndexViolencia(FormSocialDTO dto) {
        List<Violencia> listViolencia = new ArrayList<>();

        for (Integer index : dto.getViolencia()) {
            Violencia violencia = new Violencia();

            if (index < 1 || index > 7) {
                throw new ViolenciaException("Algum dos ID's das Violências é inválido. (1-7)");
            } else if (index == 1 && dto.getViolencia().size() > 1) {
                throw new ViolenciaException("O ID 1 (Nenhuma) está selecionado, por isso não é possível adicionar as outras Violências disponíveis (1-7)");
            } else if (index == 7 && dto.getOutraViolencia().isEmpty()) {
                throw new ViolenciaException("O ID 7 (Outras) está selecionado e o campo Outra Violência está vazio, preencha-o ");
            } else if (!dto.getViolencia().contains(7) && !dto.getOutraViolencia().isEmpty()) {
                throw new ViolenciaException("O ID 7 (Outras) não está selecionado, selecione-o para poder preencher o campo Outra Violência");
            }

            Optional<Violencia> violenciaBD = violenciaRepository.findById(index);

            if (violenciaBD.isPresent() && violenciaBD.get().getId() != 7) {
                violencia.setId(violenciaBD.get().getId());
                violencia.setViolencia(violenciaBD.get().getViolencia());

                listViolencia.add(violencia);
            }

            if (violenciaBD.get().getId() == 7) {
                violencia.setViolencia(dto.getOutraViolencia());
                violenciaRepository.save(violencia);
                listViolencia.add(violencia);
            }
        }

        return listViolencia;
    }

    public List<Psicoativo> convertIndexPsicoativo(FormSocialDTO dto) {
        List<Psicoativo> listPsicoativo = new ArrayList<>();

        for (Integer index : dto.getPsicoativo()) {
            Psicoativo psicoativo = new Psicoativo();

            if (index < 1 || index > 5) {
                throw new PsicoativoException("Algum dos ID's dos Psicoativos é inválido. (1-5)");
            } else if (index == 1 && dto.getPsicoativo().size() > 1) {
                throw new PsicoativoException("O ID 1 (Nenhum) está selecionado, por isso não é possível adicionar os outros Psicoativos disponíveis (1-5)");
            } else if (index == 5 && dto.getOutroPsicoativo().isEmpty()) {
                throw new PsicoativoException("O ID 5 (Outro) está selecionado e o campo Outro Psicoativo está vazio, preencha-o ");
            } else if (!dto.getPsicoativo().contains(5) && !dto.getOutroPsicoativo().isEmpty()) {
                throw new PsicoativoException("O ID 5 (Outro) não está selecionado, selecione-o para poder preencher o campo Outro Psicoativo");
            }

            Optional<Psicoativo> psicoativoBD = psicoativoRepository.findById(index);

            if (psicoativoBD.isPresent() && psicoativoBD.get().getId() != 5) {
                psicoativo.setId(psicoativoBD.get().getId());
                psicoativo.setPsicoativo(psicoativoBD.get().getPsicoativo());

                listPsicoativo.add(psicoativo);
            }

            if (psicoativoBD.get().getId() == 5) {
                psicoativo.setPsicoativo(dto.getOutroPsicoativo());
                psicoativoRepository.save(psicoativo);
                listPsicoativo.add(psicoativo);
            }
        }

        return listPsicoativo;
    }

    public ConflitoFamiliar persistConflitoFamiliar(FormSocialDTO dto) {
        ConflitoFamiliar conflitoFamiliar = new ConflitoFamiliar();

        if (dto.getConflitoFamiliar() < 1 || dto.getConflitoFamiliar() > 2) {
            throw new ConflitoFamiliarException("ID do Conflito Familiar é inválido. (1-2)");
        }

        Optional<ConflitoFamiliar> conflitoBD = conflitoFamiliarRepository.findById(dto.getConflitoFamiliar());

        if (conflitoBD.isPresent()) {
            conflitoFamiliar.setId(conflitoBD.get().getId());
            conflitoFamiliar.setConflito(conflitoBD.get().getConflito());
        }

        return conflitoFamiliar;
    }

    public List<AtividadeLazer> convertIndexAtividadeLazer(FormSocialDTO dto) {
        List<AtividadeLazer> listAtividadeLazer = new ArrayList<>();

        for (Integer index : dto.getAtividadeLazer()) {
            AtividadeLazer atividadeLazer = new AtividadeLazer();

            if (index < 1 || index > 6) {
                throw new AtividadeLazerException("Algum dos ID's das Atividades Lazer é inválido. (1-6)");
            } else if (index == 1 && dto.getAtividadeLazer().size() > 1) {
                throw new AtividadeLazerException("O ID 1 (Nenhum) está selecionado, por isso não é possível adicionar os outras Atividades Lazer disponíveis (1-6)");
            } else if (index == 6 && dto.getOutraAtividadeLazer().isEmpty()) {
                throw new AtividadeLazerException("O ID 6 (Outra) está selecionado e o campo Outra Atividade Lazer está vazio, preencha-o ");
            } else if (!dto.getAtividadeLazer().contains(6) && !dto.getOutraAtividadeLazer().isEmpty()) {
                throw new AtividadeLazerException("O ID 6 (Outra) não está selecionado, selecione-o para poder preencher o campo Outra Atividade Lazer");
            }

            Optional<AtividadeLazer> atividadeLazerBD = atividadeLazerRepository.findById(index);

            if (atividadeLazerBD.isPresent() && atividadeLazerBD.get().getId() != 6) {
                atividadeLazer.setId(atividadeLazerBD.get().getId());
                atividadeLazer.setAtividadeLazer(atividadeLazerBD.get().getAtividadeLazer());

                listAtividadeLazer.add(atividadeLazer);
            }

            if (atividadeLazerBD.get().getId() == 6) {
                atividadeLazer.setAtividadeLazer(dto.getOutraAtividadeLazer());
                atividadeLazerRepository.save(atividadeLazer);
                listAtividadeLazer.add(atividadeLazer);
            }
        }

        return listAtividadeLazer;
    }

    public AtividadeFisica persistAtividadeFisica(FormSocialDTO dto) {
        AtividadeFisica atividadeFisica = new AtividadeFisica();

        if (dto.getAtividadeFisica() < 1 || dto.getAtividadeFisica() > 2) {
            throw new AtividadeFisicaException("ID do Atividade Física é inválido. (1-2)");
        } else if (dto.getAtividadeFisica() == 2 && dto.getAtividadeFisicaDescricao().isEmpty()) {
            throw new AtividadeFisicaException("O ID 2 (Sim) está selecionado, mas o campo Atividade Física Descrição esta vazio, preencha-o");
        } else if (dto.getAtividadeFisica() != 2 && !dto.getAtividadeFisicaDescricao().isEmpty()) {
            throw new AtividadeFisicaException("O ID 2 (Sim) não está selecionado, selecione-o para poder preencher o campo Atividade Física Descrição");
        }

        Optional<AtividadeFisica> atividadeFisicaBD = atividadeFisicaRepository.findById(dto.getAtividadeFisica());

        if (atividadeFisicaBD.get().getId() == 1) {
            atividadeFisica.setId(atividadeFisicaBD.get().getId());
            atividadeFisica.setAtividadeFisica(atividadeFisicaBD.get().getAtividadeFisica());
        } else if (atividadeFisicaBD.get().getId() == 2) {
            atividadeFisica.setAtividadeFisica(dto.getAtividadeFisicaDescricao());
        }
        atividadeFisicaRepository.save(atividadeFisica);
        return atividadeFisica;
    }

    public QualidadeVida persistQualidadeVida(FormSocialDTO dto) {
        QualidadeVida qualidadeVida = new QualidadeVida();

        if (dto.getQualidadeVida() < 1 || dto.getQualidadeVida() > 4) {
            throw new QualidadeVidaException("ID da Qualidade de Vida é inválido. (1-4)");
        }

        Optional<QualidadeVida> qualidadeBD = qualidadeVidaRepository.findById(dto.getQualidadeVida());

        if (qualidadeBD.isPresent()) {
            qualidadeVida.setId(qualidadeBD.get().getId());
            qualidadeVida.setQualidadeVida(qualidadeBD.get().getQualidadeVida());
        }

        return qualidadeVida;
    }

    public Vacina persistVacina(FormSocialDTO dto) {
        Vacina vacina = new Vacina();

        if (dto.getVacina() < 1 || dto.getVacina() > 3) {
            throw new QualidadeVidaException("ID da Vacina é inválido. (1-3)");
        }

        Optional<Vacina> vacinaBD = vacinaRepository.findById(dto.getVacina());

        if (vacinaBD.isPresent()) {
            vacina.setId(vacinaBD.get().getId());
            vacina.setVacina(vacinaBD.get().getVacina());
        }

        return vacina;
    }

    public InfoFormSocialDTO convertFormSocialInfo(FormSocial form) {

        List<GrauParentescoDTO> listGrauParentesco = new ArrayList<>();
        for (GrauParentesco grau : form.getGrauParentescos()) {
            GrauParentescoDTO grauParentescoDTO = new GrauParentescoDTO();
            grauParentescoDTO.setGrauParentesco(grau.getGrauParentesco());
            listGrauParentesco.add(grauParentescoDTO);
        }

        List<BeneficioDTO> listBeneficios = new ArrayList<>();
        for (Beneficio beneficio : form.getBeneficios()) {
            BeneficioDTO beneficioDTO = new BeneficioDTO();
            beneficioDTO.setBeneficio(beneficio.getBeneficio());
            listBeneficios.add(beneficioDTO);
        }

        List<ProgramaSocialDTO> listProgramas = new ArrayList<>();
        for (ProgramaSocial programa : form.getProgramasSociais()) {
            ProgramaSocialDTO programaSocialDTO = new ProgramaSocialDTO();
            programaSocialDTO.setProgramaSocial(programa.getProgramaSocial());
            listProgramas.add(programaSocialDTO);
        }

        List<DoencaCronicaDTO> listDoencas = new ArrayList<>();
        for (DoencaCronica doenca : form.getDoencaCronicas()) {
            DoencaCronicaDTO doencaDTO = new DoencaCronicaDTO();
            doencaDTO.setDoencaCronica(doenca.getDoencaCronica());
            listDoencas.add(doencaDTO);
        }

        DeficienteFamiliaDTO deficienteFamiliaDTO = new DeficienteFamiliaDTO();
        deficienteFamiliaDTO.setPessoa(form.getDeficienteFamilia().getPessoa());
        deficienteFamiliaDTO.setDeficiencia(form.getDeficienteFamilia().getDeficiencia());

        SuicidioFamiliaDTO suicidioFamiliaDTO = new SuicidioFamiliaDTO();
        suicidioFamiliaDTO.setSuicidio(form.getSuicidioFamilia().getSuicidio());
        if (form.getSuicidioFamilia().getGrauParentescoSuicidio() == null) {
            suicidioFamiliaDTO.setGrauParentescoSuicidio("Não há");
        } else {
            suicidioFamiliaDTO.setGrauParentescoSuicidio(form.getSuicidioFamilia()
                    .getGrauParentescoSuicidio().getGrauParentesco());
        }

        List<ViolenciaDTO> listViolencias = new ArrayList<>();
        for (Violencia violencia : form.getViolencias()) {
            ViolenciaDTO violenciaDTO = new ViolenciaDTO();
            violenciaDTO.setViolencia(violencia.getViolencia());
            listViolencias.add(violenciaDTO);
        }

        List<PsicoativoDTO> listPsicoativos = new ArrayList<>();
        for (Psicoativo psicoativo : form.getPsicoativos()) {
            PsicoativoDTO psicoativoDTO = new PsicoativoDTO();
            psicoativoDTO.setPsicoativo(psicoativo.getPsicoativo());
            listPsicoativos.add(psicoativoDTO);
        }

        List<AtividadeLazerDTO> listAtividadeLazer = new ArrayList<>();
        for (AtividadeLazer atividadeLazer : form.getAtividadesLazer()) {
            AtividadeLazerDTO atividadeLazerDTO = new AtividadeLazerDTO();
            atividadeLazerDTO.setAtividadeLazer(atividadeLazer.getAtividadeLazer());
            listAtividadeLazer.add(atividadeLazerDTO);
        }

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
                .estadoCivil(form.getEstadoCivil().getEstadoCivil())
                .escolaridade(form.getEscolaridade().getEscolaridade())
                .numeroPessoasFam(form.getNumeroPessoasFam())
                .grauParentesco(listGrauParentesco)
                .residencia(form.getResidencia().getResidencia())
                .beneficio(listBeneficios)
                .programaSocial(listProgramas)
                .doencaCronica(listDoencas)
                .deficienteFamilia(deficienteFamiliaDTO)
                .acompMedico(form.getAcompMedico().getEspecialidadeMedica())
                .suicidioFamilia(suicidioFamiliaDTO)
                .violencia(listViolencias)
                .psicoativos(listPsicoativos)
                .conflitoFamiliar(form.getConflitoFamiliar().getConflito())
                .atividadesLazer(listAtividadeLazer)
                .atividadeFisica(form.getAtividadeFisica().getAtividadeFisica())
                .qualidadeVida(form.getQualidadeVida().getQualidadeVida())
                .vacinas(form.getVacina().getVacina())
                .build();
    }

}