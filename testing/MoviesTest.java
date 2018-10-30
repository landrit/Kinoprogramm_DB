import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;


public class MoviesTest {
    @Before
    public void loadTestdata(){
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
    }




    @Test
    public void LoadFromJsonPossible(){
        Movies movies = new Movies();
        movies.getMovies();
        Assert.assertNotNull(movies);

    }



}