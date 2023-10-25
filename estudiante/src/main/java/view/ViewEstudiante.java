package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * Class which creates the start view
 * 
 * @author Juan David Patiño
 *
 */
public class ViewEstudiante {
    public Stage window;
    // Escenas
    Scene mainMenu, login;
    // Paneles
    StackPane panelPrincipal;
    StackPane panelLogin;
    VBox contenedorLoginPassWord;

    // Botones
    Button welcome;
    public Button submit;
    // TextField
    public TextField usuario;
    public TextField password;
    // Imagenes
    ImageView logo;
    Image picture = new Image("file:estudiante\\src\\main\\java\\images\\logoUPB.png");
    Image fondoImagen = new Image("file:estudiante\\src\\main\\java\\images\\IMAGENQUESIRVE.jpg");
    ImageView fondoUPB = new ImageView(fondoImagen);

    // LABELS(TEXTO EN PANTALLA)
    Label usuarioLabel;
    Label contrasenaLabel;

    // Figuras
    Rectangle rectangleStart;
    Rectangle rectangleLogin;

    // Colores
    String beige = "#FFECBB";
    Color colorBeige = Color.web(beige);
    //
    String sand = "#FFC93E";
    Color colorSand = Color.web(sand);
    //
    String orange = "#FF9900";
    Color colorOrange = Color.web(orange);

    // Image image = new Image("file:/ruta/a/tu/imagen.png");
    // Background
    BackgroundFill colorFondo = new BackgroundFill(colorSand, null, null);
    BackgroundImage backgroundImage = new BackgroundImage(fondoImagen,
            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

    Background fondo = new Background(backgroundImage);
    public ViewEstudiante() {
        window = new Stage();
        initVerCitas();
    }

    private void initVerCitas() {
        // Crear Panel
        panelPrincipal = new StackPane();
        // Crear los objetos
        welcome = new Button("Welcome!");
        // ---------------------
        submit = new Button("Ingresar!");
        // -----------
        logo = new ImageView(picture);
        // -----------
        rectangleStart = new Rectangle(700, 400);

        // Agregando elementos
        panelPrincipal.getChildren().addAll(welcome, logo, rectangleStart);

        // Propiedades
        welcome.setScaleY(2);
        welcome.setScaleX(2);
        // -----------
        logo.setFitHeight(240); // Alto
        logo.setFitWidth(220); // Ancho
        // -----------
        panelPrincipal.setBackground(fondo);
        // -------------------------

        rectangleStart.toBack();
        rectangleStart.setFill(colorBeige);
        rectangleStart.setStroke(Color.BLACK); // Color del borde
        rectangleStart.setStrokeWidth(1); // Grosor del borde

        //

        // Organizando items
        panelPrincipal.setMargin(welcome, new Insets(225, 0, 0, 0)); // establecer un margen
                                                                     // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelPrincipal.setMargin(logo, new Insets(0, 0, 125, 0)); // establecer un margen
                                                                  // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)

        mainMenu = new Scene(panelPrincipal, 1080, 720);
        // mainMenu.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        window.setScene(mainMenu);
        window.setTitle("CAC-UPB"); // Estableciendo titulo
        window.show();
    }
}