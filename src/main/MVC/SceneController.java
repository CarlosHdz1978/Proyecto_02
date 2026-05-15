package main.MVC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Cambia a la pantalla de "Importancia" (Mensaje educativo).
     * Se activa desde el botón 'Continuar' de la Bienvenida.
     */
    @FXML
    public void switchToImportancia(ActionEvent event) throws IOException {
        cambiarEscena(event, "/Importancia.fxml");
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