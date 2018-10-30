import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class FrmPresentation {

    //Eigenschaften

    public JPanel pnlPresentation;
    private JLabel lblImage;
    private JLabel lblTitle;
    private JLabel lblDescription;
    private JLabel lblDuration;
    private JButton btnkaufen;
    private JButton btnMenu;
    private JButton a2015Button;
    public static int price;
    private JButton btntime;
    ActionListener actionListener;
    Presentations presis;
    Movies movies;

    //Constructor

    public FrmPresentation(Movie selectedMovie, Person person) {
        pnlPresentation.setName("Presentation Form");
        try {
            String path = selectedMovie.imagePath;
            Image img = ImageIO.read(getClass().getResource(path));
            lblImage.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        lblTitle.setText("Der Film heisst: "+selectedMovie.title);
        lblDescription.setText("Filmbeschreibung: "+ selectedMovie.description);
        lblDuration.setText(String.format("Der Film dauert %d Minuten.", selectedMovie.duration));

        btnkaufen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    JButton button = (JButton)e.getSource();
                    Main.mainFrame.setVisible(false);
                    Main.frmSeating = new FrmSeating(selectedMovie, "16:30", person);
                    Main.mainFrame.setContentPane(Main.frmSeating.pnlSeats);
                    Main.mainFrame.pack();
                    Main.mainFrame.setVisible(true);
                    price=13;
                }
            }
        });
        a2015Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    JButton button1 = (JButton)e.getSource();
                    Main.mainFrame.setVisible(false);
                    Main.frmSeating = new FrmSeating(selectedMovie, "20:15", person);
                    Main.mainFrame.setContentPane(Main.frmSeating.pnlSeats);
                    Main.mainFrame.pack();
                    Main.mainFrame.setVisible(true);
                    price=15;
                }
            }
        });
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    JButton button = (JButton) e.getSource();
                    Main.mainFrame.setVisible(false);
                    Main.frmMovie = new FrmMovie(Movies.getMovies(), person);
                    Main.mainFrame.setContentPane(Main.frmMovie.pnlMovie);
                    Main.mainFrame.pack();
                    Main.mainFrame.setVisible(true);
                }
            }
        });

    }


}

