package metodos_organizacion;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una expresión matemática: ");
        String expresion = scanner.nextLine();
        if (Verificar.validacion(expresion)) {
            try {
            	 // Primero evaluamos la expresión
                int resultado = Verificar.fVeriExpresion(expresion);
                System.out.println("Resultado: " + resultado);

                // Luego convertimos la expresión a notación polaca
                String polaca = MetodoPolaco.convertirAPolaca(expresion);
                System.out.println("Notación polaca: " + polaca);

            } catch (Exception e) {
            	 System.out.println("Error al evaluar la expresión: " + e.getMessage());
            }
        } else {
        	System.out.println("Error: Expresión con paréntesis no balanceados.");
        }  scanner.close();
    }
}