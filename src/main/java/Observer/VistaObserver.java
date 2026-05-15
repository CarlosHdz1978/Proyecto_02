package Observer;

import MVC.*;

/**
 * Observador encargado de actualizar la interfaz de usuario
 * en respuesta a los mini eventos del juego.
 * 
 * Este observador actúa como puente entre el modelo del juego
 * y la vista, permitiendo que la interfaz se actualice en tiempo real
 * sin que el modelo conozca los detalles de la vista.
 * 
 * @author Syntax Error
 */
public class VistaObserver extends EventoJuegoObserver {
    
    /** Referencia a la vista del juego */
    private Vista vista;

    /**
     * Constructor del observador de vista.
     * 
     * @param vista Referencia a la vista del juego
     */
    public VistaObserver(Vista vista) {
        this.vista = vista;
    }

    /**
     * Actualiza la vista cuando el jugador acierta.
     * Muestra un mensaje de éxito y si la racha actual es 
     * significativa también muestra un mensaje.
     * 
     * @param puntosGanados Puntos obtenidos por el acierto
     * @param rachaActual Racha actual de aciertos consecutivos
     */
    @Override
    public void acierto(int puntosGanados, int rachaAtual) {
        vista.mostrarMensaje("¡Correcto!" + puntosGanados + " puntos", false);
        if (rachaAtual >= 3) {
            vista.mostrarRacha(rachaAtual);
        }
    }

    /**
     * Actualiza la vista cuando el jugador comete un error.
     * Muestra un mensaje de error.
     * 
     * @param vidasRestantes Número de vidas restantes (no se usa en este método)
     */
    @Override
    public void error(int vidasRestantes) {
        vista.mostrarMensaje(" Incorrecto. ¡Tú puedes lograrlo!", true);
    }

    /**
     * Actualiza la vista cuando se desbloquea un logro.
     * Muestra un mensaje especial de celebración.
     * 
     * @param nombreLogro Nombre del logro desbloqueado
     */
    @Override
    public void logroDesbloqueado(String nombreLogro) {
        vista.mostrarMensaje("Logro " + nombreLogro + " desbloqueado", false);
    }

    /**
     * Actualiza la vista cuando cambia la dificultad.
     * 
     * @param nombreDificultad Nombre de la nueva dificultad
     */
    @Override
    public void cambioDificultad(String nombreDificultad) {
        vista.mostrarMensaje("Dificultad cambiada a: " + nombreDificultad, false);
    }

    /**
     * Actualiza la vista cuando se supera el récord global
     * 
     * @param nuevoRecord nueva puntuación récord
     */
    @Override
    public void nuevoRecord(int nuevoRecord) {
        vista.mostrarMensaje("¡Nuevo récord alcanzado: "+ nuevoRecord + " puntos!", false);
    }
}
