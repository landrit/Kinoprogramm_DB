import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class SeatTest {
    @Before
    public void setTestdata() {
        Main.personpath = "testfiles/persons.json";
        Main.moviepath = "testfiles/movies.json";
        Main.presentationpath = "testfiles/presentations.json";
    }
    @Test
    public void SeatIsNull(){
        Seat seaty = new Seat();
        Assert.assertNotNull(seaty);
    }
}