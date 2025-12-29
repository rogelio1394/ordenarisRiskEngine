package com.ordenaris.risk.engine;

import com.ordenaris.risk.model.NivelRiesgo;
import com.ordenaris.risk.model.RiskRequest;
import com.ordenaris.risk.model.RuleResult;
import com.ordenaris.risk.rules.RiskRule;

import java.util.List;

public class OrdenarisRiskEngine {

    private final List<RiskRule> reglas;

    public OrdenarisRiskEngine(List<RiskRule> reglas) {
        this.reglas = reglas;
    }

    public RiskResult evaluar(RiskRequest request) {
        RiskContext context = new RiskContext(request);

        for (RiskRule regla : reglas) {
            RuleResult resultado = regla.evaluate(context);
            context.aplicarResultado(resultado);
        }

        String motivoFinal = construirMotivo(context);

        return new RiskResult(
                context.getNivelRiesgo(),
                context.getResultados(),
                motivoFinal
        );
    }

    private String construirMotivo(RiskContext context) {

        if (context.getResultados().isEmpty()) {
            return "Sin reglas aplicables. Riesgo BAJO.";
        }

        return context.getResultados().stream()
            .filter(RuleResult::isAplicada)
            .map(RuleResult::getRegla)
            .reduce((a, b) -> a + " + " + b)
            .map(r -> {
                if (context.getNivelRiesgo() == NivelRiesgo.RECHAZADO) {
                    return "Rechazado por: " + r;
                }
                return "Riesgo " + context.getNivelRiesgo() + " por combinación de reglas: " + r;
            }).orElse("Sin reglas determinantes");
    }

}
