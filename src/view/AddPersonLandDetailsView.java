package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.PersonDetails;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
public class AddPersonLandDetailsView {


    private final PersonDetails model;
    //Tiled panes to contain three Section of Info
    TitledPane personalInfoTitledpane = new TitledPane();
    TitledPane contactInfoTitledpane = new TitledPane();
    TitledPane landInfoTitledPane = new TitledPane();
    public String dateFormat;


    ImageView addPhotoImVw = new ImageView();
    Button addPhotoBTN = new Button();

    public Button saveBtn = new Button("Save");
    Button cancelBtn = new Button("Cancel");
    Label errorLabel = new Label();


    //Labels for Personal Information
    Label personIdLabel = new Label("");
    Label titleLabel = new Label("Title:                ");
    Label firstNameLabel = new Label("First Name:     ");
    Label lastNameLLabel = new Label("Last Name:      ");
    Label otherNamesLabel = new Label("Other Names: ");
    Label dobLabel = new Label("Date of Birth:  ");
    Label addressLabel = new Label("Address:         ");
    Label cityLabel = new Label("City:                ");
    Label countryLabel = new Label("Country:         ");

    //Labels for Contact Information
    Label idTypeLabel = new Label("ID Type:               ");
    Label idNumberLabel = new Label("ID Number:         ");
    Label idNationLabel = new Label("ID Nation:           ");
    Label telNumberLabel = new Label("Mobile Number: ");
    Label emailLabel = new Label("email:                 ");
    Label otherDetailsLabel = new Label("Other Details:      ");

    //Labels for Land Information
    Label plotNumberLabel = new Label("Plot Number:    ");
    Label blockNumberLabel = new Label("Block Number: ");
    Label latitudeLabel = new Label("Latitude:            ");
    Label longitudeLabel = new Label("Longitude:         ");
    Label landDetailsLabel = new Label("Land Details:    ");


    //TextFields for Personal Information
    //TextField titleTextField = new TextField();
    TextField firstNameTextField = new TextField();
    TextField lastNameLTextField = new TextField();
    TextField otherNamesTextField = new TextField();

    public DatePicker dobDatePicker = new DatePicker();
    TextField addressTextField = new TextField();
    TextField cityTextField = new TextField();
    TextField countryTextFiels = new TextField();

    //Gives options to select titles
    ObservableList<String> titlesList =
            FXCollections.<String>observableArrayList("Mr.", "Ms.", "Miss", "Dr.", "Prof.");
    ChoiceBox<String> titlesChoiceBox = new ChoiceBox<>(titlesList);


    //TextFields for Contact Information
    TextField idTypeTextField = new TextField();
    TextField idNumberTextField = new TextField();
    TextField idNationTextField = new TextField();
    TextField telNumberTextField = new TextField();
    TextField emailTextField = new TextField();
    TextArea otherDetailsTextArea = new TextArea();

    //Gives options to select types of ID
    ObservableList<String> idTypesList =
            FXCollections.<String>observableArrayList("Voter ID", "Passport", "SSNIT ID");
    ChoiceBox<String> idTypes = new ChoiceBox<>(idTypesList);

    //TextFields for Land Information
    TextField plotNumberTextField = new TextField();
    TextField blockNumberTextField = new TextField();
    TextField latitudeTextField = new TextField();
    TextField longitudeTextField = new TextField();
    TextArea landDetailsTextArea = new TextArea();


    public AddPersonLandDetailsView(PersonDetails model, String dateFormat) throws IOException {
        this.model = model;
        this.dateFormat = dateFormat;
        this.layoutForm();
        this.syncBirthDate();
        this.bindViewToModel();

    }

    //the create of of HBoxs for The name TextField pair.
    private static HBox hBoxLT(Label label, TextField textField) {

        HBox hBox = new HBox();
        hBox.getChildren().addAll(label, textField);
        hBox.setSpacing(3);

        return hBox;
    }

    /*
     * This is a method that lays out the Personal details Node. It creates a flowpane for the
     * labels and and Textfield. And an HBox to contain the flowpane and an ImageView with a
     * button stacked on it.
     * */
    private TitledPane getPersInfoTP() throws IOException {
        FlowPane flowPane = new FlowPane();
        flowPane.setVgap(3);
        HBox tiHB = new HBox();

        tiHB.getChildren().addAll(this.titleLabel, this.titlesChoiceBox);
        this.titlesChoiceBox.getSelectionModel().selectFirst();
        tiHB.setSpacing(3);

        HBox fnHB = new HBox();
        fnHB.getChildren().addAll(this.firstNameLabel, this.firstNameTextField);

        HBox lnHB = new HBox();
        lnHB.getChildren().addAll(this.lastNameLLabel, this.lastNameLTextField);
        fnHB.setSpacing(3);

        HBox othHB = new HBox();
        othHB.getChildren().addAll(this.otherNamesLabel, this.otherNamesTextField);
        othHB.setSpacing(3);

        HBox dobHB = new HBox();
        dobHB.getChildren().addAll(this.dobLabel, this.dobDatePicker);
        dobHB.setSpacing(3);

        HBox adHB = new HBox();
        adHB.getChildren().addAll(this.addressLabel, addressTextField);
        adHB.setSpacing(3);

        HBox cityHB = new HBox();
        cityHB.getChildren().addAll(this.cityLabel, this.cityTextField);
        cityHB.setSpacing(3);

        HBox countryHB = new HBox();
        countryHB.getChildren().addAll(this.countryLabel, this.countryTextFiels);
        countryHB.setSpacing(3);

        flowPane.getChildren().addAll(tiHB, fnHB, lnHB, othHB, adHB, dobHB, cityHB, countryHB);
        flowPane.setPadding(new Insets(5));


        HBox persInfoHB = new HBox();

        // A stackpane to contain the Image View and the add Photo Button.
        StackPane stackPane = new StackPane();
        this.addPhotoImVw.setImage(new Image(new FileInputStream("resources/images/tf.png")));
        stackPane.setAlignment(Pos.TOP_LEFT);
        stackPane.setMaxSize(50, 55);

        this.addPhotoBTN.setText("  add\nphoto");
        this.addPhotoBTN.setFont(Font.font(40));
        this.addPhotoBTN.setOpacity(0.6);
        this.addPhotoBTN.setAlignment(Pos.BOTTOM_CENTER);

        this.personIdLabel.setText(String.valueOf(model.getPersonID()));
        this.personIdLabel.setAlignment(Pos.TOP_CENTER);
        this.personIdLabel.setPadding(new Insets(5));
        this.personIdLabel.setFont(Font.font(18));

        stackPane.getChildren().addAll(this.addPhotoImVw, this.addPhotoBTN);
        persInfoHB.getChildren().addAll(stackPane, flowPane, this.personIdLabel);

        persInfoHB.setSpacing(7);

        TitledPane titledPane = new TitledPane("Personal Info", persInfoHB);
        titledPane.setExpanded(true);

        return titledPane;

    }

    private TitledPane getContInfoTP() {
        VBox vBox = new VBox();

        HBox idTypeHBox = new HBox();
        idTypeHBox.getChildren().addAll(this.idTypeLabel, this.idTypes);
        this.idTypes.getSelectionModel().selectFirst();

        HBox otherDtHB = new HBox();
        otherDtHB.getChildren().addAll(this.otherDetailsLabel, this.otherDetailsTextArea);
        otherDtHB.setSpacing(3);

        vBox.getChildren().addAll(idTypeHBox,
                hBoxLT(this.idNumberLabel, this.idNumberTextField),
                hBoxLT(idNationLabel, idNationTextField),
                hBoxLT(this.telNumberLabel, this.telNumberTextField),
                hBoxLT(this.emailLabel, this.emailTextField),
                otherDtHB);
        vBox.setSpacing(3);

        TitledPane titledPane = new TitledPane("Contact Info", vBox);
        titledPane.setExpanded(false);

        return titledPane;

    }

    //General Method that takes a Lable and a Textfield to simplify

    private TitledPane getLandInfoTP() {

        VBox vBox = new VBox();
        vBox.setSpacing(3);

        //HBox for LandDetails Label and TextArea.
        HBox lanDTHB = new HBox();
        lanDTHB.setSpacing(3);
        lanDTHB.getChildren().addAll(this.landDetailsLabel, landDetailsTextArea);


        vBox.getChildren().addAll(hBoxLT(this.plotNumberLabel, this.plotNumberTextField),
                hBoxLT(this.blockNumberLabel, this.blockNumberTextField),
                hBoxLT(this.longitudeLabel, this.longitudeTextField),
                hBoxLT(this.latitudeLabel, this.latitudeTextField),
                lanDTHB
        );

        TitledPane titledPane = new TitledPane("Land Info", vBox);
        titledPane.setExpanded(false);

        return titledPane;
    }

    private VBox getSaveCancelErrorTP() {
        VBox vBox = new VBox();

        HBox saveCancelHB = new HBox();
        saveCancelHB.getChildren().addAll(this.saveBtn, this.cancelBtn);
        saveCancelHB.setAlignment(Pos.CENTER);


        vBox.getChildren().addAll(saveCancelHB, this.errorLabel);
        saveCancelHB.setSpacing(3);
        vBox.setSpacing(5);
        saveCancelHB.setPadding(new Insets(4));
        vBox.setPadding(new Insets(5));


        return vBox;
    }


    public Stage layoutForm() throws IOException {

        dobDatePicker.setPromptText(dateFormat.toLowerCase());

        Stage primaryStage = new Stage();

        VBox root = new VBox();
        root.getChildren().addAll(getPersInfoTP(), getContInfoTP(), getLandInfoTP(), getSaveCancelErrorTP());

        ScrollPane scrollPane = new ScrollPane(root);

        Scene scene = new Scene(scrollPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add New Entry");
        return primaryStage;
    }

    public void bindViewToModel() {
        titlesChoiceBox.valueProperty().bindBidirectional(model.titleProperty());
        titlesChoiceBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                titlesChoiceBox.valueProperty().bindBidirectional(model.titleProperty());
        }
        });



        firstNameTextField.textProperty().bindBidirectional(model.firstNameProperty());
        lastNameLTextField.textProperty().bindBidirectional(model.lastNameProperty());
        otherNamesTextField.textProperty().bindBidirectional(model.otherNamesProperty());
        addressTextField.textProperty().bindBidirectional(model.addressProperty());
        cityTextField.textProperty().bindBidirectional(model.cityProperty());
        dobDatePicker.valueProperty().bindBidirectional(model.dateOfBirthProperty());
        countryTextFiels.textProperty().bindBidirectional(model.countryProperty());

        idNumberTextField.textProperty().bindBidirectional(model.idNumberProperty());
        idTypeTextField.textProperty().bindBidirectional(model.idTypeProperty());
        idNationTextField.textProperty().bindBidirectional(model.idNationProperty());
        otherDetailsTextArea.textProperty().bindBidirectional(model.otherDetailsProperty());
        emailTextField.textProperty().bindBidirectional(model.emailProperty());
        telNumberTextField.textProperty().bindBidirectional(model.telNumberProperty());


        plotNumberTextField.textProperty().bindBidirectional(model.plotNumberProperty());
        blockNumberTextField.textProperty().bindBidirectional(model.blockNumberProperty());
        longitudeTextField.textProperty().bindBidirectional(model.longitudeProperty());
        latitudeTextField.textProperty().bindBidirectional(model.latitudeProperty());
        landDetailsTextArea.textProperty().bindBidirectional(model.landDetailsProperty());


    }

    public void syncBirthDate() {

        LocalDate dob = model.getDateOfBirth();
        if (dob != null) {
        }
    }


}
