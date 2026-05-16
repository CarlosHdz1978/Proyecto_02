package Factory; 

/**
 * Clase que representa una cáscara de platano dentro del juego EcoCheems.
 * Es una subclase de ObjetoBasura que implementa un tipo específico de basura reciclable.
 * Las cáscaras de platano se clasifican como basura de tipo ORGANICO.
 */
public class Platano extends ObjetoBasura {

    /**
     * Constructor de la clase Platano.
     * Crea una nueva lata de metal con el nombre "Cáscara de platano" y tipo ORGANICO.
     */
    public Platano() {
        super("Cáscara de platano", TipoBasura.ORGANICO);
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