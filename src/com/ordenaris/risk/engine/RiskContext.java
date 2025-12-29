package com.ordenaris.risk.engine;

import com.ordenaris.risk.model.NivelRiesgo;
import com.ordenaris.risk.model.RiskRequest;
import com.ordenaris.risk.model.RuleResult;

import java.util.ArrayList;
import java.util.List;

public class RiskContext {

    private final RiskRequest request;
    private NivelRiesgo nivelRiesgo = NivelRiesgo.BAJO;
    private final List<RuleResult> resultados = new ArrayList<>();

    public RiskContext(RiskRequest request) {
        this.request = request;
    }

    public void aplicarResultado(RuleResult result) {
        resultados.add(result);
        nivelRiesgo = nivelRiesgo.merge(result.getNivelResultante());
    }

    public RiskRequest getRequest() {
        return request;
    }

    public NivelRiesgo getNivelRiesgo() {
        return nivelRiesgo;
    }

    public List<RuleResult> getResultados() {
        return resultados;
    }

}
