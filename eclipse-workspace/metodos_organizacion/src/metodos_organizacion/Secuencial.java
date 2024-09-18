package metodos_organizacion;

public class Secuencial {

	public static void ordenarSeleccion(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}
}


// aca tambien son 2 loops i donde se itera de 0 a n-2 donde n es la longitud del arreglo esto controla la cantidad de veces que se pasa pasa el metodo por el arreglo
// este itera de j= i+1 hasta n-1 para encontrar el indice menor  en la parte del arreglo que no hemos arreglado y se cambia con i 