package MVC; 

import Factory.BasuraFactory;
import Factory.ObjetoBasura;
import Observer.*;

/**
 * Clase controladora de la lógica interna del juego EcoCheems.
 */
public class Controlador {
    private Modelo modelo;
    private ObjetoBasura basuraActual; // Aquí guardamos la basura de la ronda actual

    public Controlador(Modelo modelo) {
        this.modelo = modelo;
        generarNuevaBasura(); // Generamos la primera basura al iniciar el juego
    }

    public void configurarObservadores() {
        SonidoObserver sonidoObs = new SonidoObserver();
        LogroObserver logroObs = new LogroObserver(this.modelo);
        EstadisticasObserver statsObs = new EstadisticasObserver();

        modelo.agregarObservador(sonidoObs);
        modelo.agregarObservador(logroObs);
        modelo.agregarObservador(statsObs);
    }

    // Método para crear una nueva basura al azar
    public void generarNuevaBasura() {
        this.basuraActual = BasuraFactory.generarBasuraAleatoria();
    }

    // La interfaz gráfica usará este método para saber qué imagen poner
    public ObjetoBasura getBasuraActual() {
        return this.basuraActual;
    }

    public void evaluarBoteSeleccionado(int numeroBote) {
        // 1. Usamos TU método evaluarRespuesta (que ya suma puntos y quita vidas)
        modelo.evaluarRespuesta(numeroBote, basuraActual);

        // 2. Avanzamos la ronda
        modelo.avanzarRonda(); 

        // 3. Preparamos la basura para el siguiente turno
        generarNuevaBasura();
    }
}