package State;

import Modelo;

/**
 * Estado que representa el estado de juego cuando el jugador tiene 1 vida restante.
 */
public class Estado1Vida implements EstadoVidas {

    /**
     * Obtiene el numero de vidas restantes.
     * @return el numero de vidas restantes.
     */
    @Override
    public String getVidas(){ return "1"; }

    /**
     * Notifica al modelo que el jugador tiene 1 vidas al entrar a este estado.
     * @param modelo Modelo del juego.
     */
    public void entrar(Modelo modelo){
        System.out.println("¡Tienes 1 vida!");
        modelo.notificarCambioVidas(1);
    }

    /**
     * Descuenta una vida y transiciona al siguiente estado.
     * @param gestor Contexto de vidas.
     * @param modelo Modelo del juego.
     */
    public void perderVida(GestorVidas gestor, Modelo modelo){
        modelo.notificarError(0);
        gestor.cambiarEstado(new Estado0Vidas());

    }
    
}
