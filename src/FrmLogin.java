import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;

import static javax.swing.JOptionPane.showMessageDialog;


public class FrmLogin {

    //Eigenschaften

    public JTextField usernamefeld;
    public JButton einloggenButton;
    public JButton signUpButton;
    public JPanel pnlogin;
    public JTextField passwortfeld;

    //Constructor

    public FrmLogin(){
        pnlogin.setName("Login Form");
        einloggenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = usernamefeld.getText();
                String passwort= passwortfeld.getText();

                if (login(name,passwort)){
                    Movies movies = Movies.getMovies();
                    Main.mainFrame.setVisible(false);
                    Main.mainFrame = new JFrame("Kinoprogramm");
                    Main.frmMovie = new FrmMovie(movies, getPerson(name,passwort));
                    Main.mainFrame.setContentPane(Main.frmMovie.pnlMovie);
                    Main.mainFrame.pack();
                    Main.mainFrame.setResizable(false);
                    Main.mainFrame.setLocationRelativeTo(null);
                    Main.mainFrame.setVisible(true);
                }
                else {
                    showMessageDialog(null,"Falscher Benutzername oder Passwort.");
                }
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = usernamefeld.getText();
                String passwort= passwortfeld.getText();
                signup(name, passwort);
            }
        });
    }



    //Checken, ob die Person im JSON existiert

    public boolean login(String name, String pw){
        Persons persList = new Persons();
        persList = persList.getPersons();
        for (Person pers : persList){
            if (pers.name.equals(name) && pers.passwort.equals(pw)){
                return true;
            }
    }
        return false;
    }



    // Person von der Liste bekommen
    public Person getPerson(String name, String pw){
        Persons persList = new Persons();
        persList = persList.getPersons();
        for (Person pers : persList){
            if (pers.name.equals(name) && pers.passwort.equals(pw)){
                return pers;
            }
        }
        return null;
    }


    //Sign up Methode
    public void signup(String name, String pw){
        if (name.equals("") || pw.equals("") || name.equals("Benutzername") || pw.equals("Passwort")){

            showMessageDialog(null, "Geben Sie einen Benutzernamen und Passwort ein.");
        }
        else{
            if (!login(name,pw)){
                Person person = new Person();
                person.name = name;
                person.passwort = pw;
                saveToJson(person);
                showMessageDialog(null,"Der Benutzer " +person.name+ " wurde gespeichert.");
                Movies movies = Movies.getMovies();
                Main.mainFrame.setVisible(false);
                Main.mainFrame = new JFrame("Kinoprogramm");
                Main.frmMovie = new FrmMovie(movies, getPerson(name,pw));
                Main.mainFrame.setContentPane(Main.frmMovie.pnlMovie);
                Main.mainFrame.pack();
                Main.mainFrame.setResizable(false);
                Main.mainFrame.setLocationRelativeTo(null);
                Main.mainFrame.setVisible(true);
            }
            else {
                showMessageDialog(null,"Der Benutzer existiert.");
            }
        }
    }

    //JSON abspeichern
    public void saveToJson(Person toSave){
        Persons persList = new Persons();
        persList = persList.getPersons();
        persList.add(toSave);
        for (Person pers:persList) {
            persList.saveToDatabase(pers);
        }
    }
}


