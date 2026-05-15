package main.Observer;

/**
 * Observador encargado de recolectar estadísticas durante la partida.
 * 
 * Este observador lleva un registro de aciertos, errores, racha máxima
 * y puntos totales. Al final de la partida, proporciona un resumen
 * estadístico mediante el método getEstadisticas().
 * 
 * @author Syntax Error
 */
public class EstadisticasObserver extends EventoJuegoObserver {
    /** Total de aciertos en la partida */
    private int aciertosTotales;

    /** Total de errores de la partida */
    private int erroresTotales;
    
    /** Racha máxima de aciertos consecutivos alcanzada */
    private int rachaMaxima;
    
    /** Puntos totales acumulados en la partida */
    private int puntosTotales;

    /**
     * Constructor del observador de estadísticas.
     * Inicializa todos los contadores en cero.
     */
    public EstadisticasObserver() {
        this.aciertosTotales = 0;
        this.erroresTotales = 0;
        this.rachaMaxima = 0;
        this.puntosTotales = 0;
    }

    /**
     * Actualiza las estadísticas cuando el jugador acierta.
     * Incrementa aciertos, suma puntos y actualiza la racha máxima.
     * 
     * @param puntosGanados Puntos obtenidos por el acierto
     * @param rachaActual   Racha actual de aciertos consecutivos
     */
    @Override
    public void acierto(int puntosGanados, int rachaActual) {
        aciertosTotales++;
        puntosTotales += puntosGanados;
        
        if (rachaActual > rachaMaxima) {
            rachaMaxima = rachaActual;
        }
    }

    /**
     * Actualiza las estadísticas cuando el jugador comete un error.
     * Incrementa el contador de errores.
     * 
     * @param vidasRestantes Número de vidas restantes (no se usa)
     */
    @Override
    public void error(int vidasRestantes) {
        erroresTotales++;
    }

    /**
     * Este método no se utiliza en este observador.
     * 
     * @param nombreLogro No se utiliza
     */
    @Override
    public void logroDesbloqueado(String nombreLogro) {
        // No necesita hacer nada con logros
    }

    /**
     * Este método no se utiliza en este observador.
     * 
     * @param nombreDificultad No se utiliza
     */
    @Override
    public void cambioDificultad(String nombreDificultad) {
        // No necesita hacer nada con cambios de dificultad
    }

    /**
     * Este método no se utiliza en este observador.
     * 
     * @param nuevoRecord No se utiliza
     */
    @Override
    public void nuevoRecord(int nuevoRecord) {
        // No necesita hacer nada con récords
    }

    /**
     * Genera un resumen estadístico de la partida.
     * Incluye aciertos, errores, racha máxima y puntos totales
     * 
     * @return Cadena formateada con todas las estadísticas
     */
    public String getEstadisticas(){
        
        return String.format(
            "\n Estadísticas de la partida: \n" + 
            "  Aciertos: %d\n" +
            "  Errores: %d\n" +
            "  Racha máxima: %d\n" +
            "  Puntos totales: %d\n",
            aciertosTotales, erroresTotales, rachaMaxima, puntosTotales
        );
    }

    /**
     * Obtiene el total de aciertos.
     * @return Número de aciertos
     */
    public int getAciertosTotales() { return aciertosTotales; }
    
    /**
     * Obtiene el total de errores.
     * @return Número de errores
     */
    public int getErroresTotales() { return erroresTotales; }

    /**
     * Obtiene la racha máxima alcanzada.
     * @return Racha máxima de aciertos consecutivos
     */
    public int getRachaMaxima() { return rachaMaxima; }
    
    /**
     * Obtiene los puntos totales acumulados.
     * @return Suma total de puntos
     */
    public int getPuntosTotales() { return puntosTotales; }

}
