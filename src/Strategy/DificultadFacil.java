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
    public int getLimiteTiempo(){ return 50; }

    /**
     * Obtiene el numero de vidas.
     * @return el numero de vidas.
     */
    @Override
    public int getVidas(){ return 5; }

}


