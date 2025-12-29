package com.ordenaris.risk.rules;

import com.ordenaris.risk.engine.RiskContext;
import com.ordenaris.risk.model.NivelRiesgo;
import com.ordenaris.risk.model.RuleResult;

import java.math.BigDecimal;

public class MontoSolicitadoRule implements RiskRule{

    @Override
    public RuleResult evaluate(RiskContext context) {
        BigDecimal monto = context.getRequest().getMontoSolicitado();

        if (monto.compareTo(new BigDecimal("200000")) > 0) {
            return RuleResult.aplicar("MontoSolicitadoRule", NivelRiesgo.MEDIO);
        }

        return RuleResult.noAplica("MontoSolicitadoRule");

    }
}
