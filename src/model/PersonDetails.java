package model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PersonDetails  {


    private static AtomicInteger personCounter = new AtomicInteger(0);
    private final ReadOnlyIntegerWrapper personID =
            new ReadOnlyIntegerWrapper(this, "personID", personCounter.incrementAndGet() );
    private final StringProperty title =
            new SimpleStringProperty(this, "title", null);
    private final StringProperty firstName =
            new SimpleStringProperty(this, "firstName", null);
    private final StringProperty lastName =
            new SimpleStringProperty(this, "lastName", null);
    private final StringProperty otherNames =
            new SimpleStringProperty(this, "otherNames", null);
    private final StringProperty address =
            new SimpleStringProperty(this, "address", null);
    private final ObjectProperty<LocalDate> dateOfBirth =
            new SimpleObjectProperty<LocalDate>(this, "dateOfBirth", null);
    private final StringProperty city =
            new SimpleStringProperty(this, "city", null);
    private final StringProperty country =
            new SimpleStringProperty(this, "country", null);

    private final StringProperty idType =
            new SimpleStringProperty(this, "idType", null);
    private final StringProperty idNumber =
            new SimpleStringProperty(this, "idNumber", null);
    private final StringProperty idNation =
            new SimpleStringProperty(this, "idNation", null);
    private final StringProperty telNumber =
            new SimpleStringProperty(this, "telNumber", null);
    private final StringProperty email =
            new SimpleStringProperty(this, "email", null);
    private final StringProperty otherDetails =
            new SimpleStringProperty(this, "otherDetails", null);

    private final StringProperty plotNumber =
            new SimpleStringProperty(this, "plotNumber", null);
    private final StringProperty blockNumber =
            new SimpleStringProperty(this, "blockNumber", null);
    private final StringProperty longitude =
            new SimpleStringProperty(this, "longitude", null);
    private final StringProperty latitude =
            new SimpleStringProperty(this, "latitude", null);
    private final StringProperty landDetails =
            new SimpleStringProperty(this, "landDetails", null);

    //A no argument constructor
    public PersonDetails() {
    }

    //A constructor that takes all values of a PersonDetail class and creates an object with it
    public PersonDetails(String title, String firstname, String lastname, String othernames,
                         LocalDate dob, String address, String city, String country, String idtype,
                         String idnumber, String idnation, String telnumber, String email,String otherdetails,
                         String plotnumber, String blocknumber, String longitude, String latitude, String landdetails){


        this.title.set(title);
        this.firstName.set(firstname);
        this.lastName.set(lastname);
        this.otherNames.set(othernames);
        this.dateOfBirth.set(dob);
        this.address.set(address);
        this.city.set(city);
        this.country.set(country);

        this.idType.set(idtype);
        this.idNumber.set(idnumber);
        this.idNation.set(idnation);
        this.email.set(email);
        this.telNumber.set(telnumber);
        this.otherDetails.set(otherdetails);

        this.blockNumber.set(blocknumber);
        this.plotNumber.set(plotnumber);
        this.longitude.set(longitude);
        this.latitude.set(latitude);
        this.landDetails.set(landdetails);


    }

    public static AtomicInteger getPersonCounter() {
        return personCounter;
    }

    public static void setPersonCounter(AtomicInteger personCounter) {
        PersonDetails.personCounter = personCounter;
    }

    public int getPersonID() {
        return personID.get();
    }

    public void setPersonID(int personID) {
        this.personID.set(personID);
    }

    public ReadOnlyIntegerProperty personIDProperty() {
        return personID.getReadOnlyProperty();
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty titleProperty() {
        return title;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getOtherNames() {
        return otherNames.get();
    }

    public void setOtherNames(String otherNames) {
        this.otherNames.set(otherNames);
    }

    public StringProperty otherNamesProperty() {
        return otherNames;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public Property<LocalDate> dateOfBirthProperty() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public String getCountry() {
        return country.get();
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public StringProperty countryProperty() {
        return country;
    }

    public String getIdType() {
        return idType.get();
    }

    public void setIdType(String idType) {
        this.idType.set(idType);
    }

    public StringProperty idTypeProperty() {
        return idType;
    }

    public String getIdNumber() {
        return idNumber.get();
    }

    public void setIdNumber(String idNumber) {
        this.idNumber.set(idNumber);
    }

    public StringProperty idNumberProperty() {
        return idNumber;
    }

    public String getIdNation() {
        return idNation.get();
    }

    public void setIdNation(String idNation) {
        this.idNation.set(idNation);
    }

    public StringProperty idNationProperty (){
        return idNation;
    }

    public String getTelNumber() {
        return telNumber.get();
    }

    public StringProperty telNumberProperty() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber.set(telNumber);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getBlockNumber() {
        return blockNumber.get();
    }

    public StringProperty blockNumberProperty() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber.set(blockNumber);
    }


    public String getOtherDetails() {
        return otherDetails.get();
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails.set(otherDetails);
    }

    public StringProperty otherDetailsProperty() {
        return otherDetails;
    }

    public String getPlotNumber() {
        return plotNumber.get();
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber.set(plotNumber);
    }

    public StringProperty plotNumberProperty() {
        return plotNumber;
    }

    public String getLongitude() {
        return longitude.get();
    }

    public void setLongitude(String longitude) {
        this.longitude.set(longitude);
    }

    public StringProperty longitudeProperty() {
        return longitude;
    }

    public String getLatitude() {
        return latitude.get();
    }

    public void setLatitude(String latitude) {
        this.latitude.set(latitude);
    }

    public StringProperty latitudeProperty() {
        return latitude;
    }

    public String getLandDetails() {
        return landDetails.get();
    }

    public void setLandDetails(String landDetails) {
        this.landDetails.set(landDetails);
    }

    public StringProperty landDetailsProperty() {
        return landDetails;
    }

    /******************Domain Specific Rules*******************/

    /*
    *Overload the method isValidBirthDate, the first calls the
    *second and pass in the DOB and a new ArrayList to Save Strings of errors
    *valid if date is null or a previous date.
    * NB: Depends on the current Date and time of the System.
    *
    **/

    public boolean isValidPersonLandDetail(List<String> errorList){
        return isValidPersonLandDetail(this, errorList);

    }
    public boolean isValidPersonLandDetail(PersonDetails personDetails, List<String> errorList){
        boolean isValid = true;

        String fn = personDetails.title.get();
        if (fn == null || fn.trim().length() == 0){
            errorList.add("First name must contain minimum one character.");
            isValid = false;
        }

        String ln = personDetails.lastName.get();
        if (fn == null || fn.trim().length() == 0){
            errorList.add("Last name must contain minimum one character.");
            isValid = false;
        }
        String address = personDetails.address.get();
        if (address == null || address.trim().length() == 0){
            errorList.add("Address must contain minimum one character.");
        }

        String city = personDetails.city.get();
        if (city == null || city.trim().length() == 0){
            errorList.add("City must contain minimum one character.");
            isValid = false;
        }

        String country = personDetails.country.get();
        if (country == null || country.trim().length() <2){
            errorList.add("Country must contain minimum Two character");
            isValid = false;
        }

        String idnum = personDetails.idNumber.get();
        if (idnum == null || idnum.trim().length() == 0 ){

            errorList.add("ID number must contain minimum one number.");
            isValid = false;
        }
        try {
            Long.parseLong(idnum);
        }catch (NumberFormatException e){
            errorList.add("ID number must contain only numbers.");
            isValid = false;
        }

        String idNation = personDetails.idNation.get();
        if (idNation == null || idNation.trim().length() <2) {
            errorList.add("ID nation must contain minimum one character.");
            isValid = false;
        }

        String tel = personDetails.telNumber.get();
        if (tel == null || tel.trim().length() == 0){
            errorList.add("Telefone number must contain minimum one character.");
            isValid = false;
        }
        try {
            Long.parseLong(tel);
        }catch (NumberFormatException e){
            errorList.add("Telephone number must contain only numbers.");
            isValid = false;
        }

        String lat = personDetails.latitude.get();
        if (lat == null || lat.trim().length() == 0){
            errorList.add("Latitude must contain minimum one Character.");
            isValid = false;
        }else {
            try {
                Double.parseDouble(lat);
            } catch (NumberFormatException e) {
                errorList.add("Latitude must contain only numbers and or a dot (.)");
                isValid = false;
            }
        }

        String lon = personDetails.longitude.get();
        if (lon == null || lon.trim().length() == 0){
            errorList.add("Longitude must contain minimum one Character.");
            isValid = false;
        }else {
            try {
                Double.parseDouble(lon);
            } catch (NumberFormatException e) {
                errorList.add("Longitude must contain only numbers and or a dot (.)");
                isValid = false;
            }
        }

        String pltno = personDetails.plotNumber.get();
        if (pltno == null || pltno.trim().length() ==0){
            errorList.add("Plot number must contain minimum one number.");
            isValid = false;
        }else {
            try {
                Integer.parseInt(pltno);
            } catch (NumberFormatException e) {
                errorList.add("Plot number must contain only numbers.");
            }
        }

        if (!isValidBirthDate(this.getDateOfBirth(), errorList)){
            isValid = false;
        }

        return  isValid;
    }


    public boolean isValidBirthDate(LocalDate dob){
        return isValidBirthDate(dob, new ArrayList<>());
    }

    public boolean isValidBirthDate(LocalDate dob, List<String> errorList){

        if(dob == null){
            return true;
        }
        if (dob.isAfter(LocalDate.now())){
            errorList.add("Birth date must not be in the future.");
            return false;
        }
    return true;
    }

    public boolean save(List<String> errorList){
        boolean isSaved = false;
        if (isValidPersonLandDetail(errorList)){
            isSaved = true;
        }
        return isSaved;
    }
}
