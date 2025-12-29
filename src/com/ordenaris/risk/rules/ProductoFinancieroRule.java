package com.ordenaris.risk.rules;

import com.ordenaris.risk.engine.RiskContext;
import com.ordenaris.risk.model.NivelRiesgo;
import com.ordenaris.risk.model.ProductoFinanciero;
import com.ordenaris.risk.model.RuleResult;

public class ProductoFinancieroRule implements RiskRule {


    @Override
    public RuleResult evaluate(RiskContext context) {

        ProductoFinanciero producto = context.getRequest().getProductoFinanciero();

        if (producto == ProductoFinanciero.CREDITO_REVOLVENTE) {
            return RuleResult.aplicar(
                    "ProductoFinancieroRule",
                    NivelRiesgo.MEDIO
            );
        }

        return RuleResult.noAplica("ProductoFinancieroRule");
    }
}
