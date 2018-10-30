import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main {

    //Eigenschaften

    public static JFrame mainFrame;
    public static Movie selectedMovie;
    public static Person person;
    public static FrmMovie frmMovie;
    public static FrmPresentation frmPresentation;
    public static FrmSeating frmSeating;
    public static FrmLogin frmloggin;
    public static int anzahl;
    public static String path;
    public static String moviepath;
    public static String presentationpath;
    public static String personpath;
    public static Movies mov = new Movies();
    //Main (Start)

    public static void main(String [ ] args) {
        mov.getMovies();
        moviepath="files/movies.json";
        presentationpath="files/presentations.json";
        personpath="files/persons.json";


        mainFrame = new JFrame("Login");
        frmloggin = new FrmLogin();
        showMessageDialog(null,"Achten Sie auf Gross/Klein-Schreibung");
        mainFrame.setContentPane(frmloggin.pnlogin);
        mainFrame.pack();
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
