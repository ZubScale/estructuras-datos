package metodos_organizacion;

import java.util.Random;

public class Numeros {
	private int[] numeros;
	private Random random;

	public Numeros() {
		this.random = new Random();
		this.numeros = new int[50];
		generarNumeros();
	}

	private void generarNumeros() {
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = random.nextInt(200) + 1;
		}
	}

	public int[] getNumeros() {
		return numeros;
	}

	public void imprimirNumeros() {
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + "\t");
			if ((i + 1) % 5 == 0) {             
				System.out.println();
			}
		}
	}
}
