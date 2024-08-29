import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame {

    // SwingConstants.CENTER
    private final JTextField usuarioJTextField = new JTextField("");
    private final JTextField senhaJTextField = new JTextField("");

    private final JButton logarJButton = new JButton("Iniciar sessão");
    private final JButton cadastrarJButton = new JButton("Cadastrar >");

    private final JLabel usuarioJLabel = new JLabel("Digite seu nome de usuário", SwingConstants.CENTER);
    private final JLabel senhaJLabel = new JLabel("Digite sua senha", SwingConstants.CENTER);

    private final JLabel notificacaoJLabel = new JLabel("Notificações");

    private JCheckBox termsJCheckBox;


    public Login() {
        super("Tela de Login");
        setLayout(new GridLayout(11,3,5,5));

        JPanel linha1 = new JPanel(new GridLayout(1, 3, 5, 5));

        JPanel linha2 = new JPanel(new GridLayout(1, 3, 5, 5));

        JPanel linha3 = new JPanel(new GridLayout(1, 3, 5, 5));

        JPanel linha4 = new JPanel(new GridLayout(1, 3, 5, 5));

        JPanel linha5 = new JPanel(new GridLayout(1, 3, 5, 5));

        JPanel linha6 = new JPanel(new GridLayout(1, 3, 5, 5));

        JPanel linha7 = new JPanel(new GridLayout(1, 3, 5, 5));

        JPanel linha8 = new JPanel(new GridLayout(1, 3, 5, 5));
        
        JPanel linha9 = new JPanel(new GridLayout(1, 3, 5, 5));

        JPanel linha10 = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel linha11 = new JPanel(new GridLayout(1, 3, 5, 5));

        termsJCheckBox = new JCheckBox("Você aceita os termos?");

        add(linha1);

        linha2.add(usuarioJLabel);
        add(linha2);

        linha3.add(usuarioJTextField);
        add(linha3);

        add(linha4);

        linha5.add(senhaJLabel);
        add(linha5);

        linha6.add(senhaJTextField);
        add(linha6);

        add(linha7);

        linha8.add(logarJButton);
        linha8.add(cadastrarJButton);
        add(linha8);

        add(linha9);

        linha10.add(termsJCheckBox);
        add(linha10);

        linha11.add(notificacaoJLabel);
        add(linha11);

        setSize(400, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        Login application = new Login();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}