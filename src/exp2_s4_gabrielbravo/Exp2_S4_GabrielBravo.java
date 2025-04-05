package exp2_s4_gabrielbravo;

import java.util.Scanner;

/**
 *
 * @author a
 */
public class Exp2_S4_GabrielBravo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Menú de opciones para el sistema
        String[] menuOptions = {"1. Comprar entrada", "2. Salir"};
        boolean salir = false;

        // Bucle principal del menú
        while (!salir) {
            System.out.println("\n--- Menú Principal ---");
            for (int i = 0; i < menuOptions.length; i++) {
                System.out.println(menuOptions[i]);
            }
            System.out.print("Seleccione una opción: ");

            int opcion = 0;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Por favor, ingrese un número.");
                continue;
            }

            if (opcion == 1) {
                comprarEntrada(scanner);
            } else if (opcion == 2) {
                System.out.println("Saliendo del sistema. ¡Gracias!");
                salir = true;
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    public static void comprarEntrada(Scanner scanner) {
        boolean realizarCompra = true;

        while (realizarCompra) {
            String zona;
            double precioBase = 0.0;

            System.out.println("\nPlano del Teatro:");
            System.out.println("Zona A: Mejor ubicación - $150");
            System.out.println("Zona B: Ubicación intermedia - $120");
            System.out.println("Zona C: Ubicación económica - $100");
            System.out.println("Zonas disponibles: A, B, C");

            while (true) {
                System.out.print("Ingrese la zona del asiento (A, B o C): ");
                zona = scanner.nextLine().toUpperCase();

                if (zona.equals("A")) {
                    precioBase = 150.0;
                    break;
                } else if (zona.equals("B")) {
                    precioBase = 120.0;
                    break;
                } else if (zona.equals("C")) {
                    precioBase = 100.0;
                    break;
                } else {
                    System.out.println("Zona no válida. Intente nuevamente.");
                }
            }

            int edad = 0;
            while (true) {
                System.out.print("Ingrese su edad (entre 1 y 120 años): ");
                try {
                    edad = Integer.parseInt(scanner.nextLine());
                    if (edad <= 0 || edad > 120) {
                        System.out.println("La edad debe estar entre 1 y 120 años. Intente nuevamente.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Edad no válida. Por favor, ingrese un número entero.");
                }
            }

            char esEstudiante = 'n';
            while (true) {
                System.out.print("¿Es estudiante? (s/n): ");
                String respuesta = scanner.nextLine().toLowerCase();
                if (respuesta.equals("s") || respuesta.equals("n")) {
                    esEstudiante = respuesta.charAt(0);
                    break;
                } else {
                    System.out.println("Respuesta no válida. Por favor, ingrese 's' o 'n'.");
                }
            }

            double descuento = 0.0;
            if (esEstudiante == 's') {
                descuento = 0.10;
            } else if (edad >= 65) {
                descuento = 0.15;
            }

            double precioFinal = precioBase - (precioBase * descuento);

            System.out.println("\n--- Resumen de la Compra ---");
            System.out.println("Zona de asiento: " + zona);
            System.out.println("Precio base: $" + precioBase);
            System.out.println("Descuento aplicado: " + (int)(descuento * 100) + "%");
            System.out.println("Precio final a pagar: $" + precioFinal);
            System.out.println("----------------------------");

            System.out.print("¿Desea realizar otra compra? (s/n): ");
            String otraCompra = scanner.nextLine().toLowerCase();
            if (!otraCompra.equals("s")) {
                System.out.println("Regresando al menú principal...");
                realizarCompra = false;
            }
        }
    }
}
