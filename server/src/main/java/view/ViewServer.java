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
public class ViewServer {
    public Stage window;
    // Escenas
    Scene mainMenu, login;
    // Paneles
    StackPane panelPrincipal;
    StackPane panelLogin;
    VBox contenedorLoginPassWord;

    // Botones
    public Button welcome;
    public Button submit;
    // TextField
    public TextField usuario;
    public TextField password;
    // Imagenes
    ImageView logo;
    Image picture = new Image("file:server\\src\\main\\java\\images\\logoUPB.png");
    Image fondoImagen = new Image("file:server\\src\\main\\java\\images\\IMAGENQUESIRVE.jpg");
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
    BackgroundImage backgroundImage = new BackgroundImage(fondoImagen,
            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

    Background fondo = new Background(backgroundImage);

    public ViewServer() {
        window = new Stage();
        start();
    }

    private void start() {
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
        logo.setFitHeight(320); // Alto
        logo.setFitWidth(280); // Ancho
        // -----------
        panelPrincipal.setBackground(fondo);
        // -------------------------

        rectangleStart.toBack();
        rectangleStart.setFill(colorBeige);
        rectangleStart.setStroke(Color.BLACK); // Color del borde
        rectangleStart.setStrokeWidth(1); // Grosor del borde

        //
        welcome.setOnAction(event -> {
            login();

        });

        // Organizando items
        panelPrincipal.setMargin(welcome, new Insets(225, 0, 0, 0)); // establecer un margen
                                                                     // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelPrincipal.setMargin(logo, new Insets(0, 0, 125, 0)); // establecer un margen
                                                                  // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)

        mainMenu = new Scene(panelPrincipal, 1080, 720);
        // mainMenu.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        window.setScene(mainMenu);
        window.setTitle("Oasis"); // Estableciendo titulo
        window.show();
    }

    public  void login() {

        // Crear Panel
        panelLogin = new StackPane();
        // ------------
        contenedorLoginPassWord = new VBox();
        contenedorLoginPassWord.setSpacing(75);
        contenedorLoginPassWord.setAlignment(Pos.CENTER);

        // Crear los objetos
        usuario = new TextField();
        password = new TextField();
        // --------------------------
        usuarioLabel = new Label("Usuario: ");
        contrasenaLabel = new Label("Contraseña: ");

        // --------------------------
        rectangleLogin = new Rectangle(350, 180);

        // Agregando elementos
        contenedorLoginPassWord.getChildren().addAll(usuario, password);
        panelLogin.getChildren().addAll(logo, rectangleStart, contenedorLoginPassWord, usuarioLabel, contrasenaLabel,
                rectangleLogin, submit);

        // Propiedades

        logo.setFitHeight(320); // Alto
        logo.setFitWidth(280); // Ancho
        // -------------------------
        panelLogin.setBackground(fondo);
        // -------------------------
        rectangleLogin.toBack();
        rectangleLogin.setFill(colorOrange);
        // ----------------------
        rectangleStart.toBack();
        rectangleStart.setFill(colorBeige);
        // -------------------------
        usuario.setPrefWidth(10);
        usuario.setPrefHeight(5);
        // ------------------------
        password.setPrefWidth(10);
        password.setPrefHeight(5);
        // ------------------------
        usuarioLabel.setFont(new Font(20));
        contrasenaLabel.setFont(new Font(20));
        // -------------------------
        submit.setScaleX(2);
        submit.setScaleY(2);

        // HACER USO DE JSON PARA VERIFICAR DATOS Y ENTONCES DAR CREACION A MODULOS

        // Organizando usuario y contraseña
        panelLogin.setMargin(contenedorLoginPassWord, new Insets(0, 250, 0, 525));// establecer un margen
                                                                                  // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelLogin.setMargin(logo, new Insets(0, 375, 0, 0)); // establecer un margen (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelLogin.setMargin(usuarioLabel, new Insets(0, 0, 150, 50)); // establecer un margen
                                                                       // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelLogin.setMargin(contrasenaLabel, new Insets(50, 0, 0, 75)); // establecer un margen
                                                                         // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelLogin.setMargin(rectangleLogin, new Insets(0, 0, 0, 285)); // establecer un margen
                                                                        // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelLogin.setMargin(submit, new Insets(300, 0, 0, 285)); // establecer un margen
                                                                  // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)

        login = new Scene(panelLogin, 1080, 720);
        // login.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        window.setScene(login);

    }
}