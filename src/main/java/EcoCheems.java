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
        Parent root = FXMLLoader.load(getClass().getResource("/Bienvenida.fxml"));
        
        Scene scene = new Scene(root);
        
        // Configuracion ventana
        primaryStage.setTitle("EcoCheems");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); 
        primaryStage.show();
    }

    /**
     * El método main tradicional ahora solo sirve para disparar JavaFX.
     */
    public static void main(String[] args) {
        launch(args);
    }
}