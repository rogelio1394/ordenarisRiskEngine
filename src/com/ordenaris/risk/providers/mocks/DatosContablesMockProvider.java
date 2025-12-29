package com.ordenaris.risk.providers.mocks;

import com.ordenaris.risk.model.DatosContables;
import com.ordenaris.risk.providers.DatosContablesProvider;

import java.math.BigDecimal;

public class DatosContablesMockProvider implements DatosContablesProvider {

    @Override
    public DatosContables obtener(String empresaId) {
        return new DatosContables(
                new BigDecimal("150000"),
                new BigDecimal("70000"),
                new BigDecimal("30000")
        );
    }
}
