package io.github.matheuscarv69.domain.enums;

import io.github.matheuscarv69.exceptions.RegraNegocioException;

public enum AtividadeLazerCadastradas {
    ATIVIDADES_MANUAIS,
    ATIVIDADES_SOCIAIS,
    ATIVIDADES_FISICAS_ESPORTIVAS,
    ATVIDADES_CULTURAIS,
    OUTRAS;

    public static AtividadeLazerCadastradas getAtividadeLazerCadastradasCode(int opcao) {
        if (opcao == 1) {
            return ATIVIDADES_MANUAIS;
        } else if (opcao == 2) {
            return ATIVIDADES_SOCIAIS;
        } else if (opcao == 3) {
            return ATIVIDADES_FISICAS_ESPORTIVAS;
        } else if (opcao == 4) {
            return ATVIDADES_CULTURAIS;
        } else if (opcao == 5) {
            return OUTRAS;
        } else {
            throw new RegraNegocioException("Campo Atividades Lazer Cadastradas é inválido");
        }
    }
}
