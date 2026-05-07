package State;

/**
 * Estado que representa el estado de juego cuando el jugador tiene 1 vida restante.
 */
public class Estado1Vida implements EstadoVidas {

    /**
     * Obtiene el numero de vidas restantes.
     * @return el numero de vidas restantes.
     */
    @Override
    public String getVidas(){ return "1"; }
    
}
