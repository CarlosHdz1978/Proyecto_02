package Strategy;
 
/**
 * Interfaz que define la estrategia de dificultad para el juego.
 */
public interface EstrategiaDificultad {

     /**
     * Obtiene el nombre del estado actual.
     * @return el nombre del estado actual.
     */
    public String getDificultad();

    /**
     * Obtiene el limite de tiempo.
     * @return el limite de tiempo.
     */
    public int getLimiteTiempo();

    /**
     * Obtiene el numero de vidas.
     * @return el numero de vidas.
     */
    public int getVidas();

} 