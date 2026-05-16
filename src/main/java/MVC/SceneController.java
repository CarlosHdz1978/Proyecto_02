package MVC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox; 
import Observer.SonidoObserver;
import Observer.VistaObserver;
import Strategy.*;

import java.io.IOException;

/**
 * Clase controladora encargada de la navegación y el flujo de pantallas (escenas) en la aplicación.
 * <p>
 * Administra el intercambio de vistas de JavaFX (FXML) como el menú principal, las instrucciones, 
 * los mensajes educativos y el inicio de la partida. Además, inicializa y asume la configuración 
 * de la estrategia de dificultad seleccionada por el usuario antes de arrancar el juego.
 * </p>
 * * @author TuNombre o Equipo de Desarrollo
 * @version 1.0
 */
public class SceneController {

    /** El escenario principal (ventana) sobre el cual se montan las escenas. */
    private Stage stage;
    
    /** La escena activa que contiene el árbol de nodos de la interfaz gráfica. */
    private Scene scene;
    
    /** El nodo raíz cargado desde los archivos FXML para estructurar los elementos visuales. */
    private Parent root;
    
    /** Instancia global del modelo de datos que se compartirá e inyectará hacia la pantalla de juego. */
    private Modelo modelo = new Modelo();

    /** Componente de selección desplegable en la interfaz para determinar la dificultad de la partida. */
    @FXML private ComboBox<String> comboDificultad;

    /**
     * Inicializa los componentes de la interfaz de usuario de manera automática tras cargar el FXML.
     * <p>
     * Se encarga de poblar el componente {@code comboDificultad} con las opciones de juego 
     * ("Fácil", "Medio", "Difícil") y predefinir un valor inicial por defecto.
     * </p>
     */
    @FXML
    public void initialize() {
        if (comboDificultad != null) {
            comboDificultad.getItems().addAll("Fácil", "Medio", "Difícil");
            comboDificultad.setValue("Fácil"); //Por defecto
        }
    }

    /**
     * Procesa la configuración de la partida e inicia la transición hacia la pantalla principal del juego.
     * <p>
     * Este método lee la opción seleccionada en el menú desplegable, aplica el patrón de diseño 
     * <i>Strategy</i> instanciando la dificultad correspondiente ({@link DificultadFacil}, 
     * {@link DificultadMedia} o {@link DificultadDificil}) en el modelo, carga la vista {@code Juego.fxml}, 
     * e inyecta el estado actual del modelo al {@link JuegoController}.
     * </p>
     *
     * @param event El evento de acción {@link ActionEvent} provocado al presionar el botón de inicio.
     */
    @FXML
    public void iniciarJuego(ActionEvent event) {
        try {
            // 2. Revisamos qué dificultad seleccionó el usuario en la interfaz
            String dificultadSeleccionada = comboDificultad.getValue();
            
            // 3. Aplicamos el patrón Strategy en base a la selección
            switch (dificultadSeleccionada) {
                case "Fácil":
                    modelo.setDificultad(new DificultadFacil());
                    break;
                case "Medio":
                    modelo.setDificultad(new DificultadMedia());
                    break;
                case "Difícil":
                    modelo.setDificultad(new DificultadDificil());
                    break;
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Juego.fxml"));
            Parent root = loader.load();

            JuegoController juegoController = loader.getController();

            juegoController.inicializarJuego(this.modelo);

            //Obtener la ventana actual y cambiar la escena a la del Juego
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
     * Cambia la escena actual a la pantalla de "Importancia" (Mensaje educativo).
     * <p>
     * Comúnmente se activa mediante la interacción con el botón 'Continuar' desde la pantalla de Bienvenida.
     * </p>
     *
     * @param event El evento de acción {@link ActionEvent} que desencadena el cambio.
     * @throws IOException Si ocurre un error al intentar leer o cargar el archivo FXML correspondiente.
     */
    @FXML
    public void switchToMensaje(ActionEvent event) throws IOException {
        cambiarEscena(event, "/Mensaje.fxml");
    }

    /**
     * Cambia la escena actual a la pantalla del "Menú Principal".
     * <p>
     * Comúnmente se activa mediante la interacción con el botón 'Continuar' desde la pantalla de Importancia.
     * </p>
     *
     * @param event El evento de acción {@link ActionEvent} que desencadena el cambio.
     * @throws IOException Si ocurre un error al intentar leer o cargar el archivo FXML correspondiente.
     */
    @FXML
    public void switchToMenu(ActionEvent event) throws IOException {
        cambiarEscena(event, "/MenuPrincipal.fxml");
    }

    /**
     * Cambia la escena actual directamente a la pantalla de "Juego" sin procesar configuraciones previas.
     * <p>
     * Se activa desde la interacción con el botón 'Iniciar Partida' en el Menú Principal.
     * </p>
     *
     * @param event El evento de acción {@link ActionEvent} que desencadena el cambio.
     * @throws IOException Si ocurre un error al intentar leer o cargar el archivo FXML correspondiente.
     */
    @FXML
    public void switchToJuego(ActionEvent event) throws IOException {
        cambiarEscena(event, "/Juego.fxml");
    }

    /**
     * Cambia la escena actual a la pantalla de "Instrucciones".
     * <p>
     * Se activa desde la interacción con el botón 'Instrucciones' en el Menú Principal.
     * </p>
     *
     * @param event El evento de acción {@link ActionEvent} que desencadena el cambio.
     * @throws IOException Si ocurre un error al intentar leer o cargar el archivo FXML correspondiente.
     */
    @FXML
    public void switchToInstrucciones(ActionEvent event) throws IOException {
        cambiarEscena(event, "/Instrucciones.fxml");
    }

    /**
     * Método auxiliar genérico para centralizar y optimizar la carga de archivos FXML.
     * <p>
     * Evita la duplicación de código abstrayendo la lógica necesaria para obtener la ventana 
     * actual (Stage), inicializar la nueva vista (Parent) y renderizar la nueva escena (Scene).
     * </p>
     *
     * @param event    El evento de acción que provee el nodo de origen para recuperar el Stage.
     * @param fxmlFile La ruta relativa del recurso FXML que se desea cargar (ej: "/Mensaje.fxml").
     * @throws IOException Si el recurso FXML especificado en la ruta no puede ser localizado o leído.
     */
    private void cambiarEscena(ActionEvent event, String fxmlFile) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlFile));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Finaliza la ejecución completa de la aplicación de manera inmediata.
     * <p>
     * Se vincula a botones de cierre o salida dentro de la interfaz gráfica.
     * </p>
     *
     * @param event El evento de acción {@link ActionEvent} que gatilla el cierre.
     */
    @FXML
    public void salir(ActionEvent event) {
        System.exit(0);
    }
}