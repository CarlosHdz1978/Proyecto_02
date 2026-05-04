package State;

/**
 * Estado que representa el estado de juego activo del videojuego.
 */
public class EstadoJugando implements EstadoEcoChems {

    /**
     * Obtiene el nombre del estado actual.
     * @return el nombre del estado actual.
     */
    @Override
    public String getEstado(){ return "Jugando"; }

    /**
     * Pausar / reanudar el juego
     */
    @Override
    public void PausarJuego(ContextoEstado contexto){
        System.out.println("");
    }
    
}
