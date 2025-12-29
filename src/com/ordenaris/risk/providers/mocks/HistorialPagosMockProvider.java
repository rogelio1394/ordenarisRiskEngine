package com.ordenaris.risk.providers.mocks;

import com.ordenaris.risk.model.HistorialPagos;
import com.ordenaris.risk.providers.HistorialPagosProvider;

public class HistorialPagosMockProvider implements HistorialPagosProvider {
    @Override
    public HistorialPagos obtener(String empresaId) {
        return new HistorialPagos(0);
    }
}
