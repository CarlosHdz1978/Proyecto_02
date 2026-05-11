package FactoryMethod; 

public class BasuraFactory {
    
    public static ObjetoBasura generarBasuraAleatoria() {
        int random = (int) (Math.random() * 3); // Genera un número del 0 al 2
        
        switch (random) {
            case 0: return new CascaraPlatano();
            case 1: return new CajaCarton();
            case 2: return new LataRefresco();
            default: return null;
        }
    }
}