import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;


public class PresentationsTest {
    @Before
    public void loadTestdata(){
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
    }

    @Test
    public void Presentationstest(){
        Presentations preslist = new Presentations();
        Assert.assertNotNull(preslist);
    }

    @Test
    public void SaveToJsonFail(){
        Presentation presi = new Presentation(1,"20:15", LocalDate.now(),1);
        Presentations preslist = new Presentations();
        preslist.add(presi);
        Main.presentationpath="testfiles/||||hallo.json";
        preslist.saveToJson();
    }

    @Test
    public void LoadFromJsonFail(){
        Presentation presi = new Presentation(1,"20:15", LocalDate.now(),1);
        Presentations preslist = new Presentations();
        preslist.add(presi);
        Main.presentationpath="testfiles/||||hallo.json";
        preslist.loadFromJson();
    }
}