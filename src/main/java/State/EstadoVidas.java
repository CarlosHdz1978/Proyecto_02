package State;

/**
 * Interfaz que define los comportamientos según el numero de vidas restantes. 
 */
public interface EstadoVidas {

    /**
     * Obtiene el numero de vidas restantes.
     * @return el numero de vidas restantes.
     */
    public int getVidas();

    /**
     * Obtiene el emoji que representa el numero de vidas restantes.
     * @return el emoji que representa el numero de vidas restantes.
     */
    public String getEmoji();

    /**
     * Descuenta una vida y transiciona al siguiente estado.
     * @return el siguiente estado de vidas después de perder una vida.
     */
    public EstadoVidas perderVida();

}