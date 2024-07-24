import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameNome extends JFrame {

    private final JTextField nomeJTextField = new JTextField();
    private final JTextField emailJTextField = new JTextField();
    private final JTextField senhaJTextField = new JTextField();
    private final JButton cadastrarJButton = new JButton("Cadastrar");
    private final JLabel nomeJLabel = new JLabel("Digite um nome abaixo!");
    private final JLabel emailJLabel = new JLabel("Digite um email abaixo!");
    private final JLabel senhaJLabel = new JLabel("Digite uma senha abaixo!");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");

    public FrameNome()
    {
       super("Cadastro");
       setLayout(new GridLayout(4, 1, 5, 5));

       cadastrarJButton.addActionListener(
        new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
            
            String nome;
            String email;
            String senha;
            try {
                nome = nomeJTextField.getText();
                email = emailJTextField.getText();
                senha = senhaJTextField.getText();
                InserirRegistro.cadastrar("db_teste", "tbl_teste", "nome", "email", "senha", nome, email, senha);

            } catch(NumberFormatException ex) {
                System.out.println("Digite uma coisa!");
                return;
            }
        }
        
    }
       );

    add(nomeJLabel);
    add(nomeJTextField);
    setSize(275, 275);
    setVisible(true);

    add(emailJLabel);
    add(emailJTextField);;
    setSize(275, 275);
    setVisible(true);

    add(senhaJLabel);
    add(senhaJTextField);
    add(cadastrarJButton);
    setSize(275, 275);
    setVisible(true);
    }

    public static void main(String[] args) {
        FrameNome application = new FrameNome();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}