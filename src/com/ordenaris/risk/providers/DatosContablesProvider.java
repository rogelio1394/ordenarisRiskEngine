package com.ordenaris.risk.providers;

import com.ordenaris.risk.model.DatosContables;

public interface DatosContablesProvider {
    DatosContables obtener(String empresaId);
}
