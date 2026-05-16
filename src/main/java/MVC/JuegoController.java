package MVC;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Factory.ObjetoBasura;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Observer.EventoJuegoObserver;

import java.io.IOException;
import java.io.InputStream;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import Observer.*; 

/**
 * Clase controladora de la interfaz gráfica (Vista) para la pantalla principal del juego EcoCheems.
 * <p>
 * Se encarga de gestionar los componentes visuales definidos en el archivo FXML, interceptar 
 * las interacciones del usuario (clics en los botes) y actualizar los elementos en pantalla 
 * (puntuación, vidas, ronda y la imagen del residuo) reflejando el estado real del modelo.
 * </p>
 * * @author TuNombre o Equipo de Desarrollo
 * @version 1.0
 */
public class JuegoController {

    /** Etiqueta que despliega el nombre del residuo actual en pantalla. */
    @FXML private Label labelNombreBasura; 
    
    /** Etiqueta que muestra el número de la ronda actual. */
    @FXML private Label labelRonda;
    
    /** Etiqueta que muestra la cantidad de vidas restantes del jugador. */
    @FXML private Label labelVidas;
    
    /** Etiqueta que muestra el puntaje acumulado durante la partida. */
    @FXML private Label labelPuntos;
    
    /** Contenedor de imagen donde se renderiza visualmente el residuo actual. */
    @FXML private ImageView imagenBasura;
    
    /** Etiqueta de la pantalla final (GameOver) que exhibe el puntaje total obtenido. */
    @FXML private Label labelPuntajeFinal;
    
    /** Etiqueta que notifica en tiempo real si el jugador desbloqueó algún logro. */
    @FXML private Label labelLogro;

    /** Referencia al modelo de datos que contiene el estado del juego. */
    private Modelo modelo;
    
    /** Referencia al controlador de la lógica interna del negocio. */
    private Controlador controladorLogico;

    /**
     * Inicializa el estado del juego vinculando el modelo y configurando las acciones del controlador gráfico.
     * <p>
     * Este método se invoca externamente al cambiar de pantalla. Realiza las siguientes operaciones:
     * <ul>
     * <li>Instancia el {@link Controlador} lógico del juego.</li>
     * <li>Dispara los observadores internos del sistema (sonido, estadísticas, etc.).</li>
     * <li>Registra un observador anónimo de tipo {@link EventoJuegoObserver} para reaccionar e interactuar con la UI ante aciertos, errores y logros.</li>
     * <li>Ejecuta la primera actualización visual de la pantalla.</li>
     * </ul>
     * </p>
     *
     * @param modelo El objeto {@link Modelo} que mantendrá los datos y lógica de la sesión de juego.
     */
    public void inicializarJuego(Modelo modelo) {
        this.modelo = modelo;
        this.controladorLogico = new Controlador(modelo);
        
        // 1. DISPARAMOS LOS OBSERVADORES INTERNOS (Sonido, Estadísticas, Detección de Logros)
        this.controladorLogico.configurarObservadores();
        
        // Observador en tiempo real para la interfaz gráfica
        this.modelo.agregarObservador(new EventoJuegoObserver() {
            @Override
            public void acierto(int puntosGanados, int rachaActual) {
                if (rachaActual != 3 && rachaActual != 6 && rachaActual != 9) {
                    if (labelLogro != null) labelLogro.setText(""); 
                }
            }

            @Override
            public void error(int vidasRestantes) {
                if (labelLogro != null) labelLogro.setText(""); 
            }

            @Override
            public void logroDesbloqueado(String nombreLogro) {
                labelLogro.setText("¡Logro obtenido!: " + nombreLogro);
            }

            @Override
            public void cambioDificultad(String nombreDificultad) {}
            @Override
            public void nuevoRecord(int nuevoRecord) {}
        });

        actualizarPantalla(); // Muestra la primera basura
    }

    /**
     * Evento desencadenado al hacer clic en el bote de residuos Orgánicos (ID/Número: 1).
     */
    @FXML public void clicBoteOrganico() { procesarTurno(1); }
    
    /**
     * Evento desencadenado al hacer clic en el bote de residuos Inorgánicos (ID/Número: 2).
     */
    @FXML public void clicBoteInorganico() { procesarTurno(2); }
    
    /**
     * Evento desencadenado al hacer clic en el bote de residuos de Papel y Cartón (ID/Número: 3).
     */
    @FXML public void clicBotePapel() { procesarTurno(3); }
    
    /**
     * Evento desencadenado al hacer clic en el bote de residuos Metálicos (ID/Número: 4).
     */
    @FXML public void clicBoteMetales() { procesarTurno(4); }
    
    /**
     * Evento desencadenado al hacer clic en el bote de residuos de Vidrio (ID/Número: 5).
     */
    @FXML public void clicBoteVidrio() { procesarTurno(5); }

    /**
     * Procesa la jugada del usuario evaluando la selección del contenedor.
     * <p>
     * Se encarga de enviar la respuesta al controlador lógico, validar si se cumplen las 
     * condiciones de finalización de partida (pérdida de vidas o fin de rondas según la dificultad) 
     * y decidir si se transiciona a la pantalla final o si se refresca la interfaz para un nuevo turno.
     * </p>
     *
     * @param numeroBote El identificador numérico correspondiente al contenedor seleccionado.
     */
    private void procesarTurno(int numeroBote) {
        controladorLogico.evaluarBoteSeleccionado(numeroBote);

        int maxRondas = modelo.getDificultad().getCantidadResiduos(); //Aqui falta modificar para que cambie en base a la dificultad
        
        if (modelo.isGameOver() || modelo.getRondaActual() > maxRondas) {
            mostrarPantallaFinal();
        } else {
            // Actualizamos la imagen y los textos para la siguiente ronda
            actualizarPantalla();
        }
    }

    /**
     * Sincroniza y actualiza todos los componentes visuales de la interfaz de juego.
     * <p>
     * Extrae la información actualizada del modelo (ronda, vidas, puntos) y recupera la 
     * instancia de {@link ObjetoBasura} en juego a través de la lógica interna para cargar 
     * dinámicamente tanto su nombre de texto como su archivo de imagen desde los recursos del sistema.
     * </p>
     */
    public void actualizarPantalla() {
        // 1. Actualizamos los textos básicos de la interfaz
        labelRonda.setText("Ronda: " + modelo.getRondaActual());
        
        // CORREGIDO: Ahora llamamos a .getVidas() del estado actual
        labelVidas.setText("Vidas: " + modelo.getVidasActuales().getVidas()); 
        
        labelPuntos.setText("Puntos: " + modelo.getPuntuacion());

        // 2. OBTENEMOS EL OBJETO DE BASURA DE LA RONDA ACTUAL
        ObjetoBasura basuraActual = controladorLogico.getBasuraActual();

        if (basuraActual != null) {
            // 3. CAMBIAMOS EL TEXTO dinámicamente con el nombre de ese objeto
            labelNombreBasura.setText(basuraActual.getNombre());

            try {
                String ruta = basuraActual.getRutaImagen(); 
                InputStream is = getClass().getResourceAsStream(ruta);
                
                if (is != null) {
                    Image nuevaImagen = new Image(is);
                    imagenBasura.setImage(nuevaImagen);
                } else {
                    System.out.println("[Error] No se encontró la imagen en la ruta: " + ruta);
                }
            } catch (Exception e) {
                System.out.println("[Error] Al cargar la imagen: " + e.getMessage());
            }
        }
    }

    /**
     * Carga y despliega la vista de juego terminado (GameOver).
     * <p>
     * Reutiliza la misma instancia controladora para inyectar los datos requeridos por la 
     * pantalla de finalización (como el puntaje acumulado definitivo) y realiza el cambio de 
     * escena (Scene) en la ventana (Stage) actual.
     * </p>
     */
    private void mostrarPantallaFinal() {
        try {
            // 1. Creamos el cargador
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameOver.fxml"));
            
            loader.setController(this); 
            
            Parent root = loader.load();

            if (labelPuntajeFinal != null) {
                labelPuntajeFinal.setText("Puntuación Final: " + modelo.getPuntuacion() + " puntos");
            }

            Stage stage = (Stage) imagenBasura.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Error al cargar la pantalla de Juego Terminado:");
            e.printStackTrace();
        }
    }

    /**
     * Gestiona la acción de regresar a la pantalla principal del juego desde la interfaz de Game Over.
     *
     * @param event El evento de acción {@link ActionEvent} gatillado por el clic del botón.
     */
    @FXML
    public void volverAlMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/MenuPrincipal.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al regresar al menú principal:");
            e.printStackTrace();
        }
    }
}
