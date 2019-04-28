package presenter;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.PersonDetails;
import view.AddPersonLandDetailsView;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class PersonLandDetailsPresenter {

    private final PersonDetails model;
    private final AddPersonLandDetailsView addView;
    private final RandomAccessFile randomAccessKeyFile ;

    public PersonLandDetailsPresenter(PersonDetails model, AddPersonLandDetailsView view )
            throws IOException, SQLException, ClassNotFoundException {
        this.model = model;
        this.addView = view;
        attachEvents();

        randomAccessKeyFile = new RandomAccessFile("txokc73due.csv", "rw");
    }

    private void attachEvents() throws SQLException, ClassNotFoundException {
        handleInputs();

        addView.dobDatePicker.setOnAction(event -> {

            try {
                handleBirthDateChange();
            } catch (Exception e) {
                System.out.println("Date issues");
            }

        });

    }



    private void handleInputs() throws SQLException, ClassNotFoundException{
        addView.saveBtn.setOnAction(event -> {
            try {
                saveData();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

    }



    private void saveData() throws IOException, SQLException, ClassNotFoundException {
        List<String> errorList = new ArrayList<>();
        boolean isSaved = model.save(errorList);
        if (!isSaved){
            this.showError(errorList);
        }else {
            saveDatatoDB();
        }
    }

    private void saveDatatoDB () throws ClassNotFoundException, SQLException, IOException {
        ConnetDataBase connetDataBase = new ConnetDataBase();
        if (model.save(new ArrayList<>() )){


            //Gets the Text from the TextFied and assign them to variables of type
            //String to be used in prepared statement.
            String title = model.getTitle();
            String firstName = model.getFirstName();
            String lastName = model.getLastName();
            String otherNames = model.getOtherNames();
            String dateOfBirth = model.getDateOfBirth().toString();
            String address = model.getAddress();
            String city = model.getCity();
            String country = model.getCountry();

            String idType = model.getIdType();
            String idNation = model.getIdNation();
            String idNumber = model.getIdNumber();
            String telNumber = model.getTelNumber();
            String email = model.getEmail();
            String otherDetails  = model.getOtherDetails();

            String blockStreetNumber = model.getBlockNumber();
            String plotNumber = model.getPlotNumber();
            double longitude = Double.parseDouble(model.getLongitude());
            double latitude = Double.parseDouble(model.getLatitude());
            String landDetails = model.getLandDetails();


            //Uses the PrepareStatement in ConnectDatabase Class to insert into the
            //database of the details entered.
            PreparedStatement personPStatement = connetDataBase.getInitDBPStatement();
            personPStatement.setString(1, title);
            personPStatement.setString(2, firstName);
            personPStatement.setString(3, lastName);
            personPStatement.setString(4, otherNames);
            personPStatement.setString(5, address);
            personPStatement.setString(6, city);
            personPStatement.setString(7, dateOfBirth);
            personPStatement.setString(8, country);

            PreparedStatement contactPStatement = connetDataBase.getInitDBPStatement();
            contactPStatement.setString(1, idType);
            contactPStatement.setString(2, idNation);
            contactPStatement.setString(3, idNumber);
            contactPStatement.setString(4, telNumber);
            contactPStatement.setString(5, email);
            contactPStatement.setString(6, otherDetails);

            PreparedStatement landPStatement = connetDataBase.getInitDBPStatement();
            landPStatement.setString(1, blockStreetNumber);
            landPStatement.setString(2, plotNumber);
            landPStatement.setDouble(3, longitude);
            landPStatement.setDouble(4, latitude);
            landPStatement.setString(5, landDetails);


            //Excutes the prepare Updates
            personPStatement.executeUpdate();
            contactPStatement.executeUpdate();
            landPStatement.executeUpdate();
            addView.layoutForm().close();
        }
    }

    public void handleBirthDateChange() throws IOException {

        String bdateStr = addView.dobDatePicker.getValue().toString();

        if (bdateStr == null || bdateStr.trim().equals("")){
            model.setDateOfBirth(null);
            addView.syncBirthDate();

        }else {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(addView.dateFormat);
                LocalDate bdate = LocalDate.parse(bdateStr, formatter);

                List<String> errorList = new ArrayList<>();
                if(model.isValidBirthDate(bdate,errorList)){
                    model.setDateOfBirth(bdate);
                    addView.syncBirthDate();
                }else {
                    this.showError(errorList);
                    addView.syncBirthDate();
                }
            }catch (DateTimeParseException e){
                List<String> errorList = new ArrayList<>();
//                errorList.add("Birth date must be in the " +
//                addView.dateFormat.toLowerCase()+ " format.");
                this.showError(errorList);

                //Refresh the View
                addView.syncBirthDate();

            }
        }
    }

    public void showError(List<String> errorList) throws IOException {
        String msg = "";

        if (!errorList.isEmpty()) {
            for (String s : errorList) {
                msg = msg + s + "\n";

            }
            }

        Label msgLabel = new Label(msg);
        msgLabel.setFont(Font.font(15));
        msgLabel.setStyle("-fx-color-label-visible: red");
        Button okBtn = new Button("OK");
        VBox root = new VBox(new StackPane(msgLabel), new Separator(), new StackPane(okBtn));
        root.setSpacing(10);

        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        //stage.initOwner(addView.layoutForm().getScene().getWindow());

        okBtn.setOnAction(event -> stage.close());
        stage.setTitle("Error");
        stage.sizeToScene();
        stage.showAndWait();
    }



}
