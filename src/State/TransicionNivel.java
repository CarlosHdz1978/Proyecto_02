package State;

/**
 * Estado que representa el estado de transición entre niveles del videojuego.
 */
public class TransicionNivel implements Estado {

    /**
     * Obtiene el nombre del estado actual.
     * @return el nombre del estado actual.
     */
    @Override
    public String getEstado(){ return "Transición de Nivel"; }
    
}
