package io.github.matheuscarv69.domain.enums;

public enum QualidadeVida {

    EXCELENTE(1),
    BOA(2),
    REGULAR(3),
    RUIM(4);

    private final int qualidadeVidaCode;

    QualidadeVida(int qualidadeVidaCode) {
        this.qualidadeVidaCode = qualidadeVidaCode;
    }
}
