package MVC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Observer.SonidoObserver;
import Observer.VistaObserver;
import Strategy.DificultadMedia;

import java.io.IOException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void iniciarJuego(ActionEvent event) {

        System.out.println("¡Botón presionado! Iniciando partida...");
        
        // 1. Instanciamos los componentes de MVC (lo que tenías en EcoCheems.java)
        Modelo modelo = new Modelo();
        Vista vista = new Vista();

        // 2. Por ahora le asignamos una dificultad por defecto directamente
        modelo.setDificultad(new DificultadMedia()); 
        
        // 3. Agregamos los observadores
        modelo.agregarObservador(new SonidoObserver());
        modelo.agregarObservador(new VistaObserver(vista));
        
        // 4. Creamos el controlador e iniciamos el juego
        Controlador controlador = new Controlador(modelo, vista);
        controlador.iniciarPartida();
    }

    /**
     * Cambia a la pantalla de "Importancia" (Mensaje educativo).
     * Se activa desde el botón 'Continuar' de la Bienvenida.
     */
    @FXML
    public void switchToMensaje(ActionEvent event) throws IOException {
        cambiarEscena(event, "/Mensaje.fxml");
    }

    /**
     * Cambia al "Menú Principal".
     * Se activa desde el botón 'Continuar' de la Importancia.
     */
    @FXML
    public void switchToMenu(ActionEvent event) throws IOException {
        cambiarEscena(event, "/MenuPrincipal.fxml");
    }

    /**
     * Cambia a la pantalla de "Juego".
     * Se activa desde 'Iniciar Partida' en el Menú Principal.
     */
    @FXML
    public void switchToJuego(ActionEvent event) throws IOException {
        cambiarEscena(event, "/Juego.fxml");
    }

    /**
     * Método auxiliar para no repetir código de carga de FXML.
     */
    private void cambiarEscena(ActionEvent event, String fxmlFile) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlFile));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void salir(ActionEvent event) {
        System.exit(0);
    }
}