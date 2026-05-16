package Factory; 

/**
 * Clase que representa una caja de regalo dentro del juego EcoCheems.
 * Es una subclase de ObjetoBasura que implementa un tipo específico de basura reciclable.
 * Las cajas de regalo se clasifican como basura de tipo PAPEL_CARTON.
 */
public class CajaRegalo extends ObjetoBasura {

    /**
     * Constructor de la clase CajaRegalo.
     * Crea una nueva caja de regalo con el nombre "Caja de regalo" y tipo PAPEL_CARTON.
     */
    public CajaRegalo() {
        super("Caja de regalo", TipoBasura.PAPEL_CARTON, "/imagenes/cajaRegalo.png");
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
