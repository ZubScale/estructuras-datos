package metodos_organizacion;

public class Verificar {
    public static boolean esValida(String expresion) {
        ArrayStack pila = new ArrayStack(expresion.length()); 

        for (char caracter : expresion.toCharArray()) {
            if (caracter == '(') {
                pila.push(caracter);  
            } else if (caracter == ')') {
                if (pila.isEmpty()) { 
                    return false;
                }
                pila.pop(); 
            }
        }

        return pila.isEmpty();
    }
}