import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PersonTest {
    @Before
    public void loadTestdata(){
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
    }

    @Test
    public void PersonIsNotNull(){
        Person pers = new Person();
        pers.name ="name";
        pers.passwort ="passwort";
        Assert.assertNotNull(pers);
    }
}