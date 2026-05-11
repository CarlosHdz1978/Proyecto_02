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

    /**
     * Obtiene la cantidad de residuos que se generarán.
     * @return la cantidad de residuos.
     */
    public int getCantidadResiduos();

    /**
     * Obtiene cuantos puntos se ganaran por cada acierto.
     * @return los puntos por aciertos.
     */
    public int getPuntosAciertos();

    /**
     * Obtiene cuantos puntos se perderan por cada error.
     * @return los puntos por errores.
     */
    public int getPuntosError();

} 