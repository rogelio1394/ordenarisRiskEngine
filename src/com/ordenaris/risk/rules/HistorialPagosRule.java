package com.ordenaris.risk.rules;

import com.ordenaris.risk.engine.RiskContext;
import com.ordenaris.risk.model.HistorialPagos;
import com.ordenaris.risk.model.NivelRiesgo;
import com.ordenaris.risk.model.RuleResult;
import com.ordenaris.risk.providers.HistorialPagosProvider;

public class HistorialPagosRule  implements RiskRule{

    private final HistorialPagosProvider provider;

    public HistorialPagosRule(HistorialPagosProvider provider) {
        this.provider = provider;
    }

    @Override
    public RuleResult evaluate(RiskContext context) {

        HistorialPagos historial = provider.obtener(context.getRequest().getEmpresaId());

        if (historial == null) {
            return RuleResult.noAplica("HistorialPagosRule");
        }

        if (historial.getRetrasosUltimos12Meses() >= 3) {
            return RuleResult.aplicar(
                    "HistorialPagosRule",
                    NivelRiesgo.ALTO
            );
        }

        return RuleResult.noAplica("HistorialPagosRule");

    }
}
