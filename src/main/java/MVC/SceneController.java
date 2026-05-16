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
    private Modelo modelo = new Modelo(); 

    @FXML
    public void iniciarJuego(ActionEvent event) {

        try {
            // 1. Cargar el archivo FXML de la pantalla de juego
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Juego.fxml"));
            Parent root = loader.load();

            // 2. Obtener el controlador de la pantalla de juego
            // (Esto ya no será nulo porque arreglaste el fx:controller en el paso anterior)
            JuegoController juegoController = loader.getController();

            // 3. Inicializar el juego enviándole tu Modelo
            juegoController.inicializarJuego(this.modelo);

            // 4. Obtener la ventana actual y cambiar la escena a la del Juego
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Error al cargar la pantalla de juego:");
            e.printStackTrace();
        }
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