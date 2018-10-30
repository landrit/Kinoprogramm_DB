import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Persons extends ArrayList<Person>  {

    //Methoden

    public static Persons getPersons(){
        Persons persons = new Persons();

        try {
            DatabaseConnection.connectToDB();
            Statement stmt = DatabaseConnection.conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM person");
            while(result.next()){

                Person person = new Person();
                person.name = (result.getString(1));
                person.passwort = (result.getString(2));
                persons.add(person);

            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return persons;

    }



    public void saveToDatabase(Person pers) {
        try
        {
            DatabaseConnection.connectToDB();
            // the mysql insert statement
            String query = " insert into person (name, passwort)"
                    + " values (?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = DatabaseConnection.conn.prepareStatement(query);
            preparedStmt.setString (1, pers.name);
            preparedStmt.setString (2, pers.passwort);

            // execute the preparedstatement
            preparedStmt.execute();
            DatabaseConnection.conn.close();

        }
        catch(Exception e)
        {
            System.out.print("Could not save Person - Error:"+e);
        }
    }

}
