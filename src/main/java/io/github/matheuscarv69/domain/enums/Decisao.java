package io.github.matheuscarv69.domain.enums;

import io.github.matheuscarv69.exceptions.RegraNegocioException;

public enum Decisao {
    SIM,
    NAO;

    public static Decisao getDecisaoCode(int opcao) {
        if (opcao == 1) {
            return SIM;
        } else if (opcao == 2) {
            return NAO;
        } else {
            throw new RegraNegocioException("Campo de Decisão é inválido");
        }
    }
}