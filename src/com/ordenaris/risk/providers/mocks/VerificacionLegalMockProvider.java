package com.ordenaris.risk.providers.mocks;

import com.ordenaris.risk.model.VerificacionLegal;
import com.ordenaris.risk.providers.VerificacionLegalProvider;

public class VerificacionLegalMockProvider implements VerificacionLegalProvider {
    @Override
    public VerificacionLegal obtener(String empresaId) {
        return new VerificacionLegal(false);
    }
}
