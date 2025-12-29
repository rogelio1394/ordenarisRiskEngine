package com.ordenaris.risk;

import com.ordenaris.risk.engine.OrdenarisRiskEngine;
import com.ordenaris.risk.engine.RiskResult;
import com.ordenaris.risk.model.ProductoFinanciero;
import com.ordenaris.risk.model.RiskRequest;
import com.ordenaris.risk.providers.mocks.*;
import com.ordenaris.risk.rules.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] ars){

        OrdenarisRiskEngine engine = new OrdenarisRiskEngine(List.of(
                        new DeudaActivaRule(new DatosContablesMockProvider()),
                        new CapacidadPagoRule(new DatosContablesMockProvider()),
                        new HistorialPagosRule(new HistorialPagosMockProvider()),
                        new VerificacionLegalRule(new VerificacionLegalMockProvider()),
                        new MontoSolicitadoRule(),
                        new ProductoFinancieroRule()
                ));

        RiskRequest request = new RiskRequest(
            "EMP_001",
            new BigDecimal("50000"),
            ProductoFinanciero.LINEA_OPERATIVA,
            LocalDate.now()
        );

        RiskResult result = engine.evaluar(request);

        System.out.println("Nivel de riesgo final: " + result.getNivelFinal());
        result.getDetalles().forEach(r ->
                System.out.println(
                        r.getRegla() + " -> " + r.getNivelResultante()
                )
        );
        System.out.println("Motivo final: " + result.getMotivoFinal());

    }
}
