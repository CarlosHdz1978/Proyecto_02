package Strategy;

/**
 * Clase que implementa la interfaz EstrategiaDificultad para cambiar la dificultad del juego a facil.
 */
public class DificultadFacil implements EstrategiaDificultad{

    /**
     * Obtiene el nombre de la dificultad actual.
     * @return el nombre de la dificultad actual.
     */
    @Override
    public String getDificultad(){ return "Facil"; }

    /**
     * Obtiene el limite de tiempo.
     * @return el limite de tiempo.
     */
    @Override
    public int getLimiteTiempo(){ return 30; }

    /**
     * Obtiene el numero de vidas.
     * @return el numero de vidas.
     */
    @Override
    public int getVidas(){ return 3; }

    /**
     * Obtiene la cantidad de residuos que se generarán.
     * @return la cantidad de residuos.
     */
    @Override
    public int getCantidadResiduos(){ return 3; }

    /**
     * Obtiene cuantos puntos se ganaran por cada acierto.
     * @return los puntos por acierto.
     */
    @Override
    public int getPuntosAcierto(){ return 10; }

    /**
     * Obtiene cuantos puntos se perderan por cada error.
     * @return los puntos por errores.
     */
    @Override
    public int getPuntosError(){ return 0; }

}


