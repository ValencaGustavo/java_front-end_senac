import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditarCadastro extends JFrame {
    private final JTextField pesquisarJTextField = new JTextField("Digite um nome para pesquisar!");
    private final JButton pesquisarJButton = new JButton("Pesquisar");
    
    private final JTextField idJTextField = new JTextField();
    
    private final JTextField nomeJTextField = new JTextField();
    private String strNome;
    
    private final JTextField emailJTextField = new JTextField();
    private String strEmail;
    
    private final JPasswordField senhaJPasswordField = new JPasswordField();
    
    private final JLabel tituloJLabel = new JLabel("Pesquisar:");
    private final JLabel idJLabel = new JLabel("ID:" );
    private final JLabel nomeJLabel = new JLabel("Digite um nome:" );
    private final JLabel emailJLabel = new JLabel("Digite um email:");
    private final JLabel senhaJLabel = new JLabel("Digite uma senha:" );
    // SwingConstants.CENTER
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");
    
    private final JButton primeiroJButton = new JButton("<<");
    private final JButton anteriorJButton = new JButton("<");
    private final JButton proximoJButton = new JButton(">");
    private final JButton ultimoJButton = new JButton(">>");

    private final JButton novoJButton = new JButton("➕");
    private final JButton clearFieldsJButton = new JButton("🔥");
    private final JButton editarJButton = new JButton("🆙");
    private final JButton deletarJButton = new JButton("♻");

    private final JLabel espacador1 = new JLabel("");
    private final JLabel espacador2 = new JLabel("");
    private final JLabel espacador3 = new JLabel("");
    private final JLabel espacador4 = new JLabel("");
    private final JLabel espacador5 = new JLabel("");
    private final JLabel espacador6 = new JLabel("");
    private final JLabel espacador7 = new JLabel("");
    private final JLabel espacador8 = new JLabel("");

    private final String dbPadrao = "db_teste";
    private final String tblPadrao = "tbl_teste";

    private String ultimoId = "";

    public EditarCadastro() {
        super("Cadastro");
        setLayout(new GridLayout(8,4,5,5));

        JPanel linha1 = new JPanel(new GridLayout(1, 3, 5, 5));

        JPanel linha2 = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel linha3 = new JPanel(new GridLayout(1, 3, 5, 5));

        JPanel linha4 = new JPanel(new GridLayout(1, 3, 5, 5));

        JPanel linha5 = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel linha6 = new JPanel(new GridLayout(1, 4, 5, 5));

        JPanel linha7 = new JPanel(new GridLayout(1, 3, 5, 5));

        JPanel linha8 = new JPanel(new GridLayout(1, 1, 5, 5));

        editarJButton.setToolTipText("Atualizar");
        editarJButton.setEnabled(false);

        pesquisarJButton.setToolTipText("Pesquisar");
        novoJButton.setToolTipText("Novo");
        deletarJButton.setToolTipText("Deletar");

        idJTextField.setEnabled(false);
        primeiroJButton.setEnabled(false);
        anteriorJButton.setEnabled(false);

        pesquisarJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    //... tem que implementar ainda
                }
            }
        );

        editarJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    atualizarRegistro();
                    pesquisarJTextField.setEnabled(true);
                    pesquisarJButton.setEnabled(true);
            }
            }
        );

        primeiroJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    String[] resultado;
                    try {
                        resultado = NavegadorDeRegistro.FirstRegister(dbPadrao, tblPadrao);
                        idJTextField.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        strNome = nomeJTextField.getText();
                        emailJTextField.setText(resultado[2]);
                        strEmail = emailJTextField.getText();
                        editarJButton.setEnabled(false);
                        primeiroJButton.setEnabled(false);
                        anteriorJButton.setEnabled(false);
                        proximoJButton.setEnabled(true);
                        ultimoJButton.setEnabled(true);
                        notificacaoJLabel.setText("Primeiro registro posicionado com sucesso.");
                    } catch(Exception e) {
                        System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o primeiro. Veja o erro: " + e);
                        notificacaoJLabel.setText("Ops! Alguma coisa aconteceu que não foi possível posicionar o primeiro registro.");
                        return;
                    }
                }
            }
        );

        anteriorJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    if (idJTextField.getText().length() > 0) {
                        String[] resultado;
                        try {
                            resultado = NavegadorDeRegistro.PreviousRegister(dbPadrao, tblPadrao, idJTextField.getText());
                            if (resultado != null) {
                                idJTextField.setText(resultado[0]);
                                nomeJTextField.setText(resultado[1]);
                                strNome = nomeJTextField.getText();
                                emailJTextField.setText(resultado[2]);
                                strEmail = emailJTextField.getText();
                                editarJButton.setEnabled(false);
                                proximoJButton.setEnabled(true);
                                ultimoJButton.setEnabled(true);
                                notificacaoJLabel.setText("Registro retrocedido com sucesso.");
                            } else {
                                primeiroJButton.setEnabled(false);
                                anteriorJButton.setEnabled(false);
                                notificacaoJLabel.setText("Já está no primeiro registro, por isso não é possível retroceder ao registro anterior.");
                            }
                        } catch(Exception e) {
                            System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o primeiro. Veja o erro: " + e);
                            return;
                        }
                    } else {
                        notificacaoJLabel.setText("Não foi possível retroceder o registro, pois não há um id válido atual.");
                    }
                }
            }
        );

        proximoJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    if (idJTextField.getText().length() > 0) {
                        String[] resultado;
                        try {
                            resultado = NavegadorDeRegistro.NextRegister(dbPadrao, tblPadrao, idJTextField.getText());
                            if (resultado != null) {
                                idJTextField.setText(resultado[0]);
                                nomeJTextField.setText(resultado[1]);
                                strNome = nomeJTextField.getText();
                                emailJTextField.setText(resultado[2]);
                                strEmail = emailJTextField.getText();
                                editarJButton.setEnabled(false);
                                primeiroJButton.setEnabled(true);
                                anteriorJButton.setEnabled(true);
                                notificacaoJLabel.setText("Registro avançado com sucesso.");
                            } else {
                                notificacaoJLabel.setText("Já está no último registro, por isso não é possível avançar o registro.");
                                proximoJButton.setEnabled(false);
                                ultimoJButton.setEnabled(false);
                            }
                        } catch(Exception e) {
                            System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o próximo. Veja o erro: " + e);
                            return;
                        }
                    } else {
                        notificacaoJLabel.setText("Não foi possível avançar o registro, pois não há um id válido atual.");
                    }
                }
            }
        );

        ultimoJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    try {
                        String[] resultado = NavegadorDeRegistro.LastRegister(dbPadrao, tblPadrao);
                        idJTextField.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        strNome = nomeJTextField.getText();
                        emailJTextField.setText(resultado[2]);
                        strEmail = emailJTextField.getText();
                        editarJButton.setEnabled(false);
                        proximoJButton.setEnabled(false);
                        ultimoJButton.setEnabled(false);
                        primeiroJButton.setEnabled(true);
                        anteriorJButton.setEnabled(true);
                        notificacaoJLabel.setText("Último registro posicionado com sucesso.");
                    } catch(Exception e) {
                        System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o último. Veja o erro: " + e);
                        return;
                    }
                }
            }
        );

        // clearJButton.addActionListener(
        //     new ActionListener() {
        //         public void actionPerformed(ActionEvent event) {
        //             try {
        //                 String[] resultado = NavegadorDeRegistro.clearRegistro(dbPadrao, tblPadrao);
        //                 idJTextField.setText(" ");
        //                 nomeJTextField.setText(" ");
        //                 strNome = nomeJTextField.getText();
        //                 emailJTextField.setText(" ");
        //                 strEmail = emailJTextField.getText();
        //                 editarJButton.setEnabled(false);
        //                 proximoJButton.setEnabled(false);
        //                 ultimoJButton.setEnabled(false);
        //                 primeiroJButton.setEnabled(true);
        //                 anteriorJButton.setEnabled(true);
        //                 notificacaoJLabel.setText("Último registro posicionado com sucesso.");
        //             } catch(Exception e) {
        //                 System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o último. Veja o erro: " + e);
        //                 return;
        //             }
        //         }
        //     }
        // );


        novoJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    try {
                        ultimoId = idJTextField.getText();
                        idJTextField.setText("");
                        nomeJTextField.setText("");
                        strNome = "";
                        emailJTextField.setText("");
                        strEmail = "";
                        senhaJPasswordField.setText("");
                        editarJButton.setEnabled(true);
                        novoJButton.setEnabled(true);
                        pesquisarJButton.setEnabled(false);
                        deletarJButton.setEnabled(true);

                        primeiroJButton.setEnabled(false);
                        anteriorJButton.setEnabled(false);
                        proximoJButton.setEnabled(false);
                        ultimoJButton.setEnabled(false);

                        pesquisarJTextField.setEnabled(false);
                        pesquisarJButton.setEnabled(false);

                        nomeJTextField.requestFocus();

                        notificacaoJLabel.setText("Digite nome, email e senha.");
                    } catch(Exception e) {
                        System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o último. Veja o erro: " + e);
                        return;
                    }
                }
            }
        );

        deletarJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    String[] resultado;
                    if (idJTextField.getText().trim().length() > 0) {
                        try {
                            resultado = NavegadorDeRegistro.deleteRegister(dbPadrao, tblPadrao, idJTextField.getText());
                            if (resultado.length > 0) {
                                idJTextField.setText(resultado[0]);
                                nomeJTextField.setText(resultado[1]);
                                strNome = nomeJTextField.getText();
                                emailJTextField.setText(resultado[2]);
                                strEmail = emailJTextField.getText();
                                editarJButton.setEnabled(false);
                                primeiroJButton.setEnabled(true);
                                anteriorJButton.setEnabled(true);
                                notificacaoJLabel.setText("Registro apagado e avançado com sucesso.");
                            } else {
                                notificacaoJLabel.setText("Já está no último registro, por isso não é possível avançar o registro.");
                            }
                        } catch(Exception e) {
                            System.out.println("Ops! Ocorreu algum erro ao deletar o registro. Veja o erro: " + e);
                            return;
                        }
                    } else {
                        try {
                            resultado = NavegadorDeRegistro.irParaId(dbPadrao, tblPadrao, ultimoId);
                            if (resultado.length > 0) {
                                idJTextField.setText(resultado[0]);
                                nomeJTextField.setText(resultado[1]);
                                strNome = nomeJTextField.getText();
                                emailJTextField.setText(resultado[2]);
                                strEmail = emailJTextField.getText();
                                editarJButton.setEnabled(false);
                                primeiroJButton.setEnabled(true);
                                anteriorJButton.setEnabled(true);
                                proximoJButton.setEnabled(true);
                                ultimoJButton.setEnabled(true);
                                novoJButton.setEnabled(true);
                                pesquisarJTextField.setEnabled(true);
                                pesquisarJButton.setEnabled(true);
                                notificacaoJLabel.setText("Registro apagado e avançado com sucesso.");
                            } else {
                                notificacaoJLabel.setText("Já está no último registro, por isso não é possível avançar o registro.");
                            }
                        } catch (Exception e) {
                            System.out.println("Ops! Ocurreu um erro, veja: " + e);
                            return;
                        }
                    }
                }
            }
        );

        nomeJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                verificarCampos();
            }
        });

        emailJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                verificarCampos();
            }
        });

        senhaJPasswordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                verificarCampos();
                if(e.getKeyCode() == 10 && idJTextField.getText().length() == 0) {
                    if (nomeJTextField.getText().trim().length() == 0) {
                        JOptionPane.showMessageDialog(linha8, "Ops! Tem que digitar o nome", "Mensagem de erro", JOptionPane.PLAIN_MESSAGE);
                        nomeJTextField.requestFocus();
                        return;
                    }
                    if (emailJTextField.getText().trim().length() == 0) {
                        JOptionPane.showMessageDialog(linha8, "Ops! Tem que digitar o email", "Mensagem de erro", JOptionPane.PLAIN_MESSAGE);
                        emailJTextField.requestFocus();
                        return;
                    }
                    if (senhaJPasswordField.getPassword().length == 0) {
                        JOptionPane.showMessageDialog(linha8, "Ops! Tem que digitar a senha", "Mensagem de erro", JOptionPane.PLAIN_MESSAGE);
                        senhaJPasswordField.requestFocus();
                        return;
                    }
                    atualizarRegistro();
                }
            }
        });


        linha1.add(tituloJLabel);
        linha1.add(pesquisarJTextField);
        add(linha1);

        linha2.add(novoJButton);
        linha2.add(espacador1);
        linha2.add(idJLabel);
        linha2.add(idJTextField);
        add(linha2);

        linha3.add(deletarJButton);
        linha3.add(espacador2);
        linha3.add(nomeJLabel);
        linha3.add(nomeJTextField);
        add(linha3);

        linha4.add(editarJButton);
        linha4.add(espacador8);
        linha4.add(emailJLabel);
        linha4.add(emailJTextField);
        add(linha4);

        linha5.add(clearFieldsJButton);
        linha5.add(espacador3);
        linha5.add(senhaJLabel);
        linha5.add(senhaJPasswordField);
        add(linha5);

        linha6.add(espacador6);
        add(linha6);

        linha7.add(primeiroJButton);
        linha7.add(anteriorJButton);
        linha7.add(proximoJButton);
        linha7.add(ultimoJButton);
        add(linha7);

        setSize(600, 300);
        iniciarCampos();
        setVisible(true);
    }

    public void verificarCampos() {
        if (!strNome.equals(nomeJTextField.getText())) {
            editarJButton.setEnabled(true);
        } else if (!strEmail.equals(emailJTextField.getText())) {
            editarJButton.setEnabled(true);
        } else if (senhaJPasswordField.getPassword().length > 0) {
            editarJButton.setEnabled(true);
        } else {
            editarJButton.setEnabled(false);
        }
    }

    public void atualizarRegistro() {
        boolean atualizou = false;
        if (idJTextField.getText().trim().equals("")) {
            try {
                if (nomeJTextField.getText().trim().equals("")) {
                    notificacaoJLabel.setText("Ops! Tem que digitar o nome.");
                    nomeJTextField.requestFocus();
                    return;
                }
                if (emailJTextField.getText().trim().equals("")) {
                    notificacaoJLabel.setText("Ops! Tem que digitar o email.");
                    emailJTextField.requestFocus();
                    return;
                }
                if (senhaJPasswordField.getPassword().length == 0) {
                    notificacaoJLabel.setText("Ops! Tem que digitar a senha.");
                    senhaJPasswordField.requestFocus();
                    return;
                }
                atualizou = NavegadorDeRegistro.createRegister(dbPadrao, tblPadrao, nomeJTextField.getText(), emailJTextField.getText(), senhaJPasswordField.getPassword());
                novoJButton.setEnabled(true);
                pesquisarJButton.setEnabled(true);
                editarJButton.setEnabled(false);

                String[] resultado = NavegadorDeRegistro.LastRegister(dbPadrao, tblPadrao);
                idJTextField.setText(resultado[0]);
                nomeJTextField.setText(resultado[1]);
                strNome = nomeJTextField.getText();
                emailJTextField.setText(resultado[2]);
                strEmail = emailJTextField.getText();
                editarJButton.setEnabled(false);
                proximoJButton.setEnabled(false);
                ultimoJButton.setEnabled(false);
                primeiroJButton.setEnabled(true);
                anteriorJButton.setEnabled(true);
                notificacaoJLabel.setText("Cadastro inserido com sucesso!");
            } catch (Exception e) {
                System.out.println("Ops! Deu ruim, veja o erro: " + e);
                notificacaoJLabel.setText("Deu ruim o cadastro...");
            }
        } else {
            try {
                atualizou = NavegadorDeRegistro.updateCadastro(dbPadrao, tblPadrao, idJTextField.getText(), nomeJTextField.getText(), emailJTextField.getText(), senhaJPasswordField.getPassword());
                notificacaoJLabel.setText("Cadastro atualizado com sucesso!");
                editarJButton.setEnabled(false);
            } catch (Exception e) {
                System.out.println("Ops! Deu ruim, veja o erro: " + e);
                notificacaoJLabel.setText("Deu ruim atualizar o cadastro...");
            }
        }
    }

    public void iniciarCampos() {
        try {
            String[] resultado = NavegadorDeRegistro.FirstRegister(dbPadrao, tblPadrao);
            notificacaoJLabel.setText("Primeio registro posicionado com sucesso");
            if (resultado != null) {
                idJTextField.setText(resultado[0]);
                nomeJTextField.setText(resultado[1]);
                strNome = nomeJTextField.getText();
                emailJTextField.setText(resultado[2]);
                strEmail = emailJTextField.getText();
                editarJButton.setEnabled(false);
            } else {
                notificacaoJLabel.setText("Já está no primeiro registro, por isso não é possível retroceder ao registro anterior.");
            }
        } catch(Exception e) {
            System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o primeiro. Veja o erro: " + e);
        }
    }

    public static void main(String[] args) {
        EditarCadastro application = new EditarCadastro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}