import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal del juego EcoCheems con JavaFX.
 * Es el punto de entrada de la aplicación gráfica.
 */
public class EcoCheems extends Application {

    /**
     * El método start es el verdadero "main" en JavaFX.
     * Aquí cargamos la ventana principal diseñada en Scene Builder.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carga el archivo FXML de tu menú principal (asegúrate de que exista en src/main/resources)
        Parent root = FXMLLoader.load(getClass().getResource("/Bienvenida.fxml"));
        
        // Creamos la escena con el diseño cargado
        Scene scene = new Scene(root);
        
        // Configuramos la ventana (Stage)
        primaryStage.setTitle("EcoCheems - ¡A reciclar!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // Opcional: evita que cambien el tamaño de la ventana
        primaryStage.show();
    }

    /**
     * El método main tradicional ahora solo sirve para disparar JavaFX.
     */
    public static void main(String[] args) {
        launch(args);
    }
}