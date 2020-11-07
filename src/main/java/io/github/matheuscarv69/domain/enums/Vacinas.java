package io.github.matheuscarv69.domain.enums;

public enum Vacinas {

    SIM(1),
    NAO(2),
    NAO_SABE(3);

    private final int vacinasCode;

    Vacinas(int vacinasCode) {
        this.vacinasCode = vacinasCode;
    }
}
