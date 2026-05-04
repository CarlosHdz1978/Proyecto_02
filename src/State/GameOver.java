package State;

/**
 * Estado que representa el estado de juego terminado del videojuego.
 */
public class GameOver implements Estado {
    
    /**
     * Obtiene el nombre del estado actual.
     * @return el nombre del estado actual.
     */
    @Override
    public String getEstado(){ return "Game Over"; }

}
