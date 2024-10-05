package banco;

public class ColaDinero {
    private Dinero[] tiposDinero;
    private int cantidadTipos;

    public ColaDinero(double[] valores, int unidadesPorTipo) {
        cantidadTipos = valores.length;
        tiposDinero = new Dinero[cantidadTipos];

        for (int i = 0; i < cantidadTipos; i++) {
            tiposDinero[i] = new Dinero(valores[i], unidadesPorTipo);
        }
    }

    public void agregarDinero(int indiceTipo, int cantidad) {
        if (indiceTipo >= 0 && indiceTipo < cantidadTipos) {
            for (int i = 0; i < cantidad; i++) {
                if (!tiposDinero[indiceTipo].estaLleno()) {
                    tiposDinero[indiceTipo].agregarUnidad(tiposDinero[indiceTipo].getValor());
                } else {
                    System.out.println("El valor " + tiposDinero[indiceTipo].getValor() + " ya tiene todas sus unidades.");
                    break;
                }
            }
        }
    }

    public Object usarDinero(int indiceTipo) {
        if (indiceTipo >= 0 && indiceTipo < cantidadTipos) {
            if (!tiposDinero[indiceTipo].estaVacio()) {
                System.out.println("Usando una unidad de " + tiposDinero[indiceTipo].getValor());
                return tiposDinero[indiceTipo].usarUnidad();
            } else {
                System.out.println("El valor " + tiposDinero[indiceTipo].getValor() + " no tiene unidades disponibles.");
            }
        }
        return null;
    }

    public void verDinero() {
        for (Dinero dinero : tiposDinero) {
            System.out.println(dinero.toString());
        }
    }

    public boolean estaLleno(int indiceTipo) {
        if (indiceTipo >= 0 && indiceTipo < cantidadTipos) {
            return tiposDinero[indiceTipo].estaLleno();
        }
        return false;
    }

    public boolean estaVacio(int indiceTipo) {
        if (indiceTipo >= 0 && indiceTipo < cantidadTipos) {
            return tiposDinero[indiceTipo].estaVacio();
        }
        return false;
    }
}
