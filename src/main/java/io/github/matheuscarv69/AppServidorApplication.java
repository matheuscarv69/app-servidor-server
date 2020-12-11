package io.github.matheuscarv69;

import io.github.matheuscarv69.domain.entity.othersEntity.*;
import io.github.matheuscarv69.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class AppServidorApplication extends SpringBootServletInitializer {

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired EstadoCivilRepository estadoCivilRepository,
                                               @Autowired EscolaridadeRepository escolaridadeRepository,
                                               @Autowired ResidenciaRepository residenciaRepository,
                                               @Autowired GrauParentescoRepository grauParentescoRepository,
                                               @Autowired BeneficioRepository beneficioRepository,
                                               @Autowired ProgramaSocialRepository programaSocialRepository,
                                               @Autowired DoencaCronicaRepository doencaCronicaRepository,
                                               @Autowired DeficienteFamiliaRepository deficienteFamiliaRepository,
                                               @Autowired AcompMedicoRepository acompMedicoRepository,
                                               @Autowired SuicidioFamiliaRepository suicidioFamiliaRepository,
                                               @Autowired ViolenciaRepository violenciaRepository,
                                               @Autowired PsicoativoRepository psicoativoRepository,
                                               @Autowired ConflitoFamiliarRepository conflitoFamiliarRepository,
                                               @Autowired AtividadeLazerRepository atividadeLazerRepository,
                                               @Autowired AtividadeFisicaRepository atividadeFisicaRepository,
                                               @Autowired QualidadeVidaRepository qualidadeVidaRepository,
                                               @Autowired VacinaRepository vacinaRepository) {
        return args -> {
            EstadoCivil solteiro = new EstadoCivil();
            solteiro.setId(1);
            solteiro.setEstadoCivil("Solteiro (a)");

            EstadoCivil casado = new EstadoCivil();
            casado.setId(2);
            casado.setEstadoCivil("Casado (a)");

            EstadoCivil uniaoEstavel = new EstadoCivil();
            uniaoEstavel.setId(3);
            uniaoEstavel.setEstadoCivil("União Estável");

            EstadoCivil separado = new EstadoCivil();
            separado.setId(4);
            separado.setEstadoCivil("Separado (a)");

            EstadoCivil divorciado = new EstadoCivil();
            divorciado.setId(5);
            divorciado.setEstadoCivil("Divorciado (a)");

            EstadoCivil viuvo = new EstadoCivil();
            viuvo.setId(6);
            viuvo.setEstadoCivil("Viúvo (a)");

            ///

            Escolaridade analfabeto = new Escolaridade();
            analfabeto.setId(1);
            analfabeto.setEscolaridade("Analfabeto");

            Escolaridade ensinoFundamentalInc = new Escolaridade();
            ensinoFundamentalInc.setId(2);
            ensinoFundamentalInc.setEscolaridade("Ensino Fundamental Incompleto");

            Escolaridade ensinoFundamentalComp = new Escolaridade();
            ensinoFundamentalComp.setId(3);
            ensinoFundamentalComp.setEscolaridade("Ensino Fundamental Completo");

            Escolaridade ensinoMedioInc = new Escolaridade();
            ensinoMedioInc.setId(4);
            ensinoMedioInc.setEscolaridade("Ensino Médio Incompleto");

            Escolaridade ensinoMedioComp = new Escolaridade();
            ensinoMedioComp.setId(5);
            ensinoMedioComp.setEscolaridade("Ensino Médio Completo");

            Escolaridade ensinoSuperiorInc = new Escolaridade();
            ensinoSuperiorInc.setId(6);
            ensinoSuperiorInc.setEscolaridade("Ensino Superior Incompleto");

            Escolaridade ensinoSuperiorComp = new Escolaridade();
            ensinoSuperiorComp.setId(7);
            ensinoSuperiorComp.setEscolaridade("Ensino Superior Completo");

            ///

            Residencia propria = new Residencia();
            propria.setId(1);
            propria.setResidencia("Própria");

            Residencia alugada = new Residencia();
            alugada.setId(2);
            alugada.setResidencia("Alugada");

            Residencia areaInvasao = new Residencia();
            areaInvasao.setId(3);
            areaInvasao.setResidencia("Área de Invasão");

            Residencia cedida = new Residencia();
            cedida.setId(4);
            cedida.setResidencia("Cedida");

            ///

            GrauParentesco esposo = new GrauParentesco();
            esposo.setId(1);
            esposo.setGrauParentesco("Esposo (a)");

            GrauParentesco filhos = new GrauParentesco();
            filhos.setId(2);
            filhos.setGrauParentesco("Filhos (a)");

            GrauParentesco sogro = new GrauParentesco();
            sogro.setId(3);
            sogro.setGrauParentesco("Sogro (a)");

            GrauParentesco irmao = new GrauParentesco();
            irmao.setId(4);
            irmao.setGrauParentesco("Irmão (ã)");

            GrauParentesco pai = new GrauParentesco();
            pai.setId(5);
            pai.setGrauParentesco("Pai");

            GrauParentesco mae = new GrauParentesco();
            mae.setId(6);
            mae.setGrauParentesco("Mãe");

            GrauParentesco tio = new GrauParentesco();
            tio.setId(7);
            tio.setGrauParentesco("Tio (a)");

            GrauParentesco sobrinho = new GrauParentesco();
            sobrinho.setId(8);
            sobrinho.setGrauParentesco("Sobrinho (a)");

            GrauParentesco avos = new GrauParentesco();
            avos.setId(9);
            avos.setGrauParentesco("Avós");

            GrauParentesco enteado = new GrauParentesco();
            enteado.setId(10);
            enteado.setGrauParentesco("Enteado (a)");

            GrauParentesco primo = new GrauParentesco();
            primo.setId(11);
            primo.setGrauParentesco("Primo (a)");

            GrauParentesco outrosGraus = new GrauParentesco();
            outrosGraus.setId(12);
            outrosGraus.setGrauParentesco("Outros");

            ///

            Beneficio nenhumBeneficio = new Beneficio();
            nenhumBeneficio.setId(1);
            nenhumBeneficio.setBeneficio("Nenhum");

            Beneficio prestacaoCont = new Beneficio();
            prestacaoCont.setId(2);
            prestacaoCont.setBeneficio("Prestação Continuada");

            Beneficio bolsaFamilia = new Beneficio();
            bolsaFamilia.setId(3);
            bolsaFamilia.setBeneficio("Bolsa Família");

            Beneficio creditoSocial = new Beneficio();
            creditoSocial.setId(4);
            creditoSocial.setBeneficio("Crédito Social");

            Beneficio outrosBeneficio = new Beneficio();
            outrosBeneficio.setId(5);
            outrosBeneficio.setBeneficio("Outros");

            ///

            ProgramaSocial naoPrograma = new ProgramaSocial();
            naoPrograma.setId(1);
            naoPrograma.setProgramaSocial("Não");

            ProgramaSocial jovemAprendiz = new ProgramaSocial();
            jovemAprendiz.setId(2);
            jovemAprendiz.setProgramaSocial("Jovem Aprendiz");

            ProgramaSocial crea_cras = new ProgramaSocial();
            crea_cras.setId(3);
            crea_cras.setProgramaSocial("CREA-CRAS");

            ProgramaSocial caps_ad = new ProgramaSocial();
            caps_ad.setId(4);
            caps_ad.setProgramaSocial("CAPS I-II-III e AD");

            ProgramaSocial prefeitura_outros = new ProgramaSocial();
            prefeitura_outros.setId(5);
            prefeitura_outros.setProgramaSocial("Programa da Prefeitura ou Outros");

            ///

            DoencaCronica nenhumaDoenca = new DoencaCronica();
            nenhumaDoenca.setId(1);
            nenhumaDoenca.setDoencaCronica("Nenhuma");

            DoencaCronica cancer = new DoencaCronica();
            cancer.setId(2);
            cancer.setDoencaCronica("Câncer");

            DoencaCronica diabetes = new DoencaCronica();
            diabetes.setId(3);
            diabetes.setDoencaCronica("Diabetes");

            DoencaCronica depressao = new DoencaCronica();
            depressao.setId(4);
            depressao.setDoencaCronica("Depressão");

            DoencaCronica hipertensao = new DoencaCronica();
            hipertensao.setId(5);
            hipertensao.setDoencaCronica("Hipertensão");

            DoencaCronica outraDoenca = new DoencaCronica();
            outraDoenca.setId(6);
            outraDoenca.setDoencaCronica("Outras");

            ///

            DeficienteFamilia naoDeficienteFamilia = new DeficienteFamilia();
            naoDeficienteFamilia.setId(1);
            naoDeficienteFamilia.setPessoa("Ninguém");
            naoDeficienteFamilia.setDeficiencia("Nenhuma Deficiência");

            DeficienteFamilia simDeficienteFamilia = new DeficienteFamilia();
            simDeficienteFamilia.setId(2);
            simDeficienteFamilia.setPessoa("Sim");
            simDeficienteFamilia.setDeficiencia("Tem Deficiência");

            ///

            AcompMedico naoAcompMedico = new AcompMedico();
            naoAcompMedico.setId(1);
            naoAcompMedico.setEspecialidadeMedica("Não realiza Acompanhamento Médico");

            AcompMedico simAcompMedico = new AcompMedico();
            simAcompMedico.setId(2);
            simAcompMedico.setEspecialidadeMedica("Sim, realiza Acompanhamento Médico");

            ///

            SuicidioFamilia naoSuicidio = new SuicidioFamilia();
            naoSuicidio.setId(1);
            naoSuicidio.setSuicidio("Não, há casos e nem tentativas de Suicídio");

            SuicidioFamilia simSuicidio = new SuicidioFamilia();
            simSuicidio.setId(2);
            simSuicidio.setSuicidio("Sim, há casos e tentativas de Suicídio");

            ///

            Violencia nenhumaViolencia = new Violencia();
            nenhumaViolencia.setId(1);
            nenhumaViolencia.setViolencia("Nenhuma");

            Violencia fisica = new Violencia();
            fisica.setId(2);
            fisica.setViolencia("Física");

            Violencia verbal = new Violencia();
            verbal.setId(3);
            verbal.setViolencia("Verbal");

            Violencia psicologica = new Violencia();
            psicologica.setId(4);
            psicologica.setViolencia("Psicológica");

            Violencia sexual = new Violencia();
            sexual.setId(5);
            sexual.setViolencia("Sexual");

            Violencia patrimonial = new Violencia();
            patrimonial.setId(6);
            patrimonial.setViolencia("Patrimonial");

            Violencia outraViolencia = new Violencia();
            outraViolencia.setId(7);
            outraViolencia.setViolencia("Outra");

            ///

            Psicoativo nenhumPsicoativo = new Psicoativo();
            nenhumPsicoativo.setId(1);
            nenhumPsicoativo.setPsicoativo("Nenhum");

            Psicoativo alcool = new Psicoativo();
            alcool.setId(2);
            alcool.setPsicoativo("Álcool");

            Psicoativo cigarro = new Psicoativo();
            cigarro.setId(3);
            cigarro.setPsicoativo("Cigarro");

            Psicoativo drogasIlicitas = new Psicoativo();
            drogasIlicitas.setId(4);
            drogasIlicitas.setPsicoativo("Drogas Ilicítas");

            Psicoativo outroPsicoativo = new Psicoativo();
            outroPsicoativo.setId(5);
            outroPsicoativo.setPsicoativo("Outro");

            ///

            ConflitoFamiliar naoConflito = new ConflitoFamiliar();
            naoConflito.setId(1);
            naoConflito.setConflito("Não há Conflito Familiar");

            ConflitoFamiliar simConflito = new ConflitoFamiliar();
            simConflito.setId(2);
            simConflito.setConflito("Sim, há Conflito Familiar");

            ///

            AtividadeLazer nenhumaAtividadeLazer = new AtividadeLazer();
            nenhumaAtividadeLazer.setId(1);
            nenhumaAtividadeLazer.setAtividadeLazer("Nenhuma atividade");

            AtividadeLazer manuais = new AtividadeLazer();
            manuais.setId(2);
            manuais.setAtividadeLazer("Atividades Manuais");

            AtividadeLazer sociais = new AtividadeLazer();
            sociais.setId(3);
            sociais.setAtividadeLazer("Atividades Sociais");

            AtividadeLazer fisicas_esportivas = new AtividadeLazer();
            fisicas_esportivas.setId(4);
            fisicas_esportivas.setAtividadeLazer("Atividades Físicas ou Esportivas");

            AtividadeLazer culturais = new AtividadeLazer();
            culturais.setId(5);
            culturais.setAtividadeLazer("Atividades Culturais");

            AtividadeLazer outrasAtividadesLazer = new AtividadeLazer();
            outrasAtividadesLazer.setId(6);
            outrasAtividadesLazer.setAtividadeLazer("Outras");

            ///

            AtividadeFisica nenhumaAtividadeFisica = new AtividadeFisica();
            nenhumaAtividadeFisica.setId(1);
            nenhumaAtividadeFisica.setAtividadeFisica("Nenhuma atividade");

            AtividadeFisica simAtividadeFisica = new AtividadeFisica();
            simAtividadeFisica.setId(2);
            simAtividadeFisica.setAtividadeFisica("Sim, faz atividade física");

            ///

            QualidadeVida excelenteQualidade = new QualidadeVida();
            excelenteQualidade.setId(1);
            excelenteQualidade.setQualidadeVida("Excelente");

            QualidadeVida boaQualidade = new QualidadeVida();
            boaQualidade.setId(2);
            boaQualidade.setQualidadeVida("Boa");

            QualidadeVida regularQualidade = new QualidadeVida();
            regularQualidade.setId(3);
            regularQualidade.setQualidadeVida("Regular");

            QualidadeVida ruimQualidade = new QualidadeVida();
            ruimQualidade.setId(4);
            ruimQualidade.setQualidadeVida("Ruim");

            ///
//            1 - Não, 2 - Sim, 3 - Não sabe
            Vacina naoVacina = new Vacina();
            naoVacina.setId(1);
            naoVacina.setVacina("Não");

            Vacina simVacina = new Vacina();
            simVacina.setId(2);
            simVacina.setVacina("Sim");

            Vacina naoSabeVacina = new Vacina();
            naoSabeVacina.setId(3);
            naoSabeVacina.setVacina("Não sabe");

            ///
            estadoCivilRepository.saveAll(Arrays.asList(solteiro, casado, uniaoEstavel, separado, divorciado, viuvo));
            escolaridadeRepository.saveAll(Arrays.asList(analfabeto, ensinoFundamentalInc, ensinoFundamentalComp, ensinoMedioInc, ensinoMedioComp, ensinoSuperiorInc, ensinoSuperiorComp));
            residenciaRepository.saveAll(Arrays.asList(propria, alugada, areaInvasao, cedida));
            grauParentescoRepository.saveAll(Arrays.asList(esposo, filhos, sogro, irmao, pai, mae, tio, sobrinho, avos, enteado, primo, outrosGraus));
            beneficioRepository.saveAll(Arrays.asList(nenhumBeneficio, prestacaoCont, bolsaFamilia, creditoSocial, outrosBeneficio));
            programaSocialRepository.saveAll(Arrays.asList(naoPrograma, jovemAprendiz, crea_cras, caps_ad, prefeitura_outros));
            doencaCronicaRepository.saveAll(Arrays.asList(nenhumaDoenca, cancer, diabetes, depressao, hipertensao, outraDoenca));
            deficienteFamiliaRepository.saveAll(Arrays.asList(naoDeficienteFamilia, simDeficienteFamilia));
            acompMedicoRepository.saveAll(Arrays.asList(naoAcompMedico, simAcompMedico));
            suicidioFamiliaRepository.saveAll(Arrays.asList(naoSuicidio, simSuicidio));
            violenciaRepository.saveAll(Arrays.asList(nenhumaViolencia, fisica, verbal, psicologica, sexual, patrimonial, outraViolencia));
            psicoativoRepository.saveAll(Arrays.asList(nenhumPsicoativo, alcool, cigarro, drogasIlicitas, outroPsicoativo));
            conflitoFamiliarRepository.saveAll(Arrays.asList(naoConflito, simConflito));
            atividadeLazerRepository.saveAll(Arrays.asList(nenhumaAtividadeLazer, manuais, sociais, fisicas_esportivas, culturais, outrasAtividadesLazer));
            atividadeFisicaRepository.saveAll(Arrays.asList(nenhumaAtividadeFisica, simAtividadeFisica));
            qualidadeVidaRepository.saveAll(Arrays.asList(excelenteQualidade, boaQualidade, regularQualidade, ruimQualidade));
            vacinaRepository.saveAll(Arrays.asList(naoVacina, simVacina, naoSabeVacina));


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AppServidorApplication.class, args);
    }


}
