package metodos_organizacion;
import java.util.Stack;

public class MetodoPolaco {
    public static String convertirAPolaca(String expresion) {
        Stack<Character> operadores = new Stack<>();
        StringBuilder polaca = new StringBuilder();

        for (char c : expresion.toCharArray()) {
            if (Character.isDigit(c)) {
                polaca.append(c).append(" ");
            } else if (c == '(') {
                operadores.push(c);
            } else if (c == ')') {
                while (!operadores.isEmpty() && operadores.peek() != '(') {
                    polaca.append(operadores.pop()).append(" ");
                }
                operadores.pop(); // Desapilar el paréntesis abierto
            } else {
                while (!operadores.isEmpty() && prioridad(c) <= prioridad(operadores.peek())) {
                    polaca.append(operadores.pop()).append(" ");
                }
                operadores.push(c);
            }
        }

        while (!operadores.isEmpty()) {
            polaca.append(operadores.pop()).append(" ");
        }

        return polaca.toString().trim();
    }

    private static int prioridad(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
                return 0; // Menor prioridad que cualquier operador binario
            default:
                return -1; // Prioridad inválida
        }
    }
}