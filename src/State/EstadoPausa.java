package State;

/**
 * Estado que representa el estado de pausa del videojuego.
 */
public class EstadoPausa implements EstadoEcoChems {

    /**
     * Obtiene el nombre del estado actual.
     * @return el nombre del estado actual.
     */
    @Override
    public String getEstado(){ return "Pausa"; }

    /**
     * Pausar / reanudar el juego
     */
    @Override
    public void PausarJuego(ContextoEstado contexto){
        System.out.println("");
    }
    
}
