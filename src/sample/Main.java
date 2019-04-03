package sample;

import presenter.ConnetDataBase;
import presenter.PersonLandDetailsPresenter;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.PersonDetails;
import view.AddPersonLandDetailsView;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main extends Application {

    Button add = new Button("Add");
Button close = new Button("Close");
        String dateFormat = "dd/mm/yyyy";
        PersonDetails model = new PersonDetails();
        AddPersonLandDetailsView view;

    {
        try {
            view = new AddPersonLandDetailsView(model, dateFormat);
        } catch (IOException e) {

        }
    }

    PersonLandDetailsPresenter presenter;

    {
        try {
            presenter = new PersonLandDetailsPresenter(model, view);
        } catch (IOException e) {
        } catch (SQLException e){
        } catch (ClassNotFoundException e){

        }
    }

    @Override
    public void start(Stage primaryStage) throws IOException {


        Scene scene = new Scene(twoButton());
        this.add.setOnAction(event -> {
            try {
                this.view.layoutForm().show();
            } catch (IOException e) {

            }
        });

        this.close.setOnAction(event ->Platform.exit());


        primaryStage.setTitle("LandDB");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox twoButton(){
        HBox hBox = new HBox();
        hBox.getChildren().addAll(this.add, this.close);

        return hBox;

    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnetDataBase conDB = new ConnetDataBase();
        conDB.loadDriver();
        conDB.initDBCreateTables();
        ResultSet rs = conDB.getInitDBStatement().executeQuery("show tables");
        while (rs.next()){
            for (int i = 1; i < rs.getMetaData().getColumnCount(); i++) {
                System.out.println(rs.getString(i));
            }
        }

        launch(args);
    }
}
