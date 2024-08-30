import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame {

    public Menu() {
        super("Tela de Menu");
        setLayout(new GridLayout(9, 3, 5, 5));

        JPanel linha1 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha2 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha3 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha4 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha5 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha6 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha7 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha8 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha9 = new JPanel(new GridLayout(1, 3, 5, 5));

        setSize(800, 460);
        setVisible(true);
    }
    public static void main(String[] args) {
        Menu application = new Menu();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
