package com.ordenaris.risk.rules;

import com.ordenaris.risk.engine.RiskContext;
import com.ordenaris.risk.model.NivelRiesgo;
import com.ordenaris.risk.model.RuleResult;
import com.ordenaris.risk.model.VerificacionLegal;
import com.ordenaris.risk.providers.VerificacionLegalProvider;

public class VerificacionLegalRule implements RiskRule{
    private final VerificacionLegalProvider provider;

    public VerificacionLegalRule(VerificacionLegalProvider provider) {
        this.provider = provider;
    }

    @Override
    public RuleResult evaluate(RiskContext context) {
        VerificacionLegal legal =
                provider.obtener(context.getRequest().getEmpresaId());

        if (legal == null) {
            return RuleResult.noAplica("VerificacionLegalRule");
        }

        if (legal.tieneDemandasActivas()) {
            return RuleResult.aplicar(
                    "VerificacionLegalRule",
                    NivelRiesgo.RECHAZADO
            );
        }

        return RuleResult.noAplica("VerificacionLegalRule");
    }
}
