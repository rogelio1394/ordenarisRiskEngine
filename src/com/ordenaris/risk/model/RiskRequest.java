package com.ordenaris.risk.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RiskRequest {

    private String empresaId;
    private BigDecimal montoSolicitado;
    private ProductoFinanciero productoFinanciero;
    private LocalDate fechaSolicitud;

    public RiskRequest(String empresaId, BigDecimal montoSolicitado, ProductoFinanciero productoFinanciero, LocalDate fechaSolicitud) {
        this.empresaId = empresaId;
        this.montoSolicitado = montoSolicitado;
        this.productoFinanciero = productoFinanciero;
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEmpresaId() {
        return empresaId;
    }

    public BigDecimal getMontoSolicitado() {
        return montoSolicitado;
    }

    public ProductoFinanciero getProductoFinanciero() {
        return productoFinanciero;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

}
