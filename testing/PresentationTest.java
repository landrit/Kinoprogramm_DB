import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.TemporalQueries;

import static org.junit.Assert.*;


public class PresentationTest {
    @Before
    public void loadTestdata(){
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
    }
    @Test
    public void PresentationIsNotNull(){
    Presentation present = new Presentation(1,"20:30", LocalDate.now(),5);
        Assert.assertNotNull(present);
    }
}