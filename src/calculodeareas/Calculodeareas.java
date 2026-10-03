/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculodeareas;

import java.util.Scanner;

// Clase abstracta que representa una figura geométrica genérica
abstract class Figura {
    // Método abstracto que cada subclase debe implementar obligatoriamente
    public abstract double calcularArea();
}

// Clase Cuadrado que hereda de Figura
class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}

// Clase Círculo que hereda de Figura
class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
}

// Clase Triángulo que hereda de Figura
class Triangulo extends Figura {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2.0;
    }
}

// Clase principal con el nombre solicitado
public class Calculodeareas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== CALCULADORA DE ÁREAS (calculodeareas) ===");
            System.out.println("1. Cuadrado");
            System.out.println("2. Círculo");
            System.out.println("3. Triángulo");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            
            opcion = scanner.nextInt();
            Figura figura = null;

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el lado del cuadrado: ");
                    double lado = scanner.nextDouble();
                    figura = new Cuadrado(lado);
                    break;
                case 2:
                    System.out.print("Ingrese el radio del círculo: ");
                    double radio = scanner.nextDouble();
                    figura = new Circulo(radio);
                    break;
                case 3:
                    System.out.print("Ingrese la base del triángulo: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingrese la altura del triángulo: ");
                    double altura = scanner.nextDouble();
                    figura = new Triangulo(base, altura);
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el programa!");
                    continue;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    continue;
            }

            // Aplicación de polimorfismo: se llama al método calcularArea() según la figura seleccionada
            System.out.println("El área calculada es: " + figura.calcularArea());

        } while (opcion != 4);

        scanner.close();
    }
}