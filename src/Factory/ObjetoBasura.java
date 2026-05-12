package Factory; 

/**
 * 
 */
public abstract class ObjetoBasura {
    protected String nombre;
    protected TipoBasura tipo;

    /**
     * 
     */
    public ObjetoBasura(String nombre, TipoBasura tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    /**
     * 
     */
    public String getNombre() { return nombre; }

    /**
     * 
     */
    public TipoBasura getTipo() { return tipo; }
}