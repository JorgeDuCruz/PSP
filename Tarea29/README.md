``` mermaid
sequenceDiagram
    Cliente->>+Servidor:[String: operacion, double: operando1, double: operando2]
    Servidor-->>-Cliente:["OK", String: resultado] / ["Error", String: tipoError]
    
    Cliente->>+Servidor:[String[ ]: [operaciones], double[ ]: [operandos]]
    Servidor-->>-Cliente:["OK", String: resultado] / ["Error", String: tipoError]
    
    Cliente->>+Servidor:[String: tipoCalculadora, Sring: operacion, double: operando1, double: operando2]
    Servidor-->>-Cliente: ["OK", String: resultado] / ["Error", String: tipoError]
    
    Cliente->>+Servidor:[String: tipoCalculadora, Sring[ ]: [operaciones], double[ ]: [operandos]]
    Servidor-->>-Cliente: ["OK", String: resultado] / ["Error", String: tipoError]
    
    Cliente->>Servidor:[0] (Corta la conexion)
```