package State;

/**
 * 
 */
public class ContextoEstado {

    public static final EstadoEcoChems MENU_PRINCIPAL   = new EstadoMenuPrincipal();
    public static final EstadoEcoChems JUGANDO          = new EstadoJugando();
    public static final EstadoEcoChems PAUSA            = new EstadoPausa();
    public static final EstadoEcoChems TRANSICION_NIVEL = new EstadoTransicionNivel();
    public static final EstadoEcoChems GAME_OVER        = new EstadoGameOver();

    private EstadoEcoChems estadoActual;

    /**
     * Obtiene el estado actual.
     * @return el estado actual.
     */
    public EstadoEcoChems getEstado(){ return estadoActual; }
    
}

