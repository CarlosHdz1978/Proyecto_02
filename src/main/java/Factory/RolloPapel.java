package Factory; 

/**
 * Clase que representa un rollo de papel higienico dentro del juego EcoCheems.
 * Es una subclase de ObjetoBasura que implementa un tipo específico de basura reciclable.
 * Los rollos de papel se clasifican como basura de tipo PAPEL_CARTON.
 */
public class RolloPapel extends ObjetoBasura {

    /**
     * Constructor de la clase RolloPapel.
     * Crea un neuvo rollo de papel con el nombre "Rollo de papel higienico" y tipo PAPEL_CARTON.
     */
    public RolloPapel() {
        super("Rollo de papel higiénico", TipoBasura.PAPEL_CARTON, "/imagenes/rolloPapel.png");
    }

    /**
     * Obtiene el nombre del objeto.
     * 
     * @return el nombre del objeto.
     */
    public String getNombre() { return nombre; }

    /**
     * Obtiene el tipo de basura al que pertenece el objeto.
     * 
     * @return el tipo de basura al que pertenece el objeto.
     */
    public TipoBasura getTipo() { return tipo; }
}
