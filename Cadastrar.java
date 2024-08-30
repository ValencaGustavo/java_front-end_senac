import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Cadastrar extends JFrame {

    private final JTextField usuarioJTextField = new JTextField("");
    private final JTextField emailJTextField = new JTextField("");
    private final JTextField senhaJPasswordField = new JPasswordField("");

    private final JButton logarJButton = new JButton("Login >");
    private final JButton cadastrarJButton = new JButton("Concluir cadastro");

    private final JLabel usuarioJLabel = new JLabel("Digite seu nome de usuário", SwingConstants.CENTER);
    private final JLabel emailJLabel = new JLabel("Digite seu email", SwingConstants.CENTER);
    private final JLabel senhaJLabel = new JLabel("Digite sua senha", SwingConstants.CENTER);
    private final JLabel notificacaoJLabel = new JLabel("Notificações");

    private final JCheckBox termsJCheckBox = new JCheckBox("Você aceita os termos?");

    private final String dbPadrao = "db_teste";
    private final String tblPadrao = "tbl_teste";

    public Cadastrar() {
        super("Tela de Cadastro");
        setLayout(new GridLayout(12, 3, 5, 5));

        cadastrarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String nome = usuarioJTextField.getText();
                String email = emailJTextField.getText();
                String senha = senhaJPasswordField.getText();

                if (termsJCheckBox.isSelected()) {
                    try {
                        Connection conexao = MySQLConnector.conectar();
                        String strSqlPesquisarEmail = "select * from `" + dbPadrao + "`.`" + tblPadrao + "` where `email` = '" + email + "';";
                        Statement stmSqlPesquisarEmail = conexao.createStatement();
                        ResultSet rstPesquisarEmail = stmSqlPesquisarEmail.executeQuery(strSqlPesquisarEmail);

                        if (rstPesquisarEmail.next()) {
                            notificacaoJLabel.setText("Ops! Parece que há um cadastro com esse email. Por favor, verifique e tente novamente com outro email.");
                        } else {
                            NavegadorDeRegistro.cadastrar1(dbPadrao, tblPadrao, "nome", "email", "senha", nome, email, senha);
                            dispose();
                        }
                        stmSqlPesquisarEmail.close();
                        conexao.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        notificacaoJLabel.setText("Ocorreu um erro ao cadastrar. Por favor, tente novamente.");
                    }
                } else {
                    notificacaoJLabel.setText("Você deve aceitar os termos para cadastrar-se.");
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
        JPanel linha10 = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha11 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha12 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha13 = new JPanel(new GridLayout(1, 3, 5, 5));

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

        logarJButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                login.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Cadastrar application = new Cadastrar();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
