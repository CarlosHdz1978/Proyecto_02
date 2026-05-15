package main.Observer;

import main.MVC.*; 

/**
 * Observador especializado en gestionar y reaccionar a los nuevos récords.
 * 
 * Este observador solo reacciona al evento nuevoRecord, muestra una
 * animación especial para cuando se supera el récord.
 * 
 * @author Syntax Error
 */
public class RecordObserver extends EventoJuegoObserver {
    
    /** último récord registrado */
    private int ultimoRecord;
    
    /** Referencia a la vista para mostrar una animación */
    private Vista vista;

    /**
     * Constructor del observador de récords
     * 
     * @param vista Referencia a la vista del juego
     */
    public RecordObserver(Vista vista) {
        this.vista = vista;
        this.ultimoRecord = 0;
    }

    /**
     * Este método no se utiliza en este observador.
     * Permanece vacío porque solo interesa el récord.
     * 
     * @param puntosGanados No se utiliza
     * @param rachaActual   No se utiliza
     */
    @Override
    public void acierto(int puntosGanados, int rachaActual) {
        // No necesita hacer nada con aciertos
    }

    /**
     * Este método no se utiliza en este observador.
     * Permanece vacío porque solo interesa el récord.
     * 
     * @param vidasRestantes No se utiliza
     */
    @Override
    public void error(int vidasRestantes) {
        // No necesita hacer nada con errores
    }
    
    /**
     * Este método no se utiliza en este observador.
     * Permanece vacío porque solo interesa el récord.
     * 
     * @param nombreLogro No se utiliza
     */
    @Override
    public void logroDesbloqueado(String nombreLogro) {
        // No necesita hacer nada con logros
    }
    
    /**
     * Este método no se utiliza en este observador.
     * Permanece vacío porque solo interesa el récord.
     * 
     * @param nombreDificultad No se utiliza
     */
    @Override
    public void cambioDificultad(String nombreDificultad) {
        // No necesita hacer nada con cambios de dificultad
    }

    /**
     * Reacciona cuando se supera el récord global.
     * Actualiza el récord guardado y muestra un animación en la vista.
     */
    @Override
    public void nuevoRecord(int nuevoRecord) {
        this.ultimoRecord = nuevoRecord;
        //vista.mostrarAnimacionRecord(); Metodo aun NO implementado
        vista.mostrarMensaje(" ¡Nuevo récord global: " + nuevoRecord + " puntos!", false);
    }

    /**
     * Obtiene el último récord registrado.
     * 
     * @return La puntuación récord más reciente
     */
    public int getUltimoRecord() {
        return ultimoRecord;
    }
}
