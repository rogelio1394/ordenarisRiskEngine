package com.ordenaris.risk.providers;

import com.ordenaris.risk.model.VerificacionLegal;

public interface VerificacionLegalProvider {
    VerificacionLegal obtener(String empresaId);
}
