import java.util.Scanner;
import MVC.*;

/**
 * Clase principal del juego EcoCheems.
 * Es el punto de entrada de la aplicación y gestiona el menú principal del juego.
 * Permite al usuario ver instrucciones, iniciar una partida o salir de la aplicación.
 */
public class EcoCheems {

    /**
     * Método principal de la aplicación.
     * Presenta un menú interactivo que permite al usuario:
     * - Ver las instrucciones del juego
     * - Iniciar una nueva partida
     * - Salir de la aplicación
     * 
     * El menú se repite hasta que el usuario seleccione la opción de salir.
     * Incluye manejo de excepciones para entradas inválidas.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("           ¡BIENVENIDO A ECO-CHEEMS!             ");
        System.out.println("=================================================");
        System.out.println("\nPresiona ENTER para continuar...");
        scanner.nextLine(); 

        System.out.println("\n-------------------------------------------------");
        System.out.println("Saber clasificar la basura no es solo un juego.");
        System.out.println("Es una acción vital para reducir la contaminación,");
        System.out.println("facilitar el reciclaje de materiales y darle un");
        System.out.println("respiro a nuestro planeta. ¡Cada acción cuenta!");
        System.out.println("-------------------------------------------------");
        System.out.println("\nPresiona ENTER para ir al menú principal...");
        scanner.nextLine(); 

        int opcion = 0;
        
        do {
            System.out.println("\n============= MENÚ PRINCIPAL =============");
            System.out.println("1. Instrucciones");
            System.out.println("2. Iniciar partida");
            System.out.println("3. Salir");
            System.out.print("Elige una opción (1-3): ");

            try {

                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        mostrarInstrucciones();
                        break;
                    case 2:
                        System.out.println("\nPreparando el juego...");
                        Modelo modelo = new Modelo();
                        Vista vista = new Vista();
                        Controlador controlador = new Controlador(modelo, vista);
                        controlador.iniciarPartida();
                        System.out.println("--- Partida terminada ---");
                        break;
                    case 3:
                        System.out.println("\n¡Gracias por jugar! Hasta luego.");
                        break;
                    default:
                        System.out.println("\n[!] Error: Opción no válida. Por favor ingresa 1, 2 o 3.");
                }

            } catch (NumberFormatException e) {
                System.out.println("\n[!] Error: Entrada inválida. Debes ingresar un número.");
            }

        } while (opcion != 3); 

        scanner.close(); 
    }

    /**
     * Muestra las instrucciones del juego en la consola.
     * Explica el número de rondas, cómo se juega, los tipos de botes de reciclaje,
     * el sistema de vidas y las condiciones de pérdida del juego.
     */
    private static void mostrarInstrucciones() {
        System.out.println("\n--------------- INSTRUCCIONES ---------------");
        System.out.println("* El juego consta de 10 rondas.");
        System.out.println("* En cada ronda aparecerá un objeto (ej. Lata, Plátano).");
        System.out.println("* Tienes un tiempo límite para escribir el número del bote correcto:");
        System.out.println("    1 - Orgánico");
        System.out.println("    2 - Inorgánico");
        System.out.println("    3 - Papel y Cartón");
        System.out.println("    4 - Metales");
        System.out.println("* Tienes 3 vidas. Si fallas o se acaba el tiempo, pierdes una.");
        System.out.println("* Si pierdes todas las vidas se reinicia la partida *");
        System.out.println("---------------------------------------------");
    }
}