/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fibonaccinumber;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author david
 */
public class FibonacciNumber {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        FibonacciNumber fibonacci = new FibonacciNumber();
        
        // Datos de entrada
        System.out.println("Serie de Fibonacci");
        System.out.println("¿Que posicion deseas?");
        Scanner in = new Scanner(System.in);
        int posicion = obtenerEnteroValidado(in);
        
        // Calcular el número de Fibonacci y mostrarlo
        System.out.println("El número de Fibonacci en la posición " + posicion + " es:");
        fibonacci.calcularFibonacci(posicion);
    }
    
    // Método para verificar que sea un numero entero
    public static int obtenerEnteroValidado(Scanner scanner) {
        while (true) {
            try {
                int posicion = scanner.nextInt();
                if (posicion < 0) {
                    System.out.println("Por favor, ingresa un número positivo.");
                } else {
                    return posicion;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingresa un número entero válido.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
    }
    
    public void calcularFibonacci(int posicion) {
        String numeroAnterior = "0";
        String numeroActual = "1";
        
        // Calcular el número de Fibonacci de la posicion introducida
        for(int i = 2; i <= posicion; i++) {
            // Sumar los dos números anteriores para obtener el siguiente número
            String suma = sumaStrings(numeroAnterior, numeroActual);
            numeroAnterior = numeroActual;
            numeroActual = suma;
        }
        
        // Imprimir el número
        System.out.println(numeroActual);
        // Lo maximo que puede imprimir es en la posicion 19600
    }
    
    // Método para sumar dos números representados como cadenas de caracteres
    public String sumaStrings(String num1, String num2) {
        String resultado = "";
        int acarreo = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        // Realizar la suma de los dígitos, manejando el acarreo
        while (i >= 0 || j >= 0 || acarreo > 0) {
            int sum = acarreo;
            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
            }
            resultado = (sum % 10) + resultado;
            acarreo = sum / 10;
        }
        return resultado;
    }
}
