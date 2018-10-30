import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MovieTest {
    @Before
    public void loadTestdata(){
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
    }

    @Test
    public void MovieIsNotNull(){
        Movie mov = new Movie();
        mov.id = 1;
        mov.title ="title";
        mov.duration = 185;
        mov.description ="Description";
        mov.imagePath ="imgpath";
        Assert.assertNotNull(mov);
    }


}