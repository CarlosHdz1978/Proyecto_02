package State;

/**
 * Estado que representa el estado de juego activo del videojuego.
 */
public class Jugando implements Estado {

    /**
     * Obtiene el nombre del estado actual.
     * @return el nombre del estado actual.
     */
    @Override
    public String getEstado(){ return "Jugando"; }
    
}
