package State;

/**
 * Interfaz que define los comportamientos según el estado del videojuego. Cada estado tiene comportamientos diferentes.
 */
public interface EstadoEcoChems {

    /**
     * Obtiene el nombre del estado actual.
     * @return el nombre del estado actual.
     */
    public String getEstado();

    /**
     * Pausar / reanudar el juego
     */
    public void PausarJuego(ContextoEstado contexto);

}