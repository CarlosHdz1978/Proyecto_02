package Factory Method; 

public abstract class ObjetoBasura {
    protected String nombre;
    protected TipoBasura tipo;

    // Constructor que obliga a los hijos a definir nombre y tipo
    public ObjetoBasura(String nombre, TipoBasura tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Getters estándar (no necesitan ser reescritos por los hijos)
    public String getNombre() {
        return nombre;
    }

    public TipoBasura getTipo() {
        return tipo;
    }
}