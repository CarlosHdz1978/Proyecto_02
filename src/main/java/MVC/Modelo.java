package MVC; 

import java.util.ArrayList;
import java.util.List;
import Observer.EventoJuegoObserver;
import State.*;
import Strategy.DificultadFacil;
import Strategy.EstrategiaDificultad;
import Factory.ObjetoBasura;
import State.*;
import Factory.*; 

/**
 * Clase modelo del patrón MVC que gestiona la lógica y estado del juego EcoCheems.
 * Mantiene el registro de puntos, rondas, vidas y rachas, además de notificar a los observadores
 * sobre los eventos importantes del juego.
 */
public class Modelo {
    private int puntos;
    private int rachaActual; 
    private int rondaActual;
    private EstadoVidas estadoVidas;  
    private EstrategiaDificultad dificultad;
    
    private List<EventoJuegoObserver> observadores;

    /**
     * Constructor del modelo.
     * Inicializa el juego con los valores iniciales: 0 puntos, ronda 1, sin racha y 3 vidas.
     */
    public Modelo() {
        this.puntos = 0;
        this.rondaActual = 1;
        this.rachaActual = 0;
        this.estadoVidas = new Estado3Vidas();
        this.observadores = new ArrayList<>();
        this.dificultad = new DificultadFacil();
    }

    /**
     * Avanza a la siguiente ronda del juego.
     */
    public void avanzarRonda() { this.rondaActual++; }
    
    /**
     * Obtiene el número de la ronda actual.
     * @return el número de la ronda actual.
     */
    public int getRondaActual() { return rondaActual; }

    
    /**
     * Obtiene la puntuación actual del jugador.
     * @return la puntuación actual del jugador.
     */
    public int getPuntuacion() { return puntos; }

    /**
     * Obtiene el estado actual de las vidas del jugador.
     * * Este método devuelve el objeto que encapsula la lógica y el comportamiento
     * según la salud restante (por ejemplo, Estado3Vidas, Estado1Vida).
     * * @return el objeto {@code EstadoVidas} que representa el estado de salud actual.
     */
    public EstadoVidas getVidasActuales() {
        return this.estadoVidas;
    }

    /**
     * Verifica si el juego ha terminado.
     * @return true si el juego ha terminado, false en caso contrario
     */
    public boolean isGameOver() {
        return this.estadoVidas instanceof Estado0Vidas;
    }

    /**
     * Notifica a todos los observadores que se ha desbloqueado un logro.
     */
    public void notificarLogro(String nombreLogro) {
        for (EventoJuegoObserver obs : observadores) {
            obs.logroDesbloqueado(nombreLogro);
        }
    }

    /**
     * Registra un observador que escuchará los eventos del juego.
     * @param observador el observador a registrar
     */
    public void agregarObservador(EventoJuegoObserver observador) {
        observadores.add(observador);
    }

    /**
     * Notifica a todos los observadores que el jugador ha acertado.
     * @param puntosGanados la cantidad de puntos ganados en el acierto
     */
    private void notificarAcierto(int puntosGanados) {
        for (EventoJuegoObserver obs : observadores) {
            obs.acierto(puntosGanados, rachaActual);
        }
    }

    /**
     * Notifica a todos los observadores que el jugador ha cometido un error.
     * @param vidasRestantes la cantidad de vidas que le quedan al jugador
     */
    private void notificarError(int vidasRestantes) {
        for (EventoJuegoObserver obs : observadores) {
            obs.error(vidasRestantes);
        }
    }

    /**
     * Evalúa la respuesta del jugador comparando el bote seleccionado con el bote correcto.
     * Actualiza la puntuación, racha y estado de vidas según corresponda.
     * Notifica a los observadores del resultado.
     * 
     * @param boteSeleccionado el número del bote que seleccionó el jugador
     * @param basura el objeto de basura que debía clasificarse
     * @return true si la respuesta es correcta, false en caso contrario
     */
    public boolean evaluarRespuesta(int boteSeleccionado, ObjetoBasura basura) {
        int boteCorrecto = basura.getTipo().getNumeroBote(); 

        if (boteSeleccionado == boteCorrecto) {
            puntos += dificultad.getPuntosAcierto(); 
            rachaActual++;
            notificarAcierto(puntos); 
            return true;      
        } else {
            rachaActual = 0; 

            puntos += dificultad.getPuntosError(); 
            if (puntos < 0) puntos = 0;
            
            this.estadoVidas = this.estadoVidas.perderVida();  
            
            int vidasRestantes = estadoVidas.getVidas();
            
            notificarError(vidasRestantes); 
            
            return false;     
        }
    }


    /**
     * Permite cambiar la dificultad del juego desde el menú principal.
     * <p>
     * Este método actualiza la estrategia de dificultad actual y realiza dos acciones adicionales:
     * <ol>
     * <li>Notifica a todos los observadores registrados ({@link EventoJuegoObserver}) sobre el cambio de dificultad.</li>
     * <li>Actualiza dinámicamente el estado del contador de vidas ({@code estadoVidas}) asignando una nueva 
     * instancia ({@link Estado3Vidas}, {@link Estado2Vidas} o {@link Estado1Vida}) de acuerdo con la cantidad 
     * de vidas que determine la nueva configuración.</li>
     * </ol>
     * </p>
     *
     * @param nuevaDificultad El objeto {@link EstrategiaDificultad} que contiene las reglas, 
     * el número de residuos y la configuración de vidas para la partida.
     */
    public void setDificultad(EstrategiaDificultad nuevaDificultad) {
        this.dificultad = nuevaDificultad;

        //Aviso a los observadores del cambio de dificultad
        for (EventoJuegoObserver obs : observadores) {
            obs.cambioDificultad(nuevaDificultad.getDificultad());
        }
            
        if (nuevaDificultad.getVidas() == 3) {
            this.estadoVidas = new Estado3Vidas();
        } else if (nuevaDificultad.getVidas() == 2) {
            this.estadoVidas = new Estado2Vidas(); 
        } else {
            this.estadoVidas = new Estado1Vida();
        }
    }

    /**
     * Obtiene la estrategia de dificultad que se encuentra activa en el juego.
     * <p>
     * Es de utilidad para que otros componentes (como los controladores) consulten 
     * los límites de la partida, por ejemplo, la cantidad máxima de residuos/rondas.
     * </p>
     *
     * @return El objeto {@link EstrategiaDificultad} que rige la partida actual.
     */
    public EstrategiaDificultad getDificultad() {
        return dificultad;
    }
}