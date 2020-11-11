package io.github.matheuscarv69.domain.enums;

import io.github.matheuscarv69.exceptions.RegraNegocioException;

public enum EstadoCivil {

    SOLTEIRO,
    CASADO,
    UNIAO_ESTAVEL,
    SEPARADO,
    DIVORCIADO,
    VIUVO;

    public static EstadoCivil getEstadoCode(int opcao) {
        if (opcao == 1) {
            return SOLTEIRO;
        } else if (opcao == 2) {
            return CASADO;
        } else if (opcao == 3) {
            return UNIAO_ESTAVEL;
        } else if (opcao == 4) {
            return SEPARADO;
        } else if (opcao == 5) {
            return DIVORCIADO;
        } else if (opcao == 6) {
            return VIUVO;
        } else {
            throw new RegraNegocioException("Campo Estado Civil é inválido");
        }
    }
}