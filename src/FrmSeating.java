import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;


public class FrmSeating {

    //Eigenschaften

    public Seats reservedSeats;
    public JPanel pnlSeats;
    public Seats boughtSeats;
    private JButton reservierenButton;
    public JPanel pnlseatss;
    private JButton btnA1;
    private JButton btnA2;
    private JButton btnA3;
    private JButton btnA4;
    private JButton btnA5;
    private JButton btnA6;
    private JButton btnA7;
    private JButton btnA8;
    private JButton btnA9;
    private JButton btnA10;
    private JButton btnB1;
    private JButton btnC1;
    private JButton btnD1;
    private JButton btnE1;
    private JButton btnB2;
    private JButton btnB3;
    private JButton btnB4;
    private JButton btnB5;
    private JButton btnB6;
    private JButton btnB7;
    private JButton btnB8;
    private JButton btnB9;
    private JButton btnB10;
    private JButton btnC10;
    private JButton btnC9;
    private JButton btnC8;
    private JButton btnC7;
    private JButton btnC6;
    private JButton btnC5;
    private JButton btnC4;
    private JButton btnC3;
    private JButton btnC2;
    private JButton btnD2;
    private JButton btnD3;
    private JButton btnD4;
    private JButton btnD5;
    private JButton btnD6;
    private JButton btnD7;
    private JButton btnD8;
    private JButton btnD9;
    private JButton btnD10;
    private JButton btnE2;
    private JButton btnE3;
    private JButton btnE4;
    private JButton btnE5;
    private JButton btnE6;
    private JButton btnE7;
    private JButton btnE8;
    private JButton btnE9;
    private JButton btnE10;
    private JButton btnF1;
    private JButton btnF2;
    private JButton btnF3;
    private JButton btnF4;
    private JButton btnF5;
    private JButton btnF6;
    private JButton btnF7;
    private JButton btnF8;
    private JButton btnF9;
    private JButton btnF10;
    private JLabel Leinwand;
    private JButton zurückButton;
    private JButton kaufenButton;
    private JButton löschenButton;
    private JTextPane txpreserviert;
    private JTextPane txtkaufen;
    private JLabel lbluhrzeit;
    private int anzahl;
    private int price;
    private String places;
    private Seats activeSeats;

    //Constructor

    public FrmSeating(Movie movie, String playTime, Person person) {
        pnlSeats.setName("Seating Form");
        pnlseatss.setName("Seating Form");
        activeSeats = new Seats();
        reservedSeats = new Seats();
        boughtSeats= new Seats();
        reservedSeats = reservedSeats.loadFromJson(movie, playTime);
        boughtSeats= boughtSeats.loadBoughtFromJson(movie, playTime);
        setColor(reservedSeats,person);
        setBoughtColor(boughtSeats);

        ActionListener actionListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    JButton buttoni = (JButton) e.getSource();
                    if (buttoni.getText().equals("Reservieren")) {
                        System.out.println("Es sind folgende Sitze reserviert:");
                        activeSeats.delFromJson(movie, playTime);
                        activeSeats.saveToJson(activeSeats, movie, playTime);
                        setColor(activeSeats,person);
                        for (Seat seat : activeSeats){
                            reservedSeats.add(seat);
                        }
                        activeSeats.clear();
                        resText(person);
                    }
                    else if (buttoni.getText().equals("Kaufen")){
                        System.out.println("Es sind folgende Plätze gekauft:");
                        activeSeats.saveBoughtToJson(activeSeats, movie,playTime);
                        activeSeats.delFromJson(movie, playTime);
                        setBoughtColor(activeSeats);
                        for (Seat seat : activeSeats){
                            boughtSeats.add(seat);
                        }
                        activeSeats.clear();
                        kauftText(person);
                        showMessageDialog(null,"Der Gesammtpreis beträgt: "+ Main.anzahl*FrmPresentation.price + " Fr.");
                    }

                     if (buttoni.getText().equals("Zurück")) {
                        Main.mainFrame.setVisible(false);
                        Main.frmPresentation = new FrmPresentation(Main.selectedMovie, person);
                        Main.mainFrame.setContentPane(Main.frmPresentation.pnlPresentation);
                        Main.mainFrame.pack();
                        Main.mainFrame.setVisible(true);
                    }
                    else if (buttoni.getText().equals("Löschen")){
                        for (Component comp : pnlseatss.getComponents()){
                            if (comp instanceof JButton){
                                JButton but = (JButton) comp;
                                for (Seat seat : activeSeats){
                                    if(but.getText().equals(seat.place)){
                                        but.setBackground(Color.white);
                                    }
                                }
                            }
                        }
                        activeSeats.delFromJson(movie, playTime);
                        activeSeats.clear();
                        reservedSeats = reservedSeats.loadFromJson(movie, playTime);
                        resText(person);
                        kauftText(person);

                    }
                    else {
                        if (activeSeats.isSeatReserved(buttoni.getText())) {
                            if(reservedSeats.isSeatReserved(buttoni.getText())){
                                buttoni.setBackground(new Color(255, 220, 0));
                            }
                            else{
                                buttoni.setBackground(Color.white);
                            }
                            activeSeats.clear();
                        }
                        else {
                            if (!buttoni.getText().equals("Reservieren")&&!buttoni.getText().equals("Kaufen") &&!buttoni.getText().equals("Löschen")) {
                                Seat seat = new Seat();
                                seat.place = buttoni.getText();
                                seat.person = person.name;
                                buttoni.setBackground(new Color(0, 255, 0));
                                buttoni.setEnabled(true);
                                activeSeats.add(seat);
                            }
                        }
                    }
                }
            }
        };


        //AcrionListener für alle Komponenten hinzufügen

        for (Component comp : pnlseatss.getComponents()) {
            if (comp instanceof JButton) {
                JButton buttoni = (JButton) comp;
                buttoni.addActionListener(actionListener);
            }
        }
        resText(person);
        kauftText(person);
        lbluhrzeit.setText("Uhrzeit: "+playTime);
    }


    //Farbe für reservierte Seats

    public void setColor(Seats seatList,Person person) {
        for (Component comp : pnlseatss.getComponents()) {
            if (comp instanceof JButton) {
                JButton buttoni = (JButton) comp;
                for (Seat seat : seatList) {
                    if (buttoni.getText().equals(seat.place)) {
                        buttoni.setBackground(new Color(255, 220, 0));
                        buttoni.setEnabled(true);
                        if (!seat.person.equals(person.name)) {
                            buttoni.setEnabled(false);
                        }
                    }
                }
            }
        }
    }


    //Farbe für gekaufte Seats

    public void setBoughtColor(Seats seatList) {
        for (Component comp : pnlseatss.getComponents()) {
            if (comp instanceof JButton) {
                JButton buttoni = (JButton) comp;
                for (Seat seat : seatList) {
                    if (buttoni.getText().equals(seat.place)) {
                        buttoni.setBackground(new Color(255, 0, 0));
                        buttoni.setEnabled(false);
                    }
                }
            }
        }
    }


    //Text für reservierte Seats

    public void resText(Person person){
        places = "  ";
        for (Seat seat: reservedSeats){
            if (seat.person.equals(person.name)){
                places = places + seat.place + ", ";
            }
        }
        places = places.substring(0, places.length()-2);
        txpreserviert.setText("Reservierte Sitze: "+ places);
        places = "";
    }


    //Text für gekaufte Seats

    private void kauftText(Person person){
        places = "  ";
        Main.anzahl=0;
        for (Seat seat: boughtSeats){
            if (seat.person.equals(person.name)) {
                places = places + seat.place + ", ";
                Main.anzahl++;
            }
        }
        places = places.substring(0, places.length()-2);
        txtkaufen.setText("Gekaufte Sitze: "+ places);
        places = "";
    }



}