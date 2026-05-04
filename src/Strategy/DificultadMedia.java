package Strategy;

/**
 * Clase que implementa la interfaz EstrategiaDificultad para cambiar la dificultad del juego a media.
 */
public class DificultadMedia implements EstrategiaDificultad{

    /**
     * Obtiene el nombre de la dificultad actual.
     * @return el nombre de la dificultad actual.
     */
    @Override
    public String getDificultad(){ return "Media"; }

    }
