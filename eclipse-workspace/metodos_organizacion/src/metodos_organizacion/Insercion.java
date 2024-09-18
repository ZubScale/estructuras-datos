package metodos_organizacion;

public class Insercion {

	public static void ordenarInsercion(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
}

//  este itera de i=1 hasta n-1 donde n es la longitud del arreglo
// se selecciona un elemento del indice i como llave para insertar despues  luego se itera j= i-1 hasta 0 comparando la llave con los elementos disponibles
//si arr j es mayor que la llave se mueve al siguente elemento