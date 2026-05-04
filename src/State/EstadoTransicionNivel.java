package State;

/**
 * Estado que representa el estado de transición entre niveles del videojuego.
 */
public class EstadoTransicionNivel implements EstadoEcoChems {

    /**
     * Obtiene el nombre del estado actual.
     * @return el nombre del estado actual.
     */
    @Override
    public String getEstado(){ return "Transición de Nivel"; }

    /**
     * Pausar / reanudar el juego
     */
    @Override
    public void PausarJuego(ContextoEstado contexto){
        System.out.println("Pausa no disponible durante Transición de Nivel");
    }
    
}
