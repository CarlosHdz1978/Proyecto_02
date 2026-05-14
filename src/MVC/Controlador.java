package MVC; 

import Factory.*;
import Observer.*;

/**
 * Clase controladora del patrón MVC del juego EcoCheems.
 */
public class Controlador {
    private Modelo modelo;
    private Vista vista;

    /**
     * Inicializa el controlador con una instancia del modelo y la vista.
     * 
     * @param modelo el modelo que contiene la lógica del juego
     * @param vista la vista que se encarga de mostrar la interfaz al jugador
     * @param dificultad la dificultad escogida por el jugador
     */
    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    /**
     * Inicia y ejecuta una partida completa del juego EcoCheems.
     * 
     * El flujo de una partida es el siguiente:
     * 1. Se instancian e inicializan todos los observadores del sistema
     * 2. Los observadores se registran en el modelo para recibir notificaciones
     * 3. Se ejecuta un ciclo de juego que dura hasta 10 rondas o hasta que el jugador pierda
     * 4. En cada ronda:
     *    - Se muestra el inicio de la ronda
     *    - Se genera un objeto de basura aleatorio
     *    - Se muestra la basura al jugador
     *    - Se pide al jugador que seleccione el bote correcto
     *    - El modelo evalúa la respuesta
     *    - Se muestra el resultado del turno
     *    - Se avanza a la siguiente ronda
     * 5. Al finalizar, se muestra la pantalla de fin de juego con la puntuación
     * 
     */
    public void iniciarPartida() {

        int totalRondas = modelo.getDificultad().getCantidadResiduos();

        SonidoObserver sonidoObs = new SonidoObserver();
        LogroObserver logroObs = new LogroObserver();
        EstadisticasObserver statsObs = new EstadisticasObserver();
        
        VistaObserver vistaObs = new VistaObserver(this.vista);
        RecordObserver recordObs = new RecordObserver(this.vista);

        modelo.agregarObservador(sonidoObs);
        modelo.agregarObservador(logroObs);
        modelo.agregarObservador(statsObs);
        modelo.agregarObservador(vistaObs);
        modelo.agregarObservador(recordObs);

        while (modelo.getRondaActual() <= totalRondas && !modelo.isGameOver()) {
            
            vista.mostrarInicioRonda(modelo.getRondaActual());

            ObjetoBasura basuraDeLaRonda = BasuraFactory.generarBasuraAleatoria();

            vista.mostrarBasura(basuraDeLaRonda, modelo.getVidasActuales());

            int boteSeleccionado = vista.pedirBote();
            boolean fueCorrecto = modelo.evaluarRespuesta(boteSeleccionado, basuraDeLaRonda);

            vista.mostrarResultado(fueCorrecto);
            modelo.avanzarRonda();
        }

        boolean terminoConExito = !modelo.isGameOver();
        vista.mostrarFinDeJuego(modelo.getPuntuacion(), terminoConExito, totalRondas);
    }
}
