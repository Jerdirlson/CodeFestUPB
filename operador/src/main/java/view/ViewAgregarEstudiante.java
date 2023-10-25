package view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewAgregarEstudiante {
    public Stage window;
    // Escenas
    public Scene agregarClienteView;

    StackPane panelAgregarClientes;

    public ListView<String> estudiantesFoundedList;
    public ObservableList<String> estudiantesFounded;
    // ---

    // StackPane panelPrincipalRutas;
    HBox selector;

    // Botones
    public Button addCitaButton;
    public Button cancelarCitaButton;
    public Button pedidoButton;

    // Botones clientes
    public Button buscarClienteButton, agregarClienteButton;
    public Button goBack;

    // -----

    public Button goBackToClientes;
    public Button goBackToOption;

    public TextField busquedaDeEstudiantes;
    public Button confirmAddButton;

    // -----
    // nombreEstudiante, apellidoEstudiante, semestreEstudiante,
    // discapacidadEstudiante, password, emailEstudiante
    public TextField nombreEstudiante;
    public TextField apellidoEstudiante;
    public ComboBox<String> semestreEstudiante;
    public ComboBox<String> discapacidadEstudiante;
    public TextField passwordEstudiante;
    public TextField emailEstudiante;

    // TextField

    // Imagenes
    ImageView logo;
    ImageView logoClientes;
    Image picture = new Image("file:src\\\\main\\\\java\\\\images\\\\logoUPB.png");

    // Figuras
    Rectangle rectangleToDecorate;
    Rectangle rectangleToDecorateClientes;
    Rectangle rectangleToDecorateAddClientes;

    // Colores
    String beige = "#FFECBB";
    Color colorBeige = Color.web(beige);
    //
    String sand = "#FFC93E";
    Color colorSand = Color.web(sand);
    //
    String orange = "#FF9900";
    Color colorOrange = Color.web(orange);

    // Background
    BackgroundFill colorFondo = new BackgroundFill(colorSand, null, null);
    Background fondo = new Background(colorFondo);

    public ViewAgregarEstudiante() {
        window = new Stage();
        initAgregarEstudiante2();
    }

    public void initAgregarEstudiante2() {

        panelAgregarClientes = new StackPane();
        panelAgregarClientes.setBackground(fondo);

        rectangleToDecorateAddClientes = new Rectangle(700, 400);
        rectangleToDecorateAddClientes.setFill(colorBeige);
        rectangleToDecorateAddClientes.setStroke(Color.BLACK); // Color del borde
        rectangleToDecorateAddClientes.setStrokeWidth(1); // Grosor del borde
        rectangleToDecorateAddClientes.toBack();

        Label nombreLabel = new Label("Nombre: ");
        Label apellidoLablel = new Label("Apellido: ");
        Label semestreLabel = new Label("Semestre: ");
        Label discapacidadLabel = new Label("Discapacidad: ");
        Label passwordLabel = new Label("Contraseña: ");
        Label emailLabel = new Label("Email");
        // nombreEstudiante, apellidoEstudiante, semestreEstudiante,
        // discapacidadEstudiante, password, emailEstudiante
        nombreLabel.setFont(new Font(20));
        apellidoLablel.setFont(new Font(20));
        semestreLabel.setFont(new Font(20));
        discapacidadLabel.setFont(new Font(20));
        passwordLabel.setFont(new Font(20));
        emailLabel.setFont(new Font(20));

        nombreLabel.setId("labelsAddClient");
        apellidoLablel.setId("labelsAddClient");
        semestreLabel.setId("labelsAddClient");
        discapacidadLabel.setId("labelsAddClient");
        passwordLabel.setId("labelsAddClient");
        emailLabel.setId("labelsAddClient");

        // ----------------------------------
        nombreEstudiante = new TextField();
        apellidoEstudiante = new TextField();
        semestreEstudiante = new ComboBox<>();
        discapacidadEstudiante = new ComboBox<>();
        passwordEstudiante = new TextField();
        emailEstudiante = new TextField();

        // ----------------------------------

        confirmAddButton = new Button("Guardar Informacion");
        // ----------------------------------

        confirmAddButton.setScaleY(2);
        confirmAddButton.setScaleX(2);

        nombreEstudiante.setPrefWidth(10);
        nombreEstudiante.setPrefHeight(5);

        apellidoEstudiante.setPrefWidth(10);
        apellidoEstudiante.setPrefHeight(5);

        passwordEstudiante.setPrefWidth(10);
        passwordEstudiante.setPrefHeight(5);

        emailEstudiante.setPrefWidth(10);
        emailEstudiante.setPrefHeight(5);

        semestreEstudiante.setPrefWidth(10);
        semestreEstudiante.setPrefHeight(5);

        discapacidadEstudiante.setPrefWidth(400);
        discapacidadEstudiante.setPrefHeight(5);

        semestreEstudiante.setPrefWidth(400);
        semestreEstudiante.setPrefHeight(5);

        panelAgregarClientes.getChildren().addAll(rectangleToDecorateAddClientes, confirmAddButton);

        VBox contenedorLabelsAddCliente = new VBox();
        contenedorLabelsAddCliente.setSpacing(15);
        contenedorLabelsAddCliente.getChildren().addAll(nombreLabel, apellidoLablel, semestreLabel, discapacidadLabel,
                passwordLabel, emailLabel);

        VBox contenedorTextAddCliente = new VBox();
        contenedorTextAddCliente.setSpacing(20);
        contenedorTextAddCliente.getChildren().addAll(nombreEstudiante, apellidoEstudiante, semestreEstudiante,
                discapacidadEstudiante, passwordEstudiante, emailEstudiante);

        // ----------------------------------------------------------------------

        panelAgregarClientes.getChildren().addAll(contenedorLabelsAddCliente, contenedorTextAddCliente);

        panelAgregarClientes.setMargin(contenedorLabelsAddCliente, new Insets(250, 0, 0, 300));
        panelAgregarClientes.setMargin(contenedorTextAddCliente, new Insets(250, 300, 0, 400));
        panelAgregarClientes.setMargin(confirmAddButton, new Insets(600, 0, 0, 500));

        confirmAddButton.toFront();
        agregarClienteView = new Scene(panelAgregarClientes, 1080, 720);
        agregarClienteView.getStylesheets().add("style.css");

        window.setScene(agregarClienteView);
        window.setTitle("CAC-UPB"); // Estableciendo titulo
        window.show();
    }
}
