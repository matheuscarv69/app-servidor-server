package io.github.matheuscarv69;

import io.github.matheuscarv69.domain.entity.othersEntity.Escolaridade;
import io.github.matheuscarv69.domain.entity.othersEntity.EstadoCivil;
import io.github.matheuscarv69.domain.entity.othersEntity.GrauParentesco;
import io.github.matheuscarv69.domain.entity.othersEntity.Residencia;
import io.github.matheuscarv69.domain.repository.EscolaridadeRepository;
import io.github.matheuscarv69.domain.repository.EstadoCivilRepository;
import io.github.matheuscarv69.domain.repository.GrauParentescoRepository;
import io.github.matheuscarv69.domain.repository.ResidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppServidorApplication extends SpringBootServletInitializer {

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired EstadoCivilRepository estadoCivilRepository,
                                               @Autowired EscolaridadeRepository escolaridadeRepository,
                                               @Autowired ResidenciaRepository residenciaRepository,
                                               @Autowired GrauParentescoRepository grauParentescoRepository) {
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

            GrauParentesco outros = new GrauParentesco();
            outros.setId(12);
            outros.setGrauParentesco("Outros");

            ///

            estadoCivilRepository.save(solteiro);
            estadoCivilRepository.save(casado);
            estadoCivilRepository.save(uniaoEstavel);
            estadoCivilRepository.save(separado);
            estadoCivilRepository.save(divorciado);
            estadoCivilRepository.save(viuvo);
            //
            escolaridadeRepository.save(analfabeto);
            escolaridadeRepository.save(ensinoFundamentalInc);
            escolaridadeRepository.save(ensinoFundamentalComp);
            escolaridadeRepository.save(ensinoMedioInc);
            escolaridadeRepository.save(ensinoMedioComp);
            escolaridadeRepository.save(ensinoSuperiorInc);
            escolaridadeRepository.save(ensinoSuperiorComp);
            //
            residenciaRepository.save(propria);
            residenciaRepository.save(alugada);
            residenciaRepository.save(areaInvasao);
            residenciaRepository.save(cedida);
            //
            grauParentescoRepository.save(esposo);
            grauParentescoRepository.save(filhos);
            grauParentescoRepository.save(sogro);
            grauParentescoRepository.save(irmao);
            grauParentescoRepository.save(pai);
            grauParentescoRepository.save(mae);
            grauParentescoRepository.save(tio);
            grauParentescoRepository.save(sobrinho);
            grauParentescoRepository.save(avos);
            grauParentescoRepository.save(enteado);
            grauParentescoRepository.save(primo);
            grauParentescoRepository.save(outros);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AppServidorApplication.class, args);
    }


}
