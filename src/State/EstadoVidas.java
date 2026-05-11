package State;

import Modelo;

/**
 * Interfaz que define los comportamientos según el numero de vidas restantes. 
 */
public interface EstadoVidas {

    /**
     * Obtiene el numero de vidas restantes.
     * @return el numero de vidas restantes.
     */
    public String getVidas();

    /**
     * Notifica el cambio de vidas a la vista y al modelo.
     * @param modelo Modelo del juego.
     */
    public abstract void entrar(Modelo modelo);

    /**
     * Descuenta una vida y transiciona al siguiente estado.
     * @param gestor Contexto de vidas.
     * @param modelo Modelo del juego.
     */
    public abstract void perderVida(GestorVidas gestor, Modelo modelo);


}