# Ordenaris Risk Engine

Motor de evaluación de riesgo crediticio modular y extensible, desarrollado en Java, que permite evaluar solicitudes de financiamiento aplicando múltiples reglas de negocio desacopladas de las fuentes de datos.

---

# Descripción General

El motor evalúa una solicitud de crédito aplicando un conjunto de reglas independientes.
Cada regla puede incrementar el nivel de riesgo o rechazar la solicitud según la información obtenida de proveedores externos.

El resultado final incluye:
- Nivel de riesgo (BAJO, MEDIO, ALTO, RECHAZADO)
- Lista de reglas evaluadas y su resultado
- Motivo final de la decisión (regla determinante o combinación de reglas)

# Cómo ejecutar el motor

# Requisitos
- Java 17 o superior (probado con Java 21)

# Ejecución
1. Abrir el proyecto en IntelliJ IDEA (o IDE compatible)
2. Ejecutar la clase: Application.java
