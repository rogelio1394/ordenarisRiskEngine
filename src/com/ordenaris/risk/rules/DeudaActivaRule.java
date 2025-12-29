package com.ordenaris.risk.rules;

import com.ordenaris.risk.engine.RiskContext;
import com.ordenaris.risk.model.DatosContables;
import com.ordenaris.risk.model.NivelRiesgo;
import com.ordenaris.risk.model.RuleResult;
import com.ordenaris.risk.providers.DatosContablesProvider;

import java.math.BigDecimal;

public class DeudaActivaRule implements RiskRule{

    private final DatosContablesProvider datosProvider;

    public DeudaActivaRule(DatosContablesProvider datosProvider) {
        this.datosProvider = datosProvider;
    }

    @Override
    public RuleResult evaluate(RiskContext context) {
        DatosContables datos = datosProvider.obtener(
                context.getRequest().getEmpresaId()
        );

        if (datos == null) {
            return RuleResult.noAplica("DeudaActivaRule");
        }

        BigDecimal ingresos = datos.getIngresosMensuales();
        BigDecimal deuda = datos.getDeudaTotal();

        if (ingresos.compareTo(BigDecimal.ZERO) <= 0) {
            return RuleResult.aplicar("DeudaActivaRule", NivelRiesgo.ALTO);
        }

        BigDecimal ratio = deuda.divide(ingresos, 2, BigDecimal.ROUND_HALF_UP);

        if (ratio.compareTo(new BigDecimal("0.5")) > 0) {
            return RuleResult.aplicar("DeudaActivaRule", NivelRiesgo.ALTO);
        }

        return RuleResult.noAplica("DeudaActivaRule");
    }

}
