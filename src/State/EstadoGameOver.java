package State;

/**
 * Estado que representa el estado de juego terminado del videojuego.
 */
public class EstadoGameOver implements EstadoEcoChems {
    
    /**
     * Obtiene el nombre del estado actual.
     * @return el nombre del estado actual.
     */
    @Override
    public String getEstado(){ return "Game Over"; }

    /**
     * Pausar / reanudar el juego
     */
    @Override
    public void PausarJuego(ContextoEstado contexto){
        System.out.println("Pausa no disponible en Game Over");
    }

}
