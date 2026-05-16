package Observer;

import MVC.*; 

/**
 * Observador encargado de gestionar los logros del juego.
 * 
 * Este observador detecta cuándo el jugador alcanza ciertos logros
 * significativos (rachas de 5, 10, 15 aciertos) y desbloquea 
 * logros en consecuencia.
 * También mantiene el registro de la racha máxima alcanzada.
 * 
 * @author Syntax Error
 */
public class LogroObserver extends EventoJuegoObserver {
    
    /** Racha máxima de aciertos consecutivos alcanzada */
    private int rachaMaxima;
    private Modelo modelo; 
    
    /**
     * Constructor del observador de logros.
     * Inicializa la racha máxima a cero.
     */
    public LogroObserver(Modelo modelo) {
        this.modelo = modelo;
        this.rachaMaxima = 0;
    }
    
    /**
     * Verifica si el jugador ha alcanzado un logro importante (5, 10, 15 aciertos)
     * y desbloquea el logro correspondiente. También actualiza la racha máxima.
     * 
     * @param puntosGanados Puntos obtenidos (no se usa directamente)
     * @param rachaActual   Racha actual de aciertos consecutivos
     */
    @Override
    public void acierto(int puntosGanados, int rachaActual) {
        // Actualizar racha máxima
        if (rachaActual > rachaMaxima) {
            rachaMaxima = rachaActual;
        }
        
        // Verificar logros por racha
        if (rachaActual == 3) {
            modelo.notificarLogro("ECOCHEEMS-NOVATO: 3 aciertos seguidos");
        } else if (rachaActual == 6) {
            modelo.notificarLogro("ECOCHEEMS-EXPERTO: 6 aciertos seguidos");
        } else if (rachaActual == 9) {
            modelo.notificarLogro("ECOCHEEMS-LEYENDA: 9 aciertos seguidos");
        }

    }
    
    /**
     * Advierte al jugador cuando le queda solo 1 vida.
     * 
     * @param vidasRestantes Número de vidas restantes
     */
    @Override
    public void error(int vidasRestantes) {
        if (vidasRestantes == 1) {
            modelo.notificarLogro(" ¡Cuidado! Te queda 1 vida, concéntrate.");
        }
    }
    
    /**
     * Este método está vacío porque LogroObserver solo 
     * detecta logros, no los muestra
     * 
     * @param nombreLogro Nombre del logro desbloqueado
     */
    @Override
    public void logroDesbloqueado(String nombreLogro) {
        // No necesita hacer nada en este observador
    }
    
    /**
     * Este método no se utiliza en este observador.
     * 
     * @param nombreDificultad No se utiliza
     */
    @Override
    public void cambioDificultad(String nombreDificultad) {
        // No necesita hacer nada en este observador
    }
    
    /**
     * Este método no se utiliza en este observador.
     * 
     * @param nuevoRecord No se utiliza
     */
    @Override
    public void nuevoRecord(int nuevoRecord) {
        // No necesita hacer nada en este observador
    }
    
    /**
     * Obtiene la racha máxima alcanzada durante la partida.
     * 
     * @return Racha máxima de aciertos consecutivos
     */
    public int getRachaMaxima() {
        return rachaMaxima;
    }
}
