package State;

/**
 * Interfaz que define los comportamientos según el estado del videojuego. Cada estado tiene comportamientos diferentes.
 */
public interface Estado {

    /**
     * Obtiene el nombre del estado actual.
     * @return el nombre del estado actual.
     */
    public String getEstado();

}