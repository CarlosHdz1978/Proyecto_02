package State;

/**
 * Estado que representa el estado de pausa del videojuego.
 */
public class Pausa implements Estado {

    /**
     * Obtiene el nombre del estado actual.
     * @return el nombre del estado actual.
     */
    @Override
    public String getEstado(){ return "Pausa"; }
    
}
