package com.ordenaris.risk.rules;

import com.ordenaris.risk.engine.RiskContext;
import com.ordenaris.risk.model.DatosContables;
import com.ordenaris.risk.model.NivelRiesgo;
import com.ordenaris.risk.model.RuleResult;
import com.ordenaris.risk.providers.DatosContablesProvider;

import java.math.BigDecimal;

public class CapacidadPagoRule implements RiskRule{

    private final DatosContablesProvider provider;

    public CapacidadPagoRule(DatosContablesProvider provider) {
        this.provider = provider;
    }

    @Override
    public RuleResult evaluate(RiskContext context) {

        DatosContables datos = provider.obtener(context.getRequest().getEmpresaId());

        if (datos == null) {
            return RuleResult.noAplica("CapacidadPagoRule");
        }

        BigDecimal ingresos = datos.getIngresosMensuales();
        BigDecimal egresos = datos.getEgresosMensuales();

        if (egresos.compareTo(ingresos.multiply(new BigDecimal("0.8"))) > 0) {
            return RuleResult.aplicar("CapacidadPagoRule", NivelRiesgo.MEDIO);
        }

        return RuleResult.noAplica("CapacidadPagoRule");
    }

}
