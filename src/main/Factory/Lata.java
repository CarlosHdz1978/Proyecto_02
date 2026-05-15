package main.Factory; 

/**
 * Clase que representa una lata de metal dentro del juego EcoCheems.
 * Es una subclase de ObjetoBasura que implementa un tipo específico de basura reciclable.
 * Las latas se clasifican como basura de tipo METAL.
 */
public class Lata extends ObjetoBasura {

    /**
     * Constructor de la clase Lata.
     * Crea una nueva lata de metal con el nombre "Lata" y tipo METAL.
     */
    public Lata() {
        super("Lata", TipoBasura.METAL);
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
