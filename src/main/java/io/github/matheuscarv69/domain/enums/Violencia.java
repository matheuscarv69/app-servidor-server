package io.github.matheuscarv69.domain.enums;

public enum Violencia {
    NAO(1),
    FISICA(2),
    VERBAL(3),
    PSICOLOGICA(4),
    SEXUAL(5),
    PATRIMONIAL(6),
    OUTROS(7);

    private final int violenciaCode;

    Violencia(int violenciaCode) {
        this.violenciaCode = violenciaCode;
    }
}
