package banco;

import java.util.Random;

public class Cliente {
    private boolean cuentahabiente;  // Indica si el cliente es un cuentahabiente

    public Cliente(String tipoCliente) {
        // Determinar el tipo de cliente basado en el argumento
        this.cuentahabiente = tipoCliente.equals("cuentahabiente");
    }

    public boolean isCuentahabiente() {
        return cuentahabiente;  // Retornar si el cliente es cuentahabiente
    }
}
