import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.OMGVMCID;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.Assert.*;


public class FrmMovieTest {
    @Before
    public void loadFormData() {
        Movies movies = Movies.getMovies();
        Main.mainFrame = new JFrame("Kinoprogramm");
        Person person = new Person();
        person.name = "Testperson";
        person.passwort = "Passwort";
        Main.frmMovie = new FrmMovie(movies, person);
        Main.mainFrame.setContentPane(Main.frmMovie.pnlMovie);
        Main.mainFrame.pack();
        Main.mainFrame.setResizable(false);
        Main.mainFrame.setLocationRelativeTo(null);
        Main.mainFrame.setVisible(true);
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
    }

    @Test
    public void ClickOnMovieOpenForm() {
        for (Component comp : Main.frmMovie.panel.getComponents()) {
            if (comp instanceof JPanel) {
                JPanel innerPanel = (JPanel) comp;
                for (Component innerComp : innerPanel.getComponents()) {
                    JButton button = (JButton) innerComp;
                    if (!button.getName().isEmpty()) {
                        button.doClick();
                        break;
                    }
                }
            }
        }
        Assert.assertEquals(Main.mainFrame.getContentPane().getName(), "Presentation Form");
    }


    @Test
    public void MovieImglinkFalse(){
        Movies movies = new Movies();
        Main.moviepath="testfiles/\\.json";
        movies.getMovies();
    }

    @Test
    public void ClickOnLogOutButton(){
        for (Component comp : Main.frmMovie.pnlMovie.getComponents()) {
            if (comp instanceof JButton) {
                JButton buttoni = (JButton) comp;
                        buttoni.doClick();
                        break;

            }
        }
        Assert.assertEquals(Main.mainFrame.getContentPane().getName(), "Login Form");
    }
}
