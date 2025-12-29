# Ordenaris Risk Engine

Motor de evaluación de riesgo crediticio **modular y extensible**, desarrollado en **Java**, que permite evaluar solicitudes de financiamiento aplicando múltiples reglas de negocio desacopladas de las fuentes de datos.

---

## Descripción General

El motor evalúa una solicitud de crédito aplicando un conjunto de **reglas independientes**.  
Cada regla analiza información obtenida de **proveedores externos** y determina un nivel de riesgo parcial.

El resultado final se obtiene combinando los resultados de todas las reglas aplicadas.

El motor devuelve:

- **Nivel de riesgo final**: `BAJO`, `MEDIO`, `ALTO`, `RECHAZADO`
- **Listado de reglas evaluadas**, con su resultado individual
- **Motivo final de la decisión**, ya sea:
  - una **regla determinante**, o
  - una **combinación de reglas**

---

## Reglas de negocio implementadas

El motor aplica las siguientes reglas:

1. **DeudaActivaRule**
2. **CapacidadPagoRule**
3. **HistorialPagosRule**
4. **VerificacionLegalRule**
5. **MontoSolicitadoRule**
6. **ProductoFinancieroRule**

Cada regla puede:
- mantener el nivel de riesgo,
- incrementarlo,
- o **rechazar** la solicitud.

---

## Cómo ejecutar el motor

### Requisitos
- **Java 17 o superior**  
  (probado con Java 21)

### Ejecución
1. Abrir el proyecto en **IntelliJ IDEA** (o cualquier IDE compatible con Java)
2. Ejecutar la clase:
    
    com.ordenaris.risk.Application
