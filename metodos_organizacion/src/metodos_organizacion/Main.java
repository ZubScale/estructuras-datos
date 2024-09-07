package tests;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingresa una operación: ");
        String cadena = leer.nextLine();

        boolean balanceado = Verificar.validacion(cadena);
        System.out.println("Paréntesis balanceados: " + balanceado);
        
        if (balanceado) {
            try {
                int resultadoOperacion = Verificar.fVeriExpresion(cadena);
                System.out.println("Resultado de la operación: " + resultadoOperacion);
            } catch (Exception e) {
                System.out.println("Error en la evaluación de la expresión: " + e.getMessage());
            }
        } else {
            System.out.println("La operación contiene paréntesis desbalanceados.");
        }
        leer.close();
    }
}