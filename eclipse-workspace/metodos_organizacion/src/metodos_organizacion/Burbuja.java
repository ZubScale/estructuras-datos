package metodos_organizacion;

public class Burbuja {
	public static void ordenarBurbuja(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}


// son 2 loops i es la longitud del arreglo y j compara un numero n-1 esto para comparar dos numeros juntos
// si mi arr j es mayor que arr j+1 esta desacomodado entonces se usa una variable temporal para cambiarlos de lugar 