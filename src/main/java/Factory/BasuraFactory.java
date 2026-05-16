package Factory;

/**
 * Clase abstracta que implementa el patrón Factory para la creación de objetos de basura.
 */
public abstract class BasuraFactory {

    /**
     * Método abstracto para crear un objeto de basura.
     * 
     * @return un nuevo objeto de basura del tipo correspondiente a la subclase
     */
    public abstract ObjetoBasura crearBasura();

    /**
     * Método estático que genera un objeto de basura de forma aleatoria.
     * Selecciona aleatoriamente entre los tipos de basura disponibles implementados en el juego.
     * 
     * @return un objeto de basura elegido aleatoriamente
     */
    public static ObjetoBasura generarBasuraAleatoria() {
        int random = (int) (Math.random() * 5);
        
        switch (random) {
            case 0: return new BotellaPlastico();
            case 1: return new Lata();
            case 2: return new Espejo(); 
            case 3: return new Platano(); 
            case 4: return new CajaRegalo();
            case 5: return new RolloPapel(); 
            default: return null;
        }
    }
}