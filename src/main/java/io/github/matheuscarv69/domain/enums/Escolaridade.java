package io.github.matheuscarv69.domain.enums;

import io.github.matheuscarv69.exceptions.RegraNegocioException;

public enum Escolaridade {

    ANALFABETO,
    ENSINO_FUNDAMENTAL_INCOMPLETO,
    ENSINO_FUNDAMENTAL_COMPLETO,
    ENSINO_MEDIO_INCOMPLETO,
    ENSINO_MEDIO_COMPLETO,
    ENSINO_SUPERIOR_INCOMPLETO,
    ENSINO_SUPERIOR_COMPLETO;

    public static Escolaridade getEscolaridadeCode(int opcao) {
        if (opcao == 1) {
            return ANALFABETO;
        } else if (opcao == 2) {
            return ENSINO_FUNDAMENTAL_INCOMPLETO;
        } else if (opcao == 3) {
            return ENSINO_FUNDAMENTAL_COMPLETO;
        } else if (opcao == 4) {
            return ENSINO_MEDIO_INCOMPLETO;
        } else if (opcao == 5) {
            return ENSINO_MEDIO_COMPLETO;
        } else if (opcao == 6) {
            return ENSINO_SUPERIOR_INCOMPLETO;
        } else if (opcao == 7) {
            return ENSINO_SUPERIOR_COMPLETO;
        } else {
            throw new RegraNegocioException("Campo Estado Civil é inválido");
        }
    }
}
