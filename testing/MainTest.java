import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Before
    public void loaddata(){
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
    }

    @Test
    public void MainIsNotNull(){
        Main main  = new Main();
        Assert.assertNotNull(main);
    }

    @Test
    public void MainIsWorking(){
        Main.main(new String[] {"args"});
        Assert.assertNotNull(Main.mainFrame.getContentPane());
    }
}