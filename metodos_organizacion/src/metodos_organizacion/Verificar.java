package tests;
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
        ArrayStack pilaCadena = new ArrayStack(cadena.length());
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (caracter >= '0' && caracter <= '9') {
                pilaCadena.push(caracter - '0');
            } else {
                switch (caracter) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        pilaCadena.push(caracter);
                        break;
                    case ')':
                        int numero2 = (int) pilaCadena.pop();
                        char operacion = (char) pilaCadena.pop();
                        int numero1 = (int) pilaCadena.pop();
                        int resultado = fOperacion(numero1, numero2, operacion);
                        pilaCadena.push(resultado);
                        break;
                }
            }
        }
        if (pilaCadena.isEmpty()) {
            throw new Exception("No se encontró una expresión válida.");
        }
        return (int) pilaCadena.pop();
    }

    public static int fOperacion(int numero1, int numero2, char operacion) throws Exception {
        switch (operacion) {
            case '+':
                return numero1 + numero2;
            case '-':
                return numero1 - numero2;
            case '*':
                return numero1 * numero2;
            case '/':
                if (numero2 == 0) {
                    throw new Exception("División por cero.");
                }
                return numero1 / numero2;
            default:
                throw new Exception("Operación no válida: " + operacion);
        }
    }
}
