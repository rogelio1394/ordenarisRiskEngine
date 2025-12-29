package com.ordenaris.risk.engine;

import com.ordenaris.risk.model.NivelRiesgo;
import com.ordenaris.risk.model.RuleResult;

import java.util.List;

public class RiskResult {


    private final NivelRiesgo nivelFinal;
    private final List<RuleResult> detalles;
    private final String motivoFinal;

    public RiskResult(NivelRiesgo nivelFinal, List<RuleResult> detalles, String motivoFinal) {
        this.nivelFinal = nivelFinal;
        this.detalles = detalles;
        this.motivoFinal = motivoFinal;
    }

    public NivelRiesgo getNivelFinal() {
        return nivelFinal;
    }

    public List<RuleResult> getDetalles() {
        return detalles;
    }

    public String getMotivoFinal() {
        return motivoFinal;
    }

}
