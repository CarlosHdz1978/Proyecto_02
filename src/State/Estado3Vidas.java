package State;

import Modelo;

/**
 * Estado que representa el estado de juego cuando el jugador tiene 3 vidas restantes.
 */
public class Estado3Vidas implements EstadoVidas {

    /**
     * Obtiene el numero de vidas restantes.
     * @return el numero de vidas restantes.
     */
    @Override
    public String getVidas(){ return "3"; }

    /**
     * Notifica al modelo que el jugador tiene 3 vidas al entrar a este estado.
     * @param modelo Modelo del juego.
     */
    public void entrar(Modelo modelo){
        System.out.println("¡Tienes 3 vidas!");
        modelo.notificarCambioVidas(3);
    }

    /**
     * Descuenta una vida y transiciona al siguiente estado.
     * @param gestor Contexto de vidas.
     * @param modelo Modelo del juego.
     */
    public void perderVida(GestorVidas gestor, Modelo modelo){
        modelo.notificarError(2);
        gestor.cambiarEstado(new Estado2Vidas());

    }
}
