package metodos_organizacion;

import java.util.Stack;

public class Verificar {
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
			} else if (cierre(c)) {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public static int fVeriExpresion(String cadena) throws Exception {
		Stack<Integer> valores = new Stack<>();
		Stack<Character> operadores = new Stack<>();

		for (char c : cadena.toCharArray()) {
			if (Character.isDigit(c)) {
				valores.push(c - '0');
			} else if (c == '(') {
				operadores.push(c);
			} else if (c == ')') {
				while (!operadores.isEmpty() && operadores.peek() != '(') {
					valores.push(evaluarOperacion(valores.pop(), valores.pop(), operadores.pop()));
				}
				operadores.pop(); // Remove '('
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				while (!operadores.isEmpty() && prioridad(c) <= prioridad(operadores.peek())) {
					valores.push(evaluarOperacion(valores.pop(), valores.pop(), operadores.pop()));
				}
				operadores.push(c);
			}
		}


		{
			while (!operadores.isEmpty()) {
				valores.push(evaluarOperacion(valores.pop(), valores.pop(), operadores.pop()));
			}

			if (valores.isEmpty()) {
				throw new Exception("No se encontró una expresión válida.");
			}
			return valores.pop();
		}
	}
	private static int evaluarOperacion(int num2, int num1, char op) throws Exception {
		switch (op) {
		case '+': return num1 + num2;
		case '-': return num1 - num2;
		case '*': return num1 * num2;
		case '/': 
			if (num2 == 0) throw new Exception("División por cero.");
			return num1 / num2;
		default: throw new Exception("Operación no válida: " + op);
		}
	}

	private static int prioridad(char operador) {
		switch (operador) {
		case '+':
		case '-': return 1;
		case '*':
		case '/': return 2;
		default: return 0;
		}
	}
}