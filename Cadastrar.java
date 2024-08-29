import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cadastrar extends JFrame {

    // SwingConstants.CENTER
    private final JTextField usuarioJTextField = new JTextField("");
    private final JTextField emailJTextField = new JTextField("");
    private final JTextField senhaJPasswordField = new JTextField("");

    private final JButton logarJButton = new JButton("Login >");
    private final JButton cadastrarJButton = new JButton("Cadastrar");

    private final JLabel usuarioJLabel = new JLabel("Digite seu nome de usuário", SwingConstants.CENTER);
    private final JLabel emailJLabel = new JLabel("Digite seu email", SwingConstants.CENTER);
    private final JLabel senhaJLabel = new JLabel("Digite sua senha", SwingConstants.CENTER);
    private final JLabel notificacaoJLabel = new JLabel("Notificações");

    private final String dbPadrao = "db_teste";
    private final String tblPadrao = "tbl_teste";

    private JCheckBox termsJCheckBox;


    public Cadastrar() {
        super("Tela de Cadastro");
        setLayout(new GridLayout(13,3,5,5));

        cadastrarJButton.addActionListener(
            new ActionListener()
            {
               public void actionPerformed(ActionEvent event)
               {
                
                String nome;
                String email;
                String senha;
                try {
                    nome = usuarioJTextField.getText();
                    email = emailJTextField.getText();
                    senha = senhaJPasswordField.getText();
                    NavegadorDeRegistro.createRegister(dbPadrao, tblPadrao, usuarioJTextField.getText(), emailJTextField.getText(), senhaJPasswordField.getPassword());
    
                } catch(NumberFormatException ex) {
                    System.out.println("Digite uma coisa!");
                    return;
                }
            }
            
        }
           );

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

        JPanel linha12 = new JPanel(new GridLayout(1, 3, 5, 5));

        JPanel linha13 = new JPanel(new GridLayout(1, 3, 5, 5));

        termsJCheckBox = new JCheckBox("Você aceita os termos?");

        add(linha1);

        linha2.add(usuarioJLabel);
        add(linha2);

        linha3.add(usuarioJTextField);
        add(linha3);

        linha5.add(emailJLabel);
        add(linha5);

        linha6.add(emailJTextField);
        add(linha6);

        linha7.add(senhaJLabel);
        add(linha7);

        linha8.add(senhaJPasswordField);
        add(linha8);

        add(linha9);

        linha10.add(cadastrarJButton);
        linha10.add(logarJButton);
        add(linha10);

        add(linha11);

        linha12.add(termsJCheckBox);
        add(linha12);

        linha13.add(notificacaoJLabel);
        add(linha13);

        setSize(400, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        Cadastrar application = new Cadastrar();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}