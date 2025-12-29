package com.ordenaris.risk.model;

import java.math.BigDecimal;

public class DatosContables {

    private final BigDecimal ingresosMensuales;
    private final BigDecimal egresosMensuales;
    private final BigDecimal deudaTotal;

    public DatosContables(BigDecimal ingresosMensuales, BigDecimal egresosMensuales, BigDecimal deudaTotal) {
        this.ingresosMensuales = ingresosMensuales;
        this.egresosMensuales = egresosMensuales;
        this.deudaTotal = deudaTotal;
    }

    public BigDecimal getIngresosMensuales() {
        return ingresosMensuales;
    }

    public BigDecimal getEgresosMensuales() {
        return egresosMensuales;
    }

    public BigDecimal getDeudaTotal() {
        return deudaTotal;
    }

}
