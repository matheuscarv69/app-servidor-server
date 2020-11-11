package io.github.matheuscarv69.domain.enums;

import io.github.matheuscarv69.exceptions.RegraNegocioException;

public enum Vacinas {

    SIM,
    NAO,
    NAO_SABE;

    public static Vacinas getVacinasCode(int opcao) {
        if (opcao == 1) {
            return SIM;
        } else if (opcao == 2) {
            return NAO;
        } else if (opcao == 3) {
            return NAO_SABE;
        }  else {
            throw new RegraNegocioException("Campo Vacinas é inválido");
        }
    }
}
