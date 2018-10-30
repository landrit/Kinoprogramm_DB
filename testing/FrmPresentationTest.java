import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;


public class FrmPresentationTest {
    @Before
    public void loadFormData() {
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
        Movies movieList = new Movies();
        movieList = movieList.getMovies();
        Movie movie = movieList.get(1);
        Person pers = new Person();
        pers.name ="Testperson";
        pers.passwort = "Testpersonpasswort";
        Main.mainFrame = new JFrame("Presentation Form");
        Main.frmPresentation = new FrmPresentation(movie,pers);
        Main.mainFrame.setContentPane(Main.frmPresentation.pnlPresentation);
        Main.mainFrame.pack();
        Main.mainFrame.setResizable(false);
        Main.mainFrame.setLocationRelativeTo(null);
        Main.mainFrame.setVisible(true);
    }

    @Test
    public void ClickOn1630Button() {
        for (Component comp : Main.frmPresentation.pnlPresentation.getComponents()) {
            if (comp instanceof JButton) {
                if (((JButton) comp).getText().equals("16:30")) {
                    ((JButton) comp).doClick();
                }
            }
        }
        Assert.assertEquals(Main.mainFrame.getContentPane().getName(), "Seating Form");
    }

    @Test
    public void ClickOn2015Button() {
        for (Component comp : Main.frmPresentation.pnlPresentation.getComponents()) {
            if (comp instanceof JButton) {
                if (((JButton) comp).getText().equals("20:15")) {
                    ((JButton) comp).doClick();
                }
            }
        }
        Assert.assertEquals(Main.mainFrame.getContentPane().getName(), "Seating Form");
    }

    @Test
    public void ClickOnMenuButton() {
        for (Component comp : Main.frmPresentation.pnlPresentation.getComponents()) {
            if (comp instanceof JButton) {
                if (((JButton) comp).getText().equals("Zurück")) {
                    ((JButton) comp).doClick();
                }
            }
        }
        Assert.assertEquals(Main.mainFrame.getContentPane().getName(), "Movie Form");
    }
}