/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculodeareas;

import java.util.Scanner;

/**
 * Clase abstracta que representa una figura geométrica genérica.
 */
abstract class FiguraGeometrica {
    public abstract double calcularArea();
}

/**
 * Representa un cuadrado.
 */
class Cuadrado extends FiguraGeometrica {
    private final double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return Math.pow(lado, 2);
    }
}

/**
 * Representa un círculo.
 */
class Circulo extends FiguraGeometrica {
    private final double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
}

/**
 * Representa un triángulo.
 */
class Triangulo extends FiguraGeometrica {
    private final double base;
    private final double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2.0;
    }
}

/**
 * Clase principal encargada de la ejecución del programa calculodeareas.
 */
public class Calculodeareas {
    private static final Scanner LECTOR = new Scanner(System.in);

    public static void main(String[] args) {
        ejecutarAplicacion();
        LECTOR.close();
    }

    /**
     * Controla el flujo principal del programa y el menú de usuario.
     */
    private static void ejecutarAplicacion() {
        int opcionSeleccionada;

        do {
            mostrarMenu();
            opcionSeleccionada = LECTOR.nextInt();

            if (opcionSeleccionada == 4) {
                System.out.println("¡Gracias por usar calculodeareas!");
                break;
            }

            procesarOpcion(opcionSeleccionada);

        } while (true);
    }

    /**
     * Muestra las opciones disponibles en la consola.
     */
    private static void mostrarMenu() {
        System.out.println("\n=== CALCULADORA DE ÁREAS (calculodeareas) ===");
        System.out.println("1. Cuadrado");
        System.out.println("2. Círculo");
        System.out.println("3. Triángulo");
        System.out.println("4. Salir");
        System.out.print("Elija una opción: ");
    }

    /**
     * Procesa la selección del usuario y muestra el resultado.
     */
    private static void procesarOpcion(int opcion) {
        FiguraGeometrica figura = crearFigura(opcion);

        if (figura != null) {
            System.out.printf("El área calculada es: %.2f%n", figura.calcularArea());
        } else {
            System.out.println("Opción no válida. Intente nuevamente.");
        }
    }

    /**
     * Fábrica simple para instanciar figuras geométricas según la opción del usuario.
     */
    private static FiguraGeometrica crearFigura(int opcion) {
        switch (opcion) {
            case 1:
                return new Cuadrado(solicitarMedida("Ingrese el lado del cuadrado: "));
            case 2:
                return new Circulo(solicitarMedida("Ingrese el radio del círculo: "));
            case 3:
                double base = solicitarMedida("Ingrese la base del triángulo: ");
                double altura = solicitarMedida("Ingrese la altura del triángulo: ");
                return new Triangulo(base, altura);
            default:
                return null;
        }
    }

    /**
     * Método auxiliar para evitar duplicación al solicitar valores numéricos por consola.
     */
    private static double solicitarMedida(String mensaje) {
        System.out.print(mensaje);
        return LECTOR.nextDouble();
    }
}