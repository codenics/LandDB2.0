import presenter.ConnetDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMachine {
    public static void main (String [] args ) throws ClassNotFoundException, SQLException {
 ConnetDataBase connetDataBase = new ConnetDataBase();
 Statement statement = connetDataBase.loadDriver().createStatement();
 statement.executeUpdate("create table if not exists newTablef (" +
         "nameN varchar (20), tel varchar (10), id integer auto_increment)");

 statement.executeUpdate("insert into newTable (nameN, tel, id )" +"" +
                 "values ('Brother', '7878', '888')");
ResultSet resultSet =
        statement.executeQuery("SELECT * FROM newTable");

statement.executeUpdate("DROP TABLE PERSONINFO");
while (resultSet.next()){
    System.out.println(resultSet.getString("nameN") + " " +
            resultSet.getString("tel") + " "+
            resultSet.getString("id"));

}
ResultSet resultSet1 = statement.executeQuery("SELECT * FROM PERSONINFO ");
while (resultSet1.next()){
    for (int i = 1; i <= resultSet1.getMetaData().getColumnCount() ; i++) {
        System.out.println(resultSet1.getString(i));
    }
    System.out.println(resultSet1.getMetaData().getColumnCount());

}



//ResultSet resultSet2 = connetDataBase.getInitDBStatement().executeQuery("show tables");
//resultSet2.getMetaData().getTableName(1);
//resultSet2.getMetaData().getColumnCount();

    }


}
