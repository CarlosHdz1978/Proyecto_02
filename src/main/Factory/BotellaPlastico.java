package main.Factory; 

/**
 * Clase que representa una botella de plástico dentro del juego EcoCheems.
 * Es una subclase de ObjetoBasura que implementa un tipo específico de basura reciclable.
 * Las botellas se clasifican como basura de tipo INORGANICO.
 */
public class BotellaPlastico extends ObjetoBasura {

    /**
     * Constructor de la clase BotellaPlastico.
     * Crea una nueva botella de plástico con el nombre "Botella de PET" y tipo INORGANICO.
     */
    public BotellaPlastico() {
        super("Botella de PET", TipoBasura.INORGANICO);
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
