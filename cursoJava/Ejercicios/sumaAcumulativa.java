package Ejercicios;

public class sumaAcumulativa {
    public static void main(String[] args) {
        System.out.println("suma acumulativa");
        final var MAXIMO = 5;
        var acumuladorSuma = 0;

        var numero = 1;
        while (numero <= MAXIMO){
            acumuladorSuma += numero++;
        }
        System.out.println("suma de los primeros " + MAXIMO +" numeros: "+acumuladorSuma);
    }
}
