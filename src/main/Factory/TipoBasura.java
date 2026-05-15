package main.Factory; 

/**
 * Enumeración que define los tipos de basura que se pueden recoger en el juego EcoCheems.
 * Cada tipo de basura está asociado con un número de bote para su reciclaje.
 */
public enum TipoBasura {
    ORGANICO(1),   
    INORGANICO(2),    
    PAPEL_CARTON(3),  
    METAL(4),
    VIDRIO(5); 
    
    private final int numeroBote;

    /**
     * Constructor de la enumeración TipoBasura.
     * Crea un nuevo tipo de basura asociado con el número de bote especificado.
     * 
     * @param numeroBote el número del bote de reciclaje para este tipo de basura
     */
    private TipoBasura(int numeroBote) { this.numeroBote = numeroBote; }

    /**
     * Obtiene el número del bote de reciclaje asociado a este tipo de basura.
     * 
     * @return el número del bote de reciclaje (1-5)
     */
    public int getNumeroBote() { return numeroBote; }
}
