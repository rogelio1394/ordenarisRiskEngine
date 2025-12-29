package com.ordenaris.risk.model;

public class VerificacionLegal {

    private final boolean tieneDemandasActivas;

    public VerificacionLegal(boolean tieneDemandasActivas) {
        this.tieneDemandasActivas = tieneDemandasActivas;
    }

    public boolean tieneDemandasActivas() {
        return tieneDemandasActivas;
    }

}
