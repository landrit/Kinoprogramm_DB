import sun.swing.BakedArrayList;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by olilub on 10.02.2017.
 */
public class Presentation {

    //Eigenschaften

    public int id;
    public String playTime;
    public LocalDate date;
    public int movieId;
    public Seats reservedSeats;
    public Seats boughtSeats;

    //Methoden

    public Presentation(int id, String playTime, LocalDate date, int movieId) {
        this.id = id;
        this.playTime = playTime;
        this.date = date;
        this.movieId = movieId;
        this.reservedSeats = new Seats();
        this.boughtSeats = new Seats();
    }
}
