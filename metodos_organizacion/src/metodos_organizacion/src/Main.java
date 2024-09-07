package metodos_organizacion;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	        Scanner leer = new Scanner(System.in);
	        System.out.print("Ingrese la expresión matemática: ");
	        String expresion = leer.nextLine();

	        if (Verificar.esValida(expresion)) {
	            System.out.println("La expresión es válida.");
	        } else {
	            System.out.println("La expresión es inválida.");
	        }
	        leer.close();
	    }
}