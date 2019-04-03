package presenter;

import java.sql.*;


public class ConnetDataBase {
    private Connection initDBconnection;
    private Statement initDBStatement;
    private PreparedStatement initDBPStatement;



    //Connect to database if exist
    public Connection loadDriver() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        System.out.println("Driver loaded successfully!");

        initDBconnection =
                DriverManager.getConnection("jdbc:h2:~/resources", "sa", "");
        System.out.println("Connection Sucessfull");
        return initDBconnection;
    }

    public Statement getInitDBStatement() {
        return initDBStatement;
    }

    //Creates a public method which returns a Prepared statement to be used by the Presenter
    //Class to insect data into the database.

    public PreparedStatement getInitDBPStatement() throws SQLException, ClassNotFoundException {
        initDBPStatement = loadDriver().prepareStatement(" INSERT INTO PERSONINFO" +
                "(TITLE, FIRSTNAME, LASTNAME, OTHERNAMES, ADDRESS, CITY, DATEOFBIRTH, COUNTRY)" +
                "VALUES (?,?,?,?,?,?,?,?)" );
        return initDBPStatement;
    }

    public void initDBCreateTables() throws SQLException {
        initDBStatement = initDBconnection.createStatement();

        //Create PERSONINFO if not exist, personid is the primary key, it auto increases
        // and cannot be empty.
//        initDBStatement.executeUpdate("CREATE TABLE IF NOT EXISTS PERSONINFO (" +
//                "PERSONID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
//                "TITLE VARCHAR (15), FIRSTNAME VARCHAR (20), LASTNAME VARCHAR (20), " +
//                "OTHERNAMES VARCHAR (20), ADDRESS VARCHAR (50), CITY VARCHAR (40), " +
//                "DATEOFBIRTH VARCHAR (20), COUNTRY VARCHAR (40))");
        initDBStatement.executeUpdate("CREATE TABLE IF NOT EXISTS PERSONINFO (" +
                "PERSONID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
                "TITLE VARCHAR (15), FIRSTNAME VARCHAR (20), LASTNAME VARCHAR (20), " +
                "OTHERNAMES VARCHAR (20), ADDRESS VARCHAR (50), CITY VARCHAR (40), " +
                "DATEOFBIRTH DATE, COUNTRY VARCHAR (40))");

        //Creates CONTACTINFO table if not exit.
        initDBStatement.executeUpdate("CREATE TABLE IF NOT EXISTS CONTACTINFO ("+
                "PERSONID INTEGER AUTO_INCREMENT NOT NULL, "+
                "IDTYPE VARCHAR (20), IDNUMBER VARCHAR (25), IDNATION VARCHAR (50), " +
                "TELNUMBER VARCHAR (20), EMAIL VARCHAR (40), CONTACTDETAILS VARCHAR (500)," +
                "FOREIGN KEY (PERSONID) REFERENCES PERSONINFO (PERSONID))");

        initDBStatement.executeUpdate("CREATE TABLE IF NOT EXISTS LANDINFO (" +
                "PERSONID INTEGER AUTO_INCREMENT NOT NULL, " +
                "PLOTNUMBER INTEGER, BLOCKNUMBER VARCHAR (20), LONGITUDE DOUBLE, " +
                "LATITUDE DOUBLE, LANDDETAILS VARCHAR (500)," +
                "FOREIGN KEY (PERSONID) REFERENCES PERSONINFO (PERSONID)" +
                ")");

        //initDBStatement.executeUpdate("ALTER TABLE CONTACTINFO ADD FOREIGN KEY (PERSONID" +
          //      "REFERENCES PERSONINFO (PERSONID))");


    }


}
