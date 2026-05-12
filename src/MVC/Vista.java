package MVC;

import java.util.Scanner;
import Factory.*; 

public class Vista {
    private Scanner scanner;

    public Vista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarInicioRonda(int ronda) {
        System.out.println("\n--- RONDA " + ronda + " ---");
    }

    public void mostrarBasura(ObjetoBasura basura) {
        System.out.println("Apareció: ** " + basura.getNombre() + " **");
        System.out.println("¿A qué bote pertenece?");
        System.out.println("[1] Orgánico  [2] Inorgánico  [3] Papel/Cartón  [4] Metal [5] Vidrio");
    }

    public int pedirBote() {
        System.out.print("Escribe el número del bote: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Retorna un valor inválido si el usuario escribe letras
        }
    }

    public void mostrarResultado(boolean acierto) {
        if (acierto) {
            System.out.println("¡CORRECTO! Muy bien hecho.");
        } else {
            System.out.println("¡INCORRECTO! Esa no era la clasificación adecuada.");
        }
    }

    public void mostrarFinDeJuego(int puntosTotales, boolean gano) {
        System.out.println("\n=================================");
        if (gano) {
            System.out.println("¡FELICIDADES! Terminaste las 10 rondas.");
        } else {
            System.out.println("¡GAME OVER! Te quedaste sin vidas.");
        }
        System.out.println("Puntuación final: " + puntosTotales);
        System.out.println("=================================");
    }

    /**
     * Muestra un mensaje general en la consola.
     * Si es un error, le da un formato de advertencia.
     * * @param mensaje El texto que se va a mostrar
     * @param esError true si es un mensaje de fallo, false si es un mensaje normal/éxito
     */
    public void mostrarMensaje(String mensaje, boolean esError) {
        System.out.println(mensaje);
    }

    /**
     * Muestra un mensaje especial y llamativo cuando el jugador
     * lleva una buena racha de aciertos.
     * * @param rachaActual El número de aciertos consecutivos
     */
    public void mostrarRacha(int rachaActual) {
        System.out.println("Llevas una racha de " + rachaActual + " aciertos seguidos");
    }
}