package io.github.matheuscarv69.config;

import io.github.matheuscarv69.domain.entity.fields.*;
import io.github.matheuscarv69.domain.repository.fieldsRepositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    StateCivilRepository stateCivilRepository;
    @Autowired
    SchoolingRepository schoolingRepository;
    @Autowired
    ResidenceRepository residenceRepository;
    @Autowired
    KinshipRepository kinshipRepository;
    @Autowired
    QualityLifeRepository qualityLifeRepository;

    @Override
    public void run(String... args) throws Exception {

        StateCivil solteiro = new StateCivil();
        solteiro.setId(1);
        solteiro.setStateCivil("Solteiro (a)");

        StateCivil casado = new StateCivil();
        casado.setId(2);
        casado.setStateCivil("Casado (a)");

        StateCivil uniaoEstavel = new StateCivil();
        uniaoEstavel.setId(3);
        uniaoEstavel.setStateCivil("União Estável");

        StateCivil separado = new StateCivil();
        separado.setId(4);
        separado.setStateCivil("Separado (a)");

        StateCivil divorciado = new StateCivil();
        divorciado.setId(5);
        divorciado.setStateCivil("Divorciado (a)");

        StateCivil viuvo = new StateCivil();
        viuvo.setId(6);
        viuvo.setStateCivil("Viúvo (a)");

        ///

        Schooling analfabeto = new Schooling();
        analfabeto.setId(1);
        analfabeto.setSchooling("Analfabeto");

        Schooling ensinoFundamentalInc = new Schooling();
        ensinoFundamentalInc.setId(2);
        ensinoFundamentalInc.setSchooling("Ensino Fundamental Incompleto");

        Schooling ensinoFundamentalComp = new Schooling();
        ensinoFundamentalComp.setId(3);
        ensinoFundamentalComp.setSchooling("Ensino Fundamental Completo");

        Schooling ensinoMedioInc = new Schooling();
        ensinoMedioInc.setId(4);
        ensinoMedioInc.setSchooling("Ensino Médio Incompleto");

        Schooling ensinoMedioComp = new Schooling();
        ensinoMedioComp.setId(5);
        ensinoMedioComp.setSchooling("Ensino Médio Completo");

        Schooling ensinoSuperiorInc = new Schooling();
        ensinoSuperiorInc.setId(6);
        ensinoSuperiorInc.setSchooling("Ensino Superior Incompleto");

        Schooling ensinoSuperiorComp = new Schooling();
        ensinoSuperiorComp.setId(7);
        ensinoSuperiorComp.setSchooling("Ensino Superior Completo");

        ///

        Residence propria = new Residence();
        propria.setId(1);
        propria.setResidence("Própria");

        Residence alugada = new Residence();
        alugada.setId(2);
        alugada.setResidence("Alugada");

        Residence areaInvasao = new Residence();
        areaInvasao.setId(3);
        areaInvasao.setResidence("Área de Invasão");

        Residence cedida = new Residence();
        cedida.setId(4);
        cedida.setResidence("Cedida");

        ///

        Kinship esposo = new Kinship();
        esposo.setId(1);
        esposo.setKinship("Esposo (a)");

        Kinship filhos = new Kinship();
        filhos.setId(2);
        filhos.setKinship("Filhos (a)");

        Kinship sogro = new Kinship();
        sogro.setId(3);
        sogro.setKinship("Sogro (a)");

        Kinship irmao = new Kinship();
        irmao.setId(4);
        irmao.setKinship("Irmão (ã)");

        Kinship pai = new Kinship();
        pai.setId(5);
        pai.setKinship("Pai");

        Kinship mae = new Kinship();
        mae.setId(6);
        mae.setKinship("Mãe");

        Kinship tio = new Kinship();
        tio.setId(7);
        tio.setKinship("Tio (a)");

        Kinship sobrinho = new Kinship();
        sobrinho.setId(8);
        sobrinho.setKinship("Sobrinho (a)");

        Kinship avos = new Kinship();
        avos.setId(9);
        avos.setKinship("Avós");

        Kinship enteado = new Kinship();
        enteado.setId(10);
        enteado.setKinship("Enteado (a)");

        Kinship primo = new Kinship();
        primo.setId(11);
        primo.setKinship("Primo (a)");

        Kinship outrosGraus = new Kinship();
        outrosGraus.setId(12);
        outrosGraus.setKinship("Outros");

        ///

        QualityLife excelenteQualidade = new QualityLife();
        excelenteQualidade.setId(4);
        excelenteQualidade.setQualityLife("Excelente");

        QualityLife boaQualidade = new QualityLife();
        boaQualidade.setId(3);
        boaQualidade.setQualityLife("Boa");

        QualityLife regularQualidade = new QualityLife();
        regularQualidade.setId(2);
        regularQualidade.setQualityLife("Regular");

        QualityLife ruimQualidade = new QualityLife();
        ruimQualidade.setId(1);
        ruimQualidade.setQualityLife("Ruim");

        ///

        stateCivilRepository.saveAll(Arrays.asList(solteiro, casado, uniaoEstavel, separado, divorciado, viuvo));
        schoolingRepository.saveAll(Arrays.asList(analfabeto, ensinoFundamentalInc, ensinoFundamentalComp, ensinoMedioInc, ensinoMedioComp, ensinoSuperiorInc, ensinoSuperiorComp));
        residenceRepository.saveAll(Arrays.asList(propria, alugada, areaInvasao, cedida));
        kinshipRepository.saveAll(Arrays.asList(esposo, filhos, sogro, irmao, pai, mae, tio, sobrinho, avos, enteado, primo, outrosGraus));
        qualityLifeRepository.saveAll(Arrays.asList(excelenteQualidade, boaQualidade, regularQualidade, ruimQualidade));

    }

}
