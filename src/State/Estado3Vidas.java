package State;

/**
 * Estado que representa el estado de juego cuando el jugador tiene 3 vidas restantes.
 */
public class Estado3Vidas implements EstadoVidas {

    /**
     * Obtiene el numero de vidas restantes.
     * @return el numero de vidas restantes.
     */
    @Override
    public String getVidas(){ return "3"; }

}
