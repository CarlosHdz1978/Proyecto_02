package MVC; 

import Factory.*;
import Observer.EstadisticasObserver;
import Observer.LogroObserver;
import Observer.RecordObserver;
import Observer.SonidoObserver;
import Observer.VistaObserver; 

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarPartida() {

        //Instanciacion de los observadores
        SonidoObserver sonidoObs = new SonidoObserver();
        LogroObserver logroObs = new LogroObserver();
        EstadisticasObserver statsObs = new EstadisticasObserver();
        
        VistaObserver vistaObs = new VistaObserver(this.vista);
        RecordObserver recordObs = new RecordObserver(this.vista);

        // 2. Conectas los observadores al Modelo
        modelo.agregarObservador(sonidoObs);
        modelo.agregarObservador(logroObs);
        modelo.agregarObservador(statsObs);
        modelo.agregarObservador(vistaObs);
        modelo.agregarObservador(recordObs);

        // El ciclo del juego dura hasta 10 rondas y termina cuando el jugador pierda sus vidas
        while (modelo.getRondaActual() <= 10 && !modelo.isGameOver()) {
            

            vista.mostrarInicioRonda(modelo.getRondaActual());

            ObjetoBasura basuraDeLaRonda = BasuraFactory.generarBasuraAleatoria();

            // 3. La vista muestra la basura
            vista.mostrarBasura(basuraDeLaRonda);

            // 4. La vista le pide el número de bote al jugador
            int boteSeleccionado = vista.pedirBote();

            // NOTA SOBRE EL TIEMPO:
            // Implementar un temporizador real en consola que interrumpa el 'Scanner' es muy complejo en Java.
            // Por ahora, en la versión de consola, el tiempo es infinito. 
            // Cuando pases a JavaFX, usarás 'Timeline' para manejar el tiempo correctamente.

            // 5. El modelo evalúa si la respuesta es correcta
            boolean fueCorrecto = modelo.evaluarRespuesta(boteSeleccionado, basuraDeLaRonda);

            // 6. La vista muestra el resultado del turno
            vista.mostrarResultado(fueCorrecto);

            // 7. Avanzamos de ronda
            modelo.avanzarRonda();
        }

        // Al salir del ciclo (ya sea por ganar o perder), se muestra la pantalla final
        boolean terminoConExito = !modelo.isGameOver();
        vista.mostrarFinDeJuego(modelo.getPuntuacion(), terminoConExito);
    }
}
