
public class ColaProductos {
    private Productos[] productos;
    private int cantidadProductos;

    public ColaProductos(String[] nombresProductos, int unidadesPorProducto) {
        cantidadProductos = nombresProductos.length;
        productos = new Productos[cantidadProductos];

        for (int i = 0; i < cantidadProductos; i++) {
            productos[i] = new Productos(nombresProductos[i], unidadesPorProducto);
        }
    }

    public void agregarProducto(int indiceProducto, Object unidad) {
        if (indiceProducto >= 0 && indiceProducto < cantidadProductos) {
            if (!productos[indiceProducto].estaLleno()) {
                productos[indiceProducto].agregarUnidad(unidad);
            } else {
                System.out.println("El producto " + productos[indiceProducto].getNombre() + " ya tiene todas sus unidades.");
            }
        }
    }

    public boolean venderProducto(int indiceProducto) {
        if (indiceProducto >= 0 && indiceProducto < cantidadProductos) {
            if (!productos[indiceProducto].estaVacio()) {
                productos[indiceProducto].venderUnidad();
                System.out.println("Producto " + productos[indiceProducto].getNombre());
                return true;
            } else {
                System.out.println("El producto " + productos[indiceProducto].getNombre() + " no tiene unidades disponibles.");
            }
        }
        return false;
    }

    public void verProductos() {
        for (Productos producto : productos) {
            System.out.println(producto.toString());
        }
    }
}
