import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Login extends JFrame {

    private final JTextField usuarioJTextField = new JTextField("");
    private final JTextField emailJTextField = new JTextField("");
    private final JPasswordField senhaJPasswordField = new JPasswordField(""); // Alterado para JPasswordField

    private final JButton logarJButton = new JButton("Login");
    private final JButton cadastrarJButton = new JButton("Cadastrar-se >");

    private final JLabel usuarioJLabel = new JLabel("Digite seu nome de usuário", SwingConstants.CENTER);
    private final JLabel emailJLabel = new JLabel("Digite seu email", SwingConstants.CENTER);
    private final JLabel senhaJLabel = new JLabel("Digite sua senha", SwingConstants.CENTER);
    private final JLabel notificacaoJLabel = new JLabel("Notificações");

    private final String dbPadrao = "db_teste";
    private final String tblPadrao = "tbl_teste";

    public Login() {
        super("Tela de Login");
        setLayout(new GridLayout(9, 3, 5, 5));

        logarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String nome = usuarioJTextField.getText();
                String senha = new String(senhaJPasswordField.getPassword());

                try {
                    Connection conexao = MySQLConnector.conectar();
                    String strSqlPesquisarUser = "select * from `" + dbPadrao + "`.`" + tblPadrao + "` where `nome` = ? and `senha` = ?";
                    
                    PreparedStatement login = conexao.prepareStatement(strSqlPesquisarUser);
                    login.setString(1, nome);
                    login.setString(2, senha);

                    ResultSet rstPesquisarUser = login.executeQuery();
                    
                    if (rstPesquisarUser.next()) {
                        EditarCadastro editarcadastro = new EditarCadastro();
                        editarcadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        editarcadastro.setVisible(true);
                        notificacaoJLabel.setText("Login bem-sucedido!");
                    } else {
                        notificacaoJLabel.setText("Usuário ou senha incorretos.");
                    }

                    login.close();
                    conexao.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    notificacaoJLabel.setText("Ocorreu um erro ao logar. Por favor, tente novamente.");
                }
            }
        });

        JPanel linha1 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha2 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha3 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha4 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha5 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha6 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha7 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha8 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha9 = new JPanel(new GridLayout(1, 3, 5, 5));

        add(linha1);
        linha2.add(usuarioJLabel);
        add(linha2);
        linha3.add(usuarioJTextField);
        add(linha3);
        add(linha4);
        linha5.add(senhaJLabel);
        add(linha5);
        linha6.add(senhaJPasswordField);
        add(linha6);
        add(linha7);
        linha8.add(logarJButton);
        linha8.add(cadastrarJButton);
        add(linha8);
        linha9.add(notificacaoJLabel);
        add(linha9);

        setSize(400, 600);
        setVisible(true);

        cadastrarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cadastrar cadastrar = new Cadastrar();
                cadastrar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                cadastrar.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Login application = new Login();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
