package State;

import EcoChemsModelo;

/**
 * Estado que representa el estado de juego cuando el jugador tiene 2 vidas restantes.
 */
public class Estado2Vidas implements EstadoVidas {
    
    /**
     * Obtiene el numero de vidas restantes.
     * @return el numero de vidas restantes.
     */
    @Override
    public String getVidas(){ return "2"; }

    /**
     * Notifica al modelo que el jugador tiene 2 vidas al entrar a este estado.
     * @param modelo Modelo del juego.
     */
    public void entrar(Modelo modelo){
        System.out.println("¡Tienes 2 vidas!");
        modelo.notificarCambioVidas(2);
    }

    /**
     * Descuenta una vida y transiciona al siguiente estado.
     * @param gestor Contexto de vidas.
     * @param modelo Modelo del juego.
     */
    public void perderVida(GestorVidas gestor, Modelo modelo){
        modelo.notificarError(1);
        gestor.cambiarEstado(new Estado1Vida());

    }


}
