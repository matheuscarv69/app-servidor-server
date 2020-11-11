package io.github.matheuscarv69.domain.enums;

import io.github.matheuscarv69.exceptions.RegraNegocioException;

public enum ViolenciasCadastradas {
    FISICA,
    VERBAL,
    PSICOLOGICA,
    SEXUAL,
    PATRIMONIAL,
    OUTROS;


    public static ViolenciasCadastradas getViolenciaCode(int opcao) {
        if (opcao == 1) {
            return FISICA;
        } else if (opcao == 2) {
            return VERBAL;
        } else if (opcao == 3) {
            return PSICOLOGICA;
        } else if (opcao == 4) {
            return SEXUAL;
        } else if (opcao == 5) {
            return PATRIMONIAL;
        } else if (opcao == 6) {
            return OUTROS;
        } else {
            throw new RegraNegocioException("Campo Violência Cadastradas é inválido");
        }
    }
}
