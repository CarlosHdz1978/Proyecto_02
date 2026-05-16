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

import java.io.InputStream;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class JuegoController {

    @FXML private Label labelNombreBasura; 
    @FXML private Label labelRonda;
    @FXML private Label labelVidas;
    @FXML private Label labelPuntos;
    @FXML private ImageView imagenBasura;

    private Modelo modelo;
    private Controlador controladorLogico;

    // Este método se llamará desde la pantalla anterior para pasar el modelo
    public void inicializarJuego(Modelo modelo) {
        this.modelo = modelo;
        this.controladorLogico = new Controlador(modelo);
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

        int maxRondas = 10; //Aqui falta modificar para que cambie en base a la dificultad
        
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameOver.fxml"));
            Parent root = loader.load();

            // 2. (Opcional) Si quieres pasarle los puntos obtenidos a la pantalla final para mostrarlos:
            // GameOverController gameOverController = loader.getController();
            // gameOverController.enviarPuntuacionFinal(modelo.getPuntuacion());

            Stage stage = (Stage) imagenBasura.getScene().getWindow();
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Error al cargar la pantalla de Juego Terminado:");
            e.printStackTrace();
        }
    }
    
}
