package MVC; 

import Factory.BasuraFactory;
import Factory.ObjetoBasura;
import Observer.*;
/**
 * Clase controladora de la lógica interna del juego EcoCheems.
 * Se encarga de coordinar la comunicación entre el modelo del juego, 
 * la generación de elementos (basura) y la interacción con la interfaz gráfica.
 */
public class Controlador {

    /**
     * El modelo que contiene el estado y las reglas de negocio del juego.
     */
    private Modelo modelo;

    /**
     * El objeto de basura que se encuentra activo en la ronda actual.
     */
    private ObjetoBasura basuraActual; // Aquí guardamos la basura de la ronda actual

    /**
     * Constructor de la clase Controlador.
     * Inicializa el controlador vinculándolo a un modelo específico y 
     * genera la primera basura de forma aleatoria para comenzar el juego.
     *
     * @param modelo El modelo del juego con el que interactuará este controlador.
     */
    public Controlador(Modelo modelo) {
        this.modelo = modelo;
        generarNuevaBasura(); // Generamos la primera basura al iniciar el juego
    }

    /**
     * Configura e instancia los observadores necesarios para el juego.
     * Registra los observadores de sonido, logros y estadísticas dentro del modelo
     * para reaccionar a los eventos que ocurran durante la partida.
     */
    public void configurarObservadores() {
        SonidoObserver sonidoObs = new SonidoObserver();
        LogroObserver logroObs = new LogroObserver(this.modelo);
        EstadisticasObserver statsObs = new EstadisticasObserver();

        modelo.agregarObservador(sonidoObs);
        modelo.agregarObservador(logroObs);
        modelo.agregarObservador(statsObs);
    }

    /**
     * Genera un nuevo objeto de basura de manera aleatoria.
     * Utiliza la factoría {@link BasuraFactory} para asignar un nuevo elemento 
     * al atributo que almacena la basura de la ronda actual.
     */
    public void generarNuevaBasura() {
        this.basuraActual = BasuraFactory.generarBasuraAleatoria();
    }

    /**
     * Obtiene el objeto de basura que corresponde a la ronda actual.
     * Este método es de utilidad para que la interfaz gráfica (vista) sepa qué 
     * imagen o elemento visual debe renderizar en pantalla.
     *
     * @return El objeto {@link ObjetoBasura} de la ronda en curso.
     */
    public ObjetoBasura getBasuraActual() {
        return this.basuraActual;
    }

    /**
     * Evalúa la acción del jugador al seleccionar un bote de basura específico.
     * <p>
     * Este método realiza tres acciones principales:
     * <ol>
     * <li>Verifica si el bote seleccionado es el correcto a través del modelo (actualizando puntos y vidas).</li>
     * <li>Avanza el contador o estado de la ronda en el modelo.</li>
     * <li>Genera un nuevo desecho para el siguiente turno.</li>
     * </ol>
     * </p>
     *
     * @param numeroBote El identificador o número del bote seleccionado por el usuario.
     */
    public void evaluarBoteSeleccionado(int numeroBote) {
        modelo.evaluarRespuesta(numeroBote, basuraActual);
        modelo.avanzarRonda(); 
        generarNuevaBasura();
    }
}