package Factory; 

/**
 * Clase que representa un espejo roto dentro del juego EcoCheems.
 * Es una subclase de ObjetoBasura que implementa un tipo específico de basura reciclable.
 * Los espejos se clasifican como basura de tipo VIDRIO.
 */
public class Espejo extends ObjetoBasura {

    /**
     * Constructor de la clase Lata.
     * Crea una nuevo espejo con el nombre "Espejo roto" y tipo VIDRIO.
     */
    public Espejo() {
        super("Espejo roto", TipoBasura.VIDRIO, "/imagenes/espejoRoto.png");
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
