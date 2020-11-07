package io.github.matheuscarv69.domain.enums;

public enum Residencia {

    PROPRIA(1),
    ALUGADA(2),
    AREA_DE_INVASAO(3),
    CEDIDA(4);

    private final int residenciaCode;

    Residencia(int residenciaCode) {
        this.residenciaCode = residenciaCode;
    }
}
