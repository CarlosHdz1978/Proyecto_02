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

public class JuegoController {

    @FXML private Label labelNombreBasura; 
    @FXML private Label labelRonda;
    @FXML private Label labelVidas;
    @FXML private Label labelPuntos;
    @FXML private ImageView imagenBasura;
    @FXML private Label labelPuntajeFinal;
    @FXML private Label labelLogro;

    private Modelo modelo;
    private Controlador controladorLogico;

    // Este método se llamará desde la pantalla anterior para pasar el modelo
    public void inicializarJuego(Modelo modelo) {
        this.modelo = modelo;
        this.controladorLogico = new Controlador(modelo);
        
        // 1. DISPARAMOS LOS OBSERVADORES INTERNOS (Sonido, Estadísticas, Detección de Logros)
        this.controladorLogico.configurarObservadores();
        
        // 2. CREAMOS UN OBSERVADOR EN TIEMPO REAL PARA LA INTERFAZ GRÁFICA (JavaFX)
        this.modelo.agregarObservador(new EventoJuegoObserver() {
            @Override
            public void acierto(int puntosGanados, int rachaActual) {
                if (rachaActual != 5 && rachaActual != 10 && rachaActual != 15) {
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

    // Métodos conectados a los clics de los 5 botes en Scene Builder
    @FXML public void clicBoteOrganico() { procesarTurno(1); }
    @FXML public void clicBoteInorganico() { procesarTurno(2); }
    @FXML public void clicBotePapel() { procesarTurno(3); }
    @FXML public void clicBoteMetales() { procesarTurno(4); }
    @FXML public void clicBoteVidrio() { procesarTurno(5); }

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
     * Acción para el botón de "Volver al Menú" dentro de GameOver.fxml (Opcional)
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
