
public class Acomodar {
	package Acomodamientos;

	import Pilas.ArrayStack;

	import java.util.Scanner;

	public class Parentesis {
	    public static void main(String[] args) {
	        Scanner leer = new Scanner(System.in);
	        System.out.print("Ingresa una operacion: ");
	        String cadena = leer.nextLine();
	        boolean resultado = validacion(cadena);
	        System.out.println("Balance: " + resultado);
	        int resultadoOperacion = fVeriExpresion(cadena);
	        System.out.println("resultadoOperacion = " + resultadoOperacion);
	    }
	    public static boolean apertura(char c) {
	        return c == '(';
	    }
	    public static boolean cierre(char c) {
	        return c == ')';
	    }
	    public static boolean validacion(String cadena) {
	        ArrayStack stack = new ArrayStack(cadena.length());
	        for (char c : cadena.toCharArray()) {
	            if (apertura(c)) {
	                stack.push(c);
	            }
	            else if (cierre(c)) {
	                if (stack.isEmpty()) {
	                    return false;
	                }
	                stack.pop();
	            }
	        }
	        return stack.isEmpty();
	    }
	    public static int fVeriExpresion (String cadena){
	        ArrayStack pilaCadena = new ArrayStack(cadena.length());
	        for(int i = 0; i < cadena.length(); i++){
	            char caracter = cadena.charAt(i);
	            if(caracter>='0' && caracter<='9'){
	                pilaCadena.push(caracter - '0');
	            } else if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/') {
	                pilaCadena.push(caracter);
	            } else if (caracter == ')') {
	               int numero2 = (int) pilaCadena.pop();
	               char operacion = (char) pilaCadena.pop();
	               int numero1 = (int) pilaCadena.pop();
	               int resultado = fOperacion(numero1,numero2,operacion);
	               pilaCadena.push(resultado);
	            }
	        }
	        return (int) pilaCadena.pop();
	    }
	    public static int fOperacion (int numero1, int numero2, char operacion){
	        int resultado = 0;
	        if(operacion == '+'){
	            resultado = numero1 + numero2;
	        } else if (operacion == '-') {
	            resultado = numero1 - numero2;
	        } else if (operacion == '*') {
	            resultado = numero1 * numero2;
	        } else if (operacion == '/') {
	            resultado = (numero2 != 0)? numero1/numero2: 0;
	        }
	        return resultado;
	    }
	}
}
