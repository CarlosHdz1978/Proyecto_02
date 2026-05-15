package main.Strategy;

/**
 * Clase que implementa la interfaz EstrategiaDificultad para cambiar la dificultad del juego a dificil.
 */
public class DificultadDificil implements EstrategiaDificultad{

    /**
     * Obtiene el nombre de la dificultad actual.
     * @return el nombre de la dificultad actual.
     */
    @Override
    public String getDificultad(){ return "Dificil"; }

    /**
     * Obtiene el limite de tiempo.
     * @return el limite de tiempo.
     */
    @Override
    public int getLimiteTiempo(){ return 12; }

    /**
     * Obtiene el numero de vidas.
     * @return el numero de vidas.
     */
    @Override
    public int getVidas(){ return 1; }

    /**
     * Obtiene la cantidad de residuos que se generarán.
     * @return la cantidad de residuos.
     */
    @Override
    public int getCantidadResiduos(){ return 5; }

    /**
     * Obtiene cuantos puntos se ganaran por cada acierto.
     * @return los puntos por acierto.
     */
    @Override
    public int getPuntosAcierto(){ return 20; }

    /**
     * Obtiene cuantos puntos se perderan por cada error.
     * @return los puntos por errores.
     */
    @Override
    public int getPuntosError(){ return -10; }

}
