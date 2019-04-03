package view;

import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import model.PersonDetails;

import javax.swing.text.html.ImageView;

public class DisplayPersonLandDetailsView {

    private final PersonDetails model;

    public DisplayPersonLandDetailsView(PersonDetails model) {
        this.model = model;
    }

    TitledPane personalContactInfoTP = new TitledPane();
    TitledPane landInfoTP = new TitledPane();

    ImageView photoIdImageView;
    Image photoIdImage;

    Label titleFirstLastOtherNamesLB = new Label("TitleFirstLastOtherNames");
    Label addressCityCountryLB = new Label("AddressCityCountryLB");
    Label mobileNumberEmail = new Label("MobileNumberEmail");
    Label sexDateOfBirth = new Label("SexDateOfBirth");
    Label idTypeNumberNation = new Label("IdTypeNumberNation");

    Label otherDetails = new Label("Other Personal Details");

    Label plotNumberLB = new Label("Plot Number");
    Label blockNumberLB = new Label("Block/Street");

    Label longitute = new Label("Longitude");
    Label latitude = new Label("Latitude");

    Label errorMessage = new Label("No internet connection");

}
