import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] nombres = {
                "Coca-Cola", "Sprite", "Fanta", "Squirt", "Delaware Punch",
                "Panditas", "Doritos", "Rancheritos", "Donas Espolvoreadas", "Maruchan"};

        double[] precios = {19.0, 16.0, 15.5, 15.0, 16.0, 21.0, 15.5, 8.5, 28.5, 14.5}; // Precios en MXN
        double[] valores = {10.0, 5.0, 2.0, 1.0, 0.5};

        ColaProductos colaDeProductos = new ColaProductos(nombres, 10);
        ColaDinero colaDeDinero = new ColaDinero(valores, 15);

        for (int i = 0; i < nombres.length; i++) {
            for (int j = 1; j <= 10; j++) {
                colaDeProductos.agregarProducto(i, j);
            }
        }

        for (int i = 0; i < valores.length; i++) {
            colaDeDinero.agregarDinero(i, 10);  // Agregar 10 unidades de cada tipo de dinero
        }

        colaDeProductos.verProductos();
        System.out.println(" ");
        colaDeDinero.verDinero();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        while (true) {
            System.out.println("¿Qué producto deseas comprar?\n" +
                    "------------------------\n" +
                    "Bebidas:\n" +
                    "A1. Coca-Cola $19.00\n" +
                    "A2. Sprite $16.00\n" +
                    "A3. Fanta $15.50\n" +
                    "B1. Squirt $15.00\n" +
                    "B2. Delaware Punch $16.00\n" +
                    "\n" +
                    "Snacks:\n" +
                    "C1. Panditas $21.00\n" +
                    "C2. Doritos $15.50\n" +
                    "C3. Rancheritos $8.50\n" +
                    "\n" +
                    "Abarrotes:\n" +
                    "D1. Donas Espolvoreadas $28.50\n" +
                    "D2. Maruchan $14.50\n" +
                    "------------------------\n" +
                    "Ingrese P para ver existencias\n" +
                    "Ingrese $ para ver monedas\n" +
                    "Ingrese 0 para salir");
            String maquina = scanner.nextLine();
            if (maquina.equals("0")) {
                break;
            }

            double precioProducto = 0.0;
            boolean productoVendido = false;

            switch (maquina) {
                case "A1":
                    precioProducto = precios[0];
                    productoVendido = colaDeProductos.venderProducto(0);
                    break;
                case "A2":
                    precioProducto = precios[1];
                    productoVendido = colaDeProductos.venderProducto(1);
                    break;
                case "A3":
                    precioProducto = precios[2];
                    productoVendido = colaDeProductos.venderProducto(2);
                    break;
                case "B1":
                    precioProducto = precios[3];
                    productoVendido = colaDeProductos.venderProducto(3);
                    break;
                case "B2":
                    precioProducto = precios[4];
                    productoVendido = colaDeProductos.venderProducto(4);
                    break;
                case "C1":
                    precioProducto = precios[5];
                    productoVendido = colaDeProductos.venderProducto(5);
                    break;
                case "C2":
                    precioProducto = precios[6];
                    productoVendido = colaDeProductos.venderProducto(6);
                    break;
                case "C3":
                    precioProducto = precios[7];
                    productoVendido = colaDeProductos.venderProducto(7);
                    break;
                case "D1":
                    precioProducto = precios[8];
                    productoVendido = colaDeProductos.venderProducto(8);
                    break;
                case "D2":
                    precioProducto = precios[9];
                    productoVendido = colaDeProductos.venderProducto(9);
                    break;
                case "P":
                    colaDeProductos.verProductos();
                    break;
                case "$":
                    colaDeDinero.verDinero();
                    break;
                default:
                    System.out.println("ERROR ingrese lo que se les perras pidio");
            }

            if (productoVendido) {
                double totalIngresado = 0.0;

                while (totalIngresado < precioProducto) {
                    System.out.println("Introduce monedas (aceptamos 10, 5, 2, 1, 0.5): ");
                    if (scanner.hasNextDouble()) {
                        double moneda = scanner.nextDouble();
                        scanner.nextLine();  // Limpiar el buffer

                        boolean monedaValida = false;
                        for (int i = 0; i < valores.length; i++) {
                            if (valores[i] == moneda) {
                                if (!colaDeDinero.estaLleno(i)) {
                                    colaDeDinero.agregarDinero(i, 1);  // Agregar una unidad del valor correspondiente
                                    totalIngresado += moneda;
                                    monedaValida = true;
                                    break;
                                } else {
                                    System.out.println("No se puede agregar más monedas de " + moneda);
                                }
                            }
                        }

                        if (!monedaValida) {
                            System.out.println("Moneda inválida, por favor introduce otra.");
                        }

                        System.out.println("Total ingresado: " + totalIngresado + " / " + precioProducto);
                    } else {
                        System.out.println("Entrada inválida, por favor introduce un número.");
                        scanner.nextLine();  // Limpiar el buffer
                    }
                }

                if (totalIngresado > precioProducto) {
                    double cambio = totalIngresado - precioProducto;
                    System.out.println("Tu cambio es: " + cambio);

                    for (int i = 0; i < valores.length; i++) {
                        while (cambio >= valores[i] && !colaDeDinero.estaVacio(i)) {
                            colaDeDinero.usarDinero(i);
                            cambio -= valores[i];
                            cambio = Math.round(cambio * 100.0) / 100.0;
                        }
                    }

                    if (cambio > 0) {
                        System.out.println("No hay suficiente cambio disponible para " + cambio);
                    }
                }

                System.out.println("Compra realizada con éxito.");
            }
        }

        scanner.close();
    }
}

