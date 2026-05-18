package Observer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import java.net.URL;

/**
 * Observador encargado de reproducir efectos de sonido en respuesta
 * a los eventos del juego.
 * 
 * @author Syntax Error
 */
public class SonidoObserver extends EventoJuegoObserver {

    /**
     * Constructor del observador de sonidos.
     */
    public SonidoObserver() {
        // Constructor vacío
    }

    private void reproducirSonido(String rutaArchivo) {
        try {
            URL archivoSonido = getClass().getResource(rutaArchivo);
            if (archivoSonido != null) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(archivoSonido);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start(); 
            } else {
                System.out.println("[!] Archivo de sonido no encontrado: " + rutaArchivo);
            }
        } catch (Exception e) {
            System.out.println("[!] Error al reproducir sonido: " + e.getMessage());
        }
    }

    /**
     * Reproduce un sonido cuando el jugador acierta.
     * Si la racha es de 3 o más, reproduce un sonido especial.
     * 
     * @param puntosGanados Puntos obtenidos (no se usa en el sonido)
     * @param rachaActual   Racha actual (determina qué sonido reproducir)
     */
    @Override
    public void acierto(int puntosGanados, int rachaActual) {
        if (rachaActual >= 3) {
            System.out.println("Felicidades! LLevas una racha de " + rachaActual + " rondas.");
            reproducirSonido("/sonidos/racha.wav"); 
        } else {
            reproducirSonido("/sonidos/acierto.wav"); 
        }
    }

    /**
     * Reproduce un sonido cuando el jugador comete un error.
     * Si es Game Over, reproduce un sonido especial.
     * 
     * @param vidasRestantes Número de vidas restantes
     */
    @Override
    public void error(int vidasRestantes) {
        if (vidasRestantes == 0) {
            System.out.println("El juego ha terminado!");
            reproducirSonido("/sonidos/finJuego.wav");
        } else {
            reproducirSonido("/sonidos/error.wav");
        }
    }

    /**
     * Reproduce un sonido de celebración cuando se desbloquea un logro.
     * 
     * @param nombreLogro Nombre del logro (no se usa en el sonido)
     */
    @Override
    public void logroDesbloqueado(String nombreLogro) {
        System.out.println("Haz desbloqueado un logro!");
    }
    
    /**
     * Reproduce un sonido cuando cambia la dificultad.
     * 
     * @param nombreDificultad Nombre de la nueva dificultad (no se usa)
     */
    @Override
    public void cambioDificultad(String nombreDificultad) {
        System.out.println("[EFECTO: cambio_dificultad.]");
    }

    /**
     * Reproduce un sonido cuando se supera el récord global.
     * 
     * @param nuevoRecord Nueva puntuación récord (no se usa en el sonido)
     */
    @Override
    public void nuevoRecord(int nuevoRecord) {
        System.out.println("[EFECTO: nuevo_record]");
    }
}
