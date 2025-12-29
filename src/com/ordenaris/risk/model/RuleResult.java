package com.ordenaris.risk.model;

public class RuleResult {

    private final String regla;
    private final boolean aplicada;
    private final NivelRiesgo nivelResultante;

    private RuleResult(String regla, boolean aplicada, NivelRiesgo nivelResultante) {
        this.regla = regla;
        this.aplicada = aplicada;
        this.nivelResultante = nivelResultante;
    }

    public static RuleResult aplicar(String regla, NivelRiesgo nivel) {
        return new RuleResult(regla, true, nivel);
    }

    public static RuleResult noAplica(String regla) {
        return new RuleResult(regla, false, NivelRiesgo.BAJO);
    }

    public String getRegla() {
        return regla;
    }

    public boolean isAplicada() {
        return aplicada;
    }

    public NivelRiesgo getNivelResultante() {
        return nivelResultante;
    }

}
