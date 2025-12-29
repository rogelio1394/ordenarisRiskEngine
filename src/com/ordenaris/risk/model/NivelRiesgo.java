package com.ordenaris.risk.model;

public enum NivelRiesgo {
    BAJO(1),
    MEDIO(2),
    ALTO(3),
    RECHAZADO(4);

    private final int codigo;

    NivelRiesgo(int codigo) {
        this.codigo = codigo;
    }

    public NivelRiesgo merge(NivelRiesgo nivel) {
        return this.codigo >= nivel.codigo ? this : nivel;
    }

    public NivelRiesgo subir(NivelRiesgo nivel) {
        if(this == RECHAZADO) return this;
        return values()[this.ordinal() + 1];
    }

    public NivelRiesgo bajar(NivelRiesgo nivel) {
        if(this == BAJO) return this;
        return values()[this.ordinal() - 1];
    }
}
