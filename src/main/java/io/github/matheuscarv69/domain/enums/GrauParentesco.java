package io.github.matheuscarv69.domain.enums;

import io.github.matheuscarv69.exceptions.RegraNegocioException;

public enum GrauParentesco {
    ESPOSO_A,
    FILHOS_AS,
    SOGRO_A,
    IRMAO_A,
    PAI,
    MAE,
    TIO_A,
    SOBRINHO_A,
    AVOS,
    ENTEADO_A,
    PRIMO_A,
    OUTROS;

    public static GrauParentesco getGrauParentescoCode(int opcao) {
        if (opcao == 1) {
            return ESPOSO_A;
        } else if (opcao == 2) {
            return FILHOS_AS;
        } else if (opcao == 3) {
            return SOGRO_A;
        } else if (opcao == 4) {
            return IRMAO_A;
        } else if (opcao == 5) {
            return PAI;
        } else if (opcao == 6) {
            return MAE;
        } else if (opcao == 7) {
            return TIO_A;
        } else if (opcao == 8) {
            return SOBRINHO_A;
        } else if (opcao == 9) {
            return AVOS;
        } else if (opcao == 10) {
            return ENTEADO_A;
        } else if (opcao == 11) {
            return PRIMO_A;
        } else if (opcao == 12) {
            return OUTROS;
        } else {
            throw new RegraNegocioException("Campo Grau Parentesco é inválido");
        }
    }

}
