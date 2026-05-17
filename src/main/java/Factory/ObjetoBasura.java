package Factory; 

/**
 * Clase abstracta que representa un objeto de basura dentro del juego.
 * Define la estructura base para diferentes tipos de objetos que se pueden recoger en el juego EcoCheems.
 */
public abstract class ObjetoBasura {
    protected String nombre;
    protected TipoBasura tipo;
    protected String rutaImagen; 

    /**
     * Constructor de la clase ObjetoBasura.
     * Inicializa un nuevo objeto de basura con el nombre y tipo especificados.
     * 
     * @param nombre el nombre del objeto.
     * @param tipo el tipo de basura al que pertenece.
     */
    public ObjetoBasura(String nombre, TipoBasura tipo, String rutaImagen) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.rutaImagen = rutaImagen; 
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

    /**
     * Obtiene la ubicacion de la imagen del objeto (en java/resources/imagenes)
     * 
     * @return la ubicacion de la imagen del objeto
     */
    public String getRutaImagen() { return rutaImagen; }
}