package State;

import Modelo;

/**
 * Estado que representa el estado de juego cuando el jugador tiene 0 vidas restantes.
 */
public class Estado0Vidas implements EstadoVidas {

    /**
     * Obtiene el numero de vidas restantes.
     * @return el numero de vidas restantes.
     */
    @Override
    public String getVidas(){ return "0"; }

    /**
     * Notifica al modelo que el jugador tiene 0 vidas al entrar a este estado.
     * @param modelo Modelo del juego.
     */
    public void entrar(Modelo modelo){
        System.out.println("¡Te has quedado sin vidas! ¡GameOver! ");
        modelo.notificarCambioVidas(0);
        modelo.notificarGameOver();
    }

    /**
     * Descuenta una vida y transiciona al siguiente estado.
     * @param gestor Contexto de vidas.
     * @param modelo Modelo del juego.
     */
    public void perderVida(GestorVidas gestor, Modelo modelo){
        System.out.println("¡Te has quedado sin vidas!");
    }
    
}
