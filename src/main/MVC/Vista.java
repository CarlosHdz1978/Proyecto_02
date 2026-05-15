package main.MVC;

import java.util.Scanner;
import main.Factory.*;
import main.State.*; 

/**
 * Clase vista del patrón MVC que gestiona la presentación e interacción con el usuario.
 * Se encarga de mostrar mensajes en la consola, solicitar entrada del usuario,
 * y presentar los resultados de cada turno y del juego en general.
 */
public class Vista {
    private Scanner scanner;

    /**
     * Constructor de la clase Vista.
     * Inicializa el Scanner para leer la entrada del usuario.
     */
    public Vista() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el inicio de una ronda con su número.
     * @param ronda el número de la ronda actual.
     */
    public void mostrarInicioRonda(int ronda) {
        System.out.println("\n--- RONDA " + ronda + " ---");
    }

    /**
     * Muestra el objeto de basura que debe clasificar el jugador.
     * Presenta las opciones disponibles de botes para que el usuario elija.
     * @param basura el objeto de basura que se va a mostrar
     */
    public void mostrarBasura(ObjetoBasura basura, EstadoVidas vidas) {
        System.out.println("Apareció: ** " + basura.getNombre() + " **");
        System.out.println(vidas.getEmoji());
        System.out.println("¿A qué bote pertenece?");
        System.out.println("[1] Orgánico  [2] Inorgánico  [3] Papel/Cartón  [4] Metal [5] Vidrio");
    }

    /**
     * Solicita al usuario que ingrese el número del bote donde debe ir la basura.
     * Realiza validación para asegurar que la entrada sea un número entero.
     * @return el número del bote ingresado por el usuario, o -1 si la entrada es inválida
     */
    public int pedirBote() {
        System.out.print("Escribe el número del bote: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Retorna un valor inválido si el usuario escribe letras
        }
    }

    /**
     * Muestra el resultado de la respuesta del usuario para el turno actual.
     * Indica si la clasificación fue correcta o incorrecta.
     * @param acierto true si la respuesta fue correcta, false si fue incorrecta
     */
    public void mostrarResultado(boolean acierto) {
        if (acierto) {
            System.out.println("¡CORRECTO! Muy bien hecho.");
        } else {
            System.out.println("¡INCORRECTO! Esa no era la clasificación adecuada.");
        }
    }

    /**
     * Muestra la pantalla de fin de juego con el resultado final y la puntuación total.
     * Indica si el jugador completó las rondas con éxito o si perdió por falta de vidas.
     * @param puntosTotales la puntuación final obtenida por el jugador
     * @param gano true si el jugador completó todas las rondas, false en caso contrario.
     */
    public void mostrarFinDeJuego(int puntosTotales, boolean gano, int totalRondas) {
        System.out.println("\n=================================");
        if (gano) {
            System.out.println("¡FELICIDADES! Terminaste las " +  totalRondas + " rondas.");
        } else {
            System.out.println("¡GAME OVER! Te quedaste sin vidas.");
        }
        System.out.println("Puntuación final: " + puntosTotales);
        System.out.println("=================================");
    }

    /**
     * Muestra un mensaje general en la consola.
     * Si es un error, le da un formato de advertencia.
     * 
     * @param mensaje el texto que se va a mostrar
     * @param esError true si es un mensaje de fallo, false si es un mensaje normal/éxito
     */
    public void mostrarMensaje(String mensaje, boolean esError) {
        System.out.println(mensaje);
    }

    /**
     * Muestra un mensaje especial y llamativo cuando el jugador
 lleva una buena racha de aciertos consecutivos.
     * 
     * @param rachaActual el número de aciertos consecutivos del jugador
     */
    public void mostrarRacha(int rachaActual) {
        System.out.println("Llevas una racha de " + rachaActual + " aciertos seguidos");
    }
}