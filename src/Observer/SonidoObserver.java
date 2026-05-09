package Observer;

/**
 * Observador encargado de reproducir efectos de sonido en respuesta
 * a los eventos del juego.
 * 
 * Actualmente simula los sonidos mediante mensajes en consola,
 * pero está diseñado para ser fácilmente extensible a audio real
 * (JavaFX MediaPlayer, etc.) en el futuro.
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
            System.out.println("[EFECTO: racha_winner]");
        } else {
            System.out.println("[EFECTO: acierto] ");
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
            System.out.println("[EFECTO: game_over.]");
        } else {
            System.out.println("[EFECTO: error]");
        }
    }

    /**
     * Reproduce un sonido de celebración cuando se desbloquea un logro.
     * 
     * @param nombreLogro Nombre del logro (no se usa en el sonido)
     */
    @Override
    public void logroDesbloqueado(String nombreLogro) {
        System.out.println("[EFECTO: logro]");
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
        System.out.println("[EFECTO: nuevo_record_fanfarria.]");
    }
}
