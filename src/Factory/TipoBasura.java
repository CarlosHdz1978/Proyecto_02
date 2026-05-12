package Factory; 

public enum TipoBasura {
    ORGANICO(1),   
    INORGANICO(2),    
    PAPEL_CARTON(3),  
    METAL(4),
    VIDRIO(5); 
    
    private final int numeroBote;

    private TipoBasura(int numeroBote) {
        this.numeroBote = numeroBote;
    }

    public int getNumeroBote() {
        return numeroBote;
    }
}
