package State;

/**
 * Estado que representa el menú principal del videojuego.
 */
public class EstadoMenuPrincipal implements EstadoEcoChems {

    /**
     * Obtiene el nombre del estado actual.
     * @return el nombre del estado actual.
     */
    @Override
    public String getEstado(){ return "Menú Principal"; }

    /**
     * Pausar / reanudar el juego
     */
    @Override
    public void PausarJuego(ContextoEstado contexto){
        System.out.println("Pausa no disponible en Menú Principal");
    }
    
}
