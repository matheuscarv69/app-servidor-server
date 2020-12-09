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
                                               @Autowired ProgramaSocialRepository programaSocialRepository) {
        return args -> {
            EstadoCivil solteiro = new EstadoCivil();
            solteiro.setId(1);
            solteiro.setEstado("Solteiro (a)");

            EstadoCivil casado = new EstadoCivil();
            casado.setId(2);
            casado.setEstado("Casado (a)");

            EstadoCivil uniaoEstavel = new EstadoCivil();
            uniaoEstavel.setId(3);
            uniaoEstavel.setEstado("União Estável");

            EstadoCivil separado = new EstadoCivil();
            separado.setId(4);
            separado.setEstado("Separado (a)");

            EstadoCivil divorciado = new EstadoCivil();
            divorciado.setId(5);
            divorciado.setEstado("Divorciado (a)");

            EstadoCivil viuvo = new EstadoCivil();
            viuvo.setId(6);
            viuvo.setEstado("Viúvo (a)");

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

            Beneficio nenhumBeneficio =  new Beneficio();
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

            ProgramaSocial prefeitura_outros =  new ProgramaSocial();
            prefeitura_outros.setId(5);
            prefeitura_outros.setProgramaSocial("Programa da Prefeitura ou Outros");

            ///
            estadoCivilRepository.saveAll(Arrays.asList(solteiro,casado,uniaoEstavel,separado,divorciado,viuvo));
            escolaridadeRepository.saveAll(Arrays.asList(analfabeto,ensinoFundamentalInc,ensinoFundamentalComp,ensinoMedioInc,ensinoMedioComp,ensinoSuperiorInc,ensinoSuperiorComp));
            residenciaRepository.saveAll(Arrays.asList(propria,alugada,areaInvasao,cedida));
            grauParentescoRepository.saveAll(Arrays.asList(esposo,filhos,sogro,irmao,pai,mae,tio,sobrinho,avos,enteado,primo,outrosGraus));
            beneficioRepository.saveAll(Arrays.asList(nenhumBeneficio,prestacaoCont,bolsaFamilia,creditoSocial,outrosBeneficio));
            programaSocialRepository.saveAll(Arrays.asList(naoPrograma,jovemAprendiz,crea_cras,caps_ad, prefeitura_outros));
            
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AppServidorApplication.class, args);
    }


}
