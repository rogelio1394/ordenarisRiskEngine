package com.ordenaris.risk.model;

public class HistorialPagos {

    private final int retrasosUltimos12Meses;

    public HistorialPagos(int retrasosUltimos12Meses) {
        this.retrasosUltimos12Meses = retrasosUltimos12Meses;
    }

    public int getRetrasosUltimos12Meses() {
        return retrasosUltimos12Meses;
    }

}
