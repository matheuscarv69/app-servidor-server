package io.github.matheuscarv69.domain.enums;

import io.github.matheuscarv69.exceptions.RegraNegocioException;

public enum Residencia {

    PROPRIA,
    ALUGADA,
    AREA_DE_INVASAO,
    CEDIDA;

    public static Residencia getResidenciaCode(int opcao) {
        if (opcao == 1) {
            return PROPRIA;
        } else if (opcao == 2) {
            return ALUGADA;
        } else if (opcao == 3) {
            return AREA_DE_INVASAO;
        } else if(opcao == 4){
            return CEDIDA;
        } else {
            throw new RegraNegocioException("Campo Residência é inválido");
        }
    }
}
