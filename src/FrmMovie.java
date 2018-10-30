import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrmMovie {

    //Eigenschaften
    public JPanel pnlMovie;
    public JPanel panel;
    private JButton logOutButton;
    private JLabel label;
    public Movies movies;

    //Constructor

    public FrmMovie(Movies movs, Person person) {

        pnlMovie.setName("Movie Form");
        this.movies = movs;
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    JButton button = (JButton)e.getSource();
                    Main.selectedMovie = movies.getMovieById(Integer.valueOf(button.getName()));
                    Main.mainFrame.setVisible(false);
                    Main.frmPresentation = new FrmPresentation(Main.selectedMovie, person);
                    Main.mainFrame.setContentPane(Main.frmPresentation.pnlPresentation);
                    Main.mainFrame.pack();
                    Main.mainFrame.setVisible(true);
                }
            }
        };
        Movies movieList = new Movies();
        movieList = movieList.getMovies();


        //Bilder automatisch generieren

        panel.setLayout(new FlowLayout());
        for(Movie mov : movieList){
            JPanel content = new JPanel();
            content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
            JButton button = new JButton();
            try {
                String path = mov.imagePath;
                Image img = ImageIO.read(getClass().getResource(path));
                button.setIcon(new ImageIcon(img));
            } catch (Exception ex) {
                System.out.println(ex);
            }
            button.setName("" + mov.id);
            button.addActionListener(actionListener);
            content.add(button);
            panel.add(content);
        }


        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mainFrame.setVisible(false);
                Main.frmloggin = new FrmLogin();
                Main.mainFrame.setContentPane(Main.frmloggin.pnlogin);
                Main.mainFrame.pack();
                Main.mainFrame.setVisible(true);
            }
        });
        label.setText("User: "+person.name);
    }

}
