package MVC; 

import java.util.ArrayList;
import java.util.List;
import Observer.EventoJuegoObserver;
import State.*; 
import Factory.*; 

public class Modelo {
    // Tus atributos actuales...
    private int puntos;
    private int rachaActual; 
    private int rondaActual;
    private EstadoVidas estadoVidas;  
    
    // NUEVO: La lista de los que están "escuchando"
    private List<EventoJuegoObserver> observadores;

    public Modelo() {
        this.puntos = 0;
        this.rondaActual = 1;
        this.rachaActual = 0;
        this.estadoVidas = new Estado3Vidas(); // El juego inicia con 3 vidas
        this.observadores = new ArrayList<>();
    }

    public void avanzarRonda() { this.rondaActual++; }
    public int getRondaActual() { return rondaActual; }
    public int getPuntuacion() { return puntos; }

    public boolean isGameOver() {
        // Tu lógica para saber si perdió, por ejemplo:
        return this.estadoVidas instanceof Estado0Vidas;
    }

    // Método para conectar los observadores
    public void agregarObservador(EventoJuegoObserver observador) {
        observadores.add(observador);
    }

    // Cuando el jugador acierta, el Modelo le grita a todos los observadores
    private void notificarAcierto(int puntosGanados) {
        for (EventoJuegoObserver obs : observadores) {
            obs.acierto(puntosGanados, rachaActual);
        }
    }

    // Cuando el jugador se equivoca
    private void notificarError(int vidasRestantes) {
        for (EventoJuegoObserver obs : observadores) {
            obs.error(vidasRestantes);
        }
    }

public boolean evaluarRespuesta(int boteSeleccionado, ObjetoBasura basura) {
        int boteCorrecto = basura.getTipo().getNumeroBote(); 

        if (boteSeleccionado == boteCorrecto) {
            puntos += 10; 
            rachaActual++;
            notificarAcierto(10); 
            return true;      
        } else {
            rachaActual = 0; // Se rompe la racha
            
            // CAMBIO 1: Reasignar el estado. 
            // Guardamos el NUEVO estado que nos devuelve perderVida()
            this.estadoVidas = this.estadoVidas.perderVida();  
            
            // CAMBIO 2: Transformar el String a int.
            // Como tu State devuelve un String (ej. "2"), lo convertimos a número 
            // para que los observadores (como el de Sonido) lo entiendan.
            int vidasRestantes = estadoVidas.getVidas();
            
            notificarError(vidasRestantes); // Dispara el sonido, la vista, etc.
            
            return false;     
        }
    }
}