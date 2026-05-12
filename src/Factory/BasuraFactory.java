package Factory;

/*
 * 
 */
public abstract class BasuraFactory {
    

    /**
     * 
     */
    public abstract ObjetoBasura crearBasura();

    /*
     * 
     */
    public static ObjetoBasura generarBasuraAleatoria() {
        int random = (int) (Math.random() * 2); // Genera un número del 0 al 2
        
        switch (random) {
            case 0: return new BotellaPlastico();
            case 1: return new Lata();
            
            //Aqui ire agregando objetos

            default: return null;
        }
    }
}