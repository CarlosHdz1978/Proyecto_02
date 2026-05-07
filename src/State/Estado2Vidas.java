package State;

/**
 * Estado que representa el estado de juego cuando el jugador tiene 2 vidas restantes.
 */
public class Estado2Vidas implements EstadoVidas {
    
    /**
     * Obtiene el numero de vidas restantes.
     * @return el numero de vidas restantes.
     */
    @Override
    public String getVidas(){ return "2"; }


}
