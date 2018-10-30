import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


public class Movies extends ArrayList<Movie> implements JSON  {

    //Standardconstructor for Testing



    //Methoden

    public Movie getMovieById(int movId) {
        for (Movie mov: this) {
            if (mov.id == movId) {
                return mov;
            }
        }
        return null;
    }



    @Override
    public void saveToJson() {
        try
        {
            DatabaseConnection.connectToDB();
            // the mysql insert statement
            String query = " insert into movie (id, title, duration, description, imagepath)"
                    + " values (?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = DatabaseConnection.conn.prepareStatement(query);
            preparedStmt.setInt (1, 1);
            preparedStmt.setString (2, "MKMIMI");
            preparedStmt.setInt   (3, 75);
            preparedStmt.setString(4, "Ein richtig nicer Film");
            preparedStmt.setString    (5, "Keiner weiss");

            // execute the preparedstatement
            preparedStmt.execute();
            DatabaseConnection.conn.close();

        }
        catch(Exception e)
        {
            System.out.print("Could not save Movies - Error:"+e);
        }
    }

    public static  Movies getMovies(){
        Movies movies = new Movies();

        try {
            DatabaseConnection.connectToDB();
            Statement stmt = DatabaseConnection.conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM movie");
            while(result.next()){

                Movie movie = new Movie();
                movie.id = (result.getInt(1));
                movie.title = (result.getString(2));
                movie.duration = (result.getInt(3));
                movie.description = (result.getString(4));
                movie.imagePath = (result.getString(5));
                movies.add(movie);

            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return movies;

    }

}
