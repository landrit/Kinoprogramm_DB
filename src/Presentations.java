import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Presentations extends ArrayList<Presentation> implements JSON {

    //Standardconstructor

    Presentations(){

    }

    //Methoden

    @Override
    public void saveToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(this);

        try {
            Writer writer = new FileWriter(Main.presentationpath);
            writer.write(json);
            writer.close();
            System.out.println("Json file could be saved!");
        }
        catch (Exception ex) {
            System.out.println("Something went wrong!"+ex.getMessage());
        }
    }

    public static  Presentations getPresentations(){
        Presentations presentations = new Presentations();

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
