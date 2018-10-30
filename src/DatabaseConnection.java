import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public abstract class DatabaseConnection {


    //Attributes
    static Connection  conn = null;

    //Methods
    public static void connectToDB(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Kinoprogramm","root", "");
            System.out.print("Database is connected !");
        }
        catch(Exception e)
        {
            System.out.print("Can't connect to DB - Error:"+e);
        }
    }
}


