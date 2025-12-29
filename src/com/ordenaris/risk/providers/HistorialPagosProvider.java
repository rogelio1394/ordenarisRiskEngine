package com.ordenaris.risk.providers;

import com.ordenaris.risk.model.HistorialPagos;

public interface HistorialPagosProvider {
    HistorialPagos obtener(String empresaId);
}
