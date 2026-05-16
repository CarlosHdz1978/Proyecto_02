package Observer;

/**
 * Clase abstracta que define el contrato para todos los observadores del juego.
 * 
 * Esta clase utiliza el patrón Observer para permitir que el modelo
 * notifique eventos importantes a múltiples observadores.
 * 
 * Los observadores concretos solo necesitan implementar los métodos que les interesan, 
 * mientras que los demás métodos pueden dejarse vacíos gracias a que es una clase abstracta.
 * 
 * @author Syntax Error
 */
public abstract class EventoJuegoObserver {
    /**
     * Notifica que el jugador ha acertado en la clasificación de un residuo.
     * 
     * @param puntosGanados Cantidad de puntos obtenidos por este acierto
     * @param rachaActual   Número de aciertos consecutivos actuales 
     */
    public abstract void acierto(int puntosGanados, int rachaActual);

    /**
     * Notifica que el jugador ha cometido un error al clasificar un residuo.
     * 
     * @param vidasRestantes Número de vidas que le quedan al jugador
     */
    public abstract void error(int vidasRestantes);

    /**
     * Notifica que el jugador ha desbloqueado un nuevo logro.
     * 
     * @param nombreLogro Nombre del logro desbloqueado
     */
    public abstract void logroDesbloqueado(String nombreLogro);
    
    /**
     * Notifica que la dificultad del juego ha cambiado.
     * 
     * @param nombreDificultad Nombre de la nueva dificultad (Fácil, Media, Difícil)
     */
    public abstract void cambioDificultad(String nombreDificultad);
    
    /**
     * Notifica que el jugador ha superado el récord global del juego.
     * 
     * @param nuevoRecord Nueva puntuación récord
     */
    public abstract void nuevoRecord(int nuevoRecord);

}