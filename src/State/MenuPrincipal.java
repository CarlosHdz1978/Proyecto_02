package State;

/**
 * Estado que representa el menú principal del videojuego.
 */
public class MenuPrincipal implements Estado {

    /**
     * Obtiene el nombre del estado actual.
     * @return el nombre del estado actual.
     */
    @Override
    public String getEstado(){ return "Menú Principal"; }
    
}
