package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class that represents the whole 'moduleOperador' view
 * 
 * @author Juan David Patiño Parra
 */
public class ViewOperador {
    public Stage window;
    // Escenas
    public Scene optionPanel;
    //
    public Scene clientesView;
    public Scene agregarClienteView;
    public Scene buscarEstudianteView;
    //
    public Scene menuView;
    public Scene confirmarPedidoView;
    // Scene RutasView;

    // Paneles
    StackPane panelPrincipal;

    //
    StackPane panelPrincipalClientes;
    StackPane panelAgregarClientes;

    // Menu
    StackPane panelPrincipalMenu;
    ScrollPane scrollerDeMenu;
    public Button goBackToOptions;
    public Button confirmarPedido;
    public TextField barraDeBusqueda;
    // --

    // --
    public Button sendPedidoToCocinaButton;
    public Button backToMenu;
    // ----

    // ---
    public ListView<String> listOfInfoEstudiante;
    public ObservableList<String> informacionEstudiante;
    // ---

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
    public TextField cliente;
    public TextField direccion;
    public ComboBox<String> barrio;
    public TextField telefono;

    // TextField

    public TextField idEstudianteTextLabel;
    public Button buttonAgregarCita;
    // Imagenes
    ImageView logo;
    ImageView logoClientes;
    Image picture = new Image("file:src\\main\\java\\images\\logoUPB.png");
    Image fondoImagen = new Image("file:src\\main\\java\\images\\IMAGENQUESIRVE.jpg");
    ImageView fondoUPB = new ImageView(fondoImagen);

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
    BackgroundImage backgroundImage = new BackgroundImage(fondoImagen,
            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

    Background fondo = new Background(backgroundImage);

    public ViewOperador() {
        // -----------------------
        // -----------------------
        window = new Stage();
        goBack = new Button("Atras");
        goBack.setId("buttonBack");
        logo = new ImageView(picture);
        logoClientes = new ImageView(picture);
        initOperador();
        initAgregarCita();
        //intiCancelarCita();
        // initAgregarEstudiante();
        // initBuscarCliente();
        // initShowMenu();
        // initShowConfirmarPedido();
    }

    public void initOperador() {
        // Crear Panel
        panelPrincipal = new StackPane();
        selector = new HBox();

        selector.setSpacing(150); // Ajusta la separación horizontal
        // Crear los objetos
        addCitaButton = new Button("Agregar Cita");
        cancelarCitaButton = new Button("Cancelar Cita");
        // -----------
        rectangleToDecorate = new Rectangle(700, 400);
        // Agregando elementos
        selector.getChildren().addAll(addCitaButton, cancelarCitaButton);
        selector.setAlignment(Pos.CENTER);
        panelPrincipal.getChildren().addAll(logo, rectangleToDecorate, selector);

        // Propiedades
        addCitaButton.setScaleY(2);
        addCitaButton.setScaleX(2);
        cancelarCitaButton.setScaleY(2);
        cancelarCitaButton.setScaleX(2);
        // -----------
        logo.setFitHeight(80); // Alto
        logo.setFitWidth(80); // Ancho
        // -----------
        panelPrincipal.setBackground(fondo);
        // -------------------------
        rectangleToDecorate.setFill(colorBeige);
        rectangleToDecorate.setStroke(Color.BLACK); // Color del borde
        rectangleToDecorate.setStrokeWidth(1); // Grosor del borde
        rectangleToDecorate.toBack();
        //

        // Organizando items
        panelPrincipal.setMargin(logo, new Insets(0, 0, 125, 0)); // establecer un margen
                                                                  // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelPrincipal.setAlignment(selector, Pos.CENTER); // establecer un margen (ABAJO,IZQUIERDA,ARRIBA,DERECHA)

        optionPanel = new Scene(panelPrincipal, 1080, 720);
        // optionPanel.getStylesheets().add("style.css");
        window.setScene(optionPanel);
        window.setTitle("CAC-UPB"); // Estableciendo titulo
        window.show();

    }

    public void initAgregarCitass() {
        panelPrincipalClientes = new StackPane();
        panelPrincipalClientes.setBackground(fondo);
        // -------------------------
        buscarClienteButton = new Button("Buscar Cliente");
        agregarClienteButton = new Button("Agregar Cliente");
        rectangleToDecorateClientes = new Rectangle(700, 400);

        // Propiedades
        goBack.setScaleX(2.5);
        goBack.setScaleY(2.5);
        buscarClienteButton.setScaleX(2);
        buscarClienteButton.setScaleY(2);

        agregarClienteButton.setScaleX(2);
        agregarClienteButton.setScaleY(2);

        // -------------------------
        rectangleToDecorateClientes.setFill(colorBeige);
        rectangleToDecorateClientes.setStroke(Color.BLACK); // Color del borde
        rectangleToDecorateClientes.setStrokeWidth(1); // Grosor del borde
        rectangleToDecorateClientes.toBack();

        panelPrincipalClientes.getChildren().addAll(logo, rectangleToDecorateClientes, buscarClienteButton,
                agregarClienteButton, goBack);
        //
        panelPrincipalClientes.setMargin(buscarClienteButton, new Insets(0, 0, 0, 250)); // establecer un margen
                                                                                         // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelPrincipalClientes.setMargin(agregarClienteButton, new Insets(0, 250, 0, 0)); // establecer un margen
                                                                                          // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        panelPrincipalClientes.setMargin(goBack, new Insets(500, 550, 0, 0)); // establecer un margen
                                                                              // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)

        clientesView = new Scene(panelPrincipalClientes, 1080, 720);
        // clientesView.getStylesheets().add("style.css");

        /*
         * window.setScene(clientesView);
         * window.setTitle("Oasis"); //Estableciendo titulo
         * window.show();
         */
    }

    public void initAgregarCita() {
        StackPane buscarClienteContendor = new StackPane();
        buscarClienteContendor.setBackground(fondo);
        // -------------------------
        goBackToOption = new Button("Atras");
        goBackToOption.setId("buttonBack");
        busquedaDeEstudiantes = new TextField("Buscar Estudiante");
        Rectangle rectangleToDecorateBuscadorDeClientes = new Rectangle(700, 400);
        estudiantesFounded = FXCollections.observableArrayList();

        // Crear un ListView y configurarlo con la lista observable
        estudiantesFoundedList = new ListView<>(estudiantesFounded);
        // Propiedades
        goBackToOption.setScaleX(2.5);
        goBackToOption.setScaleY(2.5);

        busquedaDeEstudiantes.setPrefHeight(10);
        busquedaDeEstudiantes.setPrefWidth(400);

        estudiantesFoundedList.setPrefHeight(40);
        estudiantesFoundedList.setPrefWidth(40);

        // AGREGAR CITAS
        idEstudianteTextLabel = new TextField("Id");
        buttonAgregarCita = new Button("Agendar Cita");

        buttonAgregarCita.setScaleX(2.2);
        buttonAgregarCita.setScaleY(2.2);

        idEstudianteTextLabel.setPrefHeight(10);
        idEstudianteTextLabel.setPrefWidth(300);
        buscarClienteContendor.getChildren().addAll(idEstudianteTextLabel, buttonAgregarCita);
        // .-------
        buscarClienteContendor.setMargin(buttonAgregarCita, new Insets(300, 0, 0, 500)); // establecer un margen
        // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        buscarClienteContendor.setMargin(idEstudianteTextLabel, new Insets(200, 300, 300, 650)); // establecer un margen
        // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        // -------------------------
        rectangleToDecorateBuscadorDeClientes.setFill(colorBeige);
        rectangleToDecorateBuscadorDeClientes.setStroke(Color.BLACK); // Color del borde
        rectangleToDecorateBuscadorDeClientes.setStrokeWidth(1); // Grosor del borde
        rectangleToDecorateBuscadorDeClientes.toBack();
        buscarClienteContendor.getChildren().addAll(estudiantesFoundedList);
        buscarClienteContendor.getChildren().addAll(rectangleToDecorateBuscadorDeClientes, goBackToOption,
                busquedaDeEstudiantes);
        //
        buscarClienteContendor.setMargin(busquedaDeEstudiantes, new Insets(300, 500, 400, 300)); // establecer un margen
        // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        buscarClienteContendor.setMargin(estudiantesFoundedList, new Insets(350, 500, 200, 300)); // establecer un
                                                                                                  // margen
        // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        buscarClienteContendor.setMargin(goBackToOption, new Insets(500, 550, 0, 0)); // establecer un margen
        // (ABAJO,IZQUIERDA,ARRIBA,DERECHA)
        estudiantesFoundedList.toFront();
        idEstudianteTextLabel.toFront();
        buttonAgregarCita.toFront();
        buscarEstudianteView = new Scene(buscarClienteContendor, 1080, 720);
        // buscarEstudianteView.getStylesheets().add("style.css");
    }

    public void intiCancelarCita() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CANCELACION");
        alert.setHeaderText("CITA CANCELADA ");
        alert.setContentText(
                "TASDFAGASDHGSAHH!" + "\n"
                        + "...");
        alert.showAndWait();
    }

    public void switchScene(Scene scene) {
        window.setScene(scene);
    }
}