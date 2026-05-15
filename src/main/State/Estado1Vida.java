package main.State;

/**
 * Estado que representa el estado de juego cuando el jugador tiene 1 vida restante.
 */
public class Estado1Vida implements EstadoVidas {

    /**
     * Obtiene el numero de vidas restantes.
     * @return el numero de vidas restantes.
     */
    @Override
    public int getVidas(){ return 1; }

    /**
     * Obtiene el emoji que representa el numero de vidas restantes.
     * @return el emoji que representa el numero de vidas restantes.
     */
    @Override
    public String getEmoji(){ return "♥♡♡"; }

    /**
     * Descuenta una vida y transiciona al siguiente estado.
     * @return el siguiente estado de vidas después de perder una vida.
     */
    @Override
    public EstadoVidas perderVida(){ return new Estado0Vidas(); }
    
}
