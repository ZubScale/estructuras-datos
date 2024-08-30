package metodos_organizacion;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Numeros num = new Numeros();
		Scanner leer = new Scanner(System.in);

		int[] arreglo = num.getNumeros();

		System.out.println("Arreglo original:");
		num.imprimirNumeros();

		System.out.println("Escoja un método de ordenamiento:");
		System.out.println("1: Burbuja");
		System.out.println("2: Inserción");
		System.out.println("3: Secuencial");

		String opcion = leer.nextLine();

		switch (opcion) {
		case "1":
			Burbuja.ordenarBurbuja(arreglo);
			System.out.println("Arreglo ordenado:");
			num.imprimirNumeros();
			break;
		case "2":
			Insercion.ordenarInsercion(arreglo);
			num.imprimirNumeros();
			break;
		case "3":
			Secuencial.ordenarSeleccion(arreglo);
			System.out.println("Arreglo ordenado por selección:");
			num.imprimirNumeros();
			break;
		default:
			System.out.println("Opción no válida.");
			break;
		}

		leer.close();
	}
}
