import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import java.awt.*;



public class FrmSeatingTest {
    Presentations presList;
    @Before
    public void loadFormData() {
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
        Movies movies = Movies.getMovies();
        Main.selectedMovie = movies.get(1);
        Person pers = new Person();
        pers.name = "Testperson";
        pers.passwort = "Testpasswort";
        Main.mainFrame = new JFrame("Seating Form");
        Main.frmSeating = new FrmSeating(Main.selectedMovie,"16:30",pers);

        Main.mainFrame.setContentPane(Main.frmSeating.pnlSeats);
        Main.mainFrame.pack();
        Main.mainFrame.setResizable(false);
        Main.mainFrame.setLocationRelativeTo(null);
        Main.mainFrame.setVisible(true);

        presList = new Presentations();
        presList = presList.loadFromJson();
    }

    @Test
    public void clickOnButton() {
        for (Component comp : Main.frmSeating.pnlseatss.getComponents()) {
            if (comp instanceof JButton) {
                JButton buttoni = (JButton) comp;
                if (buttoni.getText().equals("A09")) {
                    buttoni.doClick();
                    break;
                }
            }
        }
        presList.saveToJson();
    }

    @Test
    public void reserveSeats() {
        for (Component comp : Main.frmSeating.pnlseatss.getComponents()) {
            if (comp instanceof JButton) {
                    JButton buttoni = (JButton) comp;
                    if (buttoni.getText().equals("A09")) {
                        buttoni.doClick();
                        ClickOnReserveButton();
                        break;
                    }
                }
            }
        presList.saveToJson();
        }

    @Test
    public void buySeats() {
        for (Component comp : Main.frmSeating.pnlseatss.getComponents()) {
            if (comp instanceof JButton) {
                JButton buttoni = (JButton) comp;
                if (buttoni.getText().equals("A09")) {
                    buttoni.doClick();
                    ClickOnBuyButton();
                    break;
                }
            }
        }
        presList.saveToJson();
    }
    @Test
    public void deleteSeats() {
        for (Component comp : Main.frmSeating.pnlseatss.getComponents()) {
            if (comp instanceof JButton) {
                JButton buttoni = (JButton) comp;
                if (buttoni.getText().equals("A09")) {
                    buttoni.doClick();
                    ClickOndeleteButton();
                    break;
                }
            }
        }
        presList.saveToJson();
    }
    @Test
    public void clickOnBackButton() {
        for (Component comp : Main.frmSeating.pnlseatss.getComponents()) {
            if (comp instanceof JButton) {
                if (((JButton) comp).getText().equals("Zurück")) {
                    ((JButton) comp).doClick();
                }
            }
        }
        Assert.assertEquals(Main.mainFrame.getContentPane().getName(), "Presentation Form");
    }



    public void ClickOndeleteButton() {
        for (Component comp : Main.frmSeating.pnlseatss.getComponents()) {
            if (comp instanceof JButton) {
                JButton buttoni = (JButton) comp;
                if (buttoni.getText().equals("Löschen")){
                    buttoni.doClick();
                    break;
                }
            }
        }
    }


    public void ClickOnReserveButton() {
        for (Component comp : Main.frmSeating.pnlseatss.getComponents()) {
            if (comp instanceof JButton) {
                JButton buttoni = (JButton) comp;
                if (buttoni.getText().equals("Reservieren")){
                    buttoni.doClick();
                    break;
                }
            }
        }
    }
    public void ClickOnBuyButton() {
        for (Component comp : Main.frmSeating.pnlseatss.getComponents()) {
            if (comp instanceof JButton) {
                JButton buttoni = (JButton) comp;
                if (buttoni.getText().equals("Kaufen")){
                    buttoni.doClick();
                    break;
                }
            }
        }
    }

}