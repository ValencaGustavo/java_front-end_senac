import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditorCadastro extends JFrame {
    private final JTextField idJTextField = new JTextField();
    private final JTextField nomeJTextField = new JTextField();
    private final JTextField emailJTextField = new JTextField();
    private final JTextField senhaJTextField = new JTextField();
    private final JButton updateJButton = new JButton("^");
    private final JButton nextJButton = new JButton(">");
    private final JButton previousJButton = new JButton("<");
    private final JButton firstJButton = new JButton("<<");
    private final JButton lastJButton = new JButton(">>");
    private final JButton createRegistroJButton = new JButton("Criar Registro");
    private final JButton deleteRegistroJButton = new JButton("Deletar Registro");
    private final JButton updateRegistroJButton = new JButton("Atualizar Registro");
    private final JButton searchRegistroJButton = new JButton("Pesquisar Registro");
    private final JButton limparRegistroJButton = new JButton("Limpar Registro");
    private final JLabel idJLabel = new JLabel("Id:");
    private final JLabel nomeJLabel = new JLabel("Digite um nome:");
    private final JLabel emailJLabel = new JLabel("Digite um email:");
    private final JLabel senhaJLabel = new JLabel("Digite uma senha:");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");
    private final JLabel espacadorLabel = new JLabel("");
    private final JLabel espacador2Label = new JLabel("");
    private final JLabel espacador3Label = new JLabel("");
    private final JLabel espacador4Label = new JLabel("");
    private final JLabel espacador5Label = new JLabel("");
    private final JLabel espacador6Label = new JLabel("");
    private final JLabel espacador7Label = new JLabel("");
    
    public EditorCadastro()
    {
        super("Cadastrar");
        setLayout(new GridLayout(6, 4, 10, 10));

        firstJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String[] resultado;
                    try {
                        resultado = NavegadorDeRegistro.FirstRegister("db_teste", "tbl_teste");
                        notificacaoJLabel.setText("Primeiro registro");
                        idJTextField.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        senhaJTextField.setText(resultado[3]);
                        firstJButton.setEnabled(false);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);
                        previousJButton.setEnabled(false);
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o primeiro registro. Erro: "+ e);
                    }
                }
            }
        );

        previousJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String[] resultado;
                    try {
                        resultado = NavegadorDeRegistro.PreviousRegister("db_teste", "tbl_teste", idJTextField.getText());
                        idJTextField.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        senhaJTextField.setText(resultado[3]);
                        firstJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);
                        
                        notificacaoJLabel.setText("Registro Anterior");
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o primeiro registro. Erro: "+ e);
                    }
                }
            }
            );

            nextJButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        String[] resultado;
                        try {
                            resultado = NavegadorDeRegistro.NextRegister("db_teste", "tbl_teste", idJTextField.getText());
                            idJTextField.setText(resultado[0]);
                            nomeJTextField.setText(resultado[1]);
                            emailJTextField.setText(resultado[2]);
                            senhaJTextField.setText(resultado[3]);
                            nextJButton.setEnabled(true);
                            previousJButton.setEnabled(true);
                            firstJButton.setEnabled(true);
                            
                            notificacaoJLabel.setText("Próximo Registro");
                        } catch (Exception e) {
                            System.out.println("Opsss!! Ocorreu um erro ao posicionar o primeiro registro. Erro: "+ e);
                        }
                    }
                }
                );

        lastJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String[] resultado;
                    try {
                        resultado = NavegadorDeRegistro.LastRegister("db_teste", "tbl_teste");
                        notificacaoJLabel.setText("Último registro");
                        idJTextField.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        senhaJTextField.setText(resultado[3]);
                        nextJButton.setEnabled(false);
                        lastJButton.setEnabled(false);
                        previousJButton.setEnabled(true);
                        firstJButton.setEnabled(true);
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o primeiro registro. Erro: "+ e);
                    }
                }
            }
        );

        createRegistroJButton.addActionListener(
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
                    NavegadorDeRegistro.cadastrar("db_teste", "tbl_teste", "nome", "email", "senha", nome, email, senha);
    
                } catch(NumberFormatException ex) {
                    System.out.println("Digite uma coisa!");
                    return;
                }
            }
            
        }
           );
        
           deleteRegistroJButton.addActionListener(
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
                    NavegadorDeRegistro.descadastrar("db_teste", "tbl_teste", "nome", "email", "senha", nome, email, senha);
    
                } catch(NumberFormatException ex) {
                    System.out.println("Digite uma coisa!");
                    return;
                }
            }
            
        }
           );
        
           updateJButton.addActionListener(
            new ActionListener()
            {
               public void actionPerformed(ActionEvent event)
               {
                
                String nome;
                String email;
                String senha;
                String id;
                try {
                    nome = nomeJTextField.getText();
                    email = emailJTextField.getText();
                    senha = senhaJTextField.getText();
                    id = idJTextField.getText();
                    NavegadorDeRegistro.updateCadastro("db_teste", "tbl_teste", nome, email, senha, id);
    
                } catch(NumberFormatException ex) {
                    System.out.println("Digite uma coisa!");
                    return;
                }
            }
            
        }
           );

           searchRegistroJButton.addActionListener(
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
                    NavegadorDeRegistro.pesquisar("db_teste", "tbl_teste", nome, email, senha);
    
                } catch(NumberFormatException ex) {
                    System.out.println("Digite uma coisa!");
                    return;
                }
            }
            
        }
           );

           limparRegistroJButton.addActionListener(
            new ActionListener()
            {
               public void actionPerformed(ActionEvent event)
               {
                
                String nome;
                String email;
                String senha;
                String id;
                try {
                    nome = nomeJTextField.getText();
                    email = emailJTextField.getText();
                    senha = senhaJTextField.getText();
                    id = idJTextField.getText();
                    NavegadorDeRegistro.limpar("db_teste", "tbl_teste", nome, email, senha, id);
    
                } catch(NumberFormatException ex) {
                    System.out.println("Digite uma coisa!");
                    return;
                }
            }
            
        }
           );

            add(idJLabel);
            add(idJTextField);
            add(updateJButton);
            add(espacadorLabel);
            idJTextField.setEditable(false);
        
            add(nomeJLabel);
            add(nomeJTextField);
            add(espacador2Label);
            add(espacador3Label);
            
            add(emailJLabel);
            add(emailJTextField);
            add(espacador4Label);
            add(espacador5Label);
            
            add(senhaJLabel);
            add(senhaJTextField);
            add(espacador6Label);
            add(espacador7Label);

            add(firstJButton);
            add(previousJButton);
            add(nextJButton);
            add(lastJButton);
            add(createRegistroJButton);
            add(deleteRegistroJButton);
            add(searchRegistroJButton);
            add(limparRegistroJButton);


            
            setSize(600, 300);
            setVisible(true);

    }
    public static void main(String[] args) {
        
        EditorCadastro application = new EditorCadastro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
}