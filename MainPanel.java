import javax.swing.*; // IMPORTA TODOS OS MÓDULOS DA BIBLIOTECA
import java.awt.*; // IMPORTA TODAS AS BIBLIOTECAS DO JAVA
import java.awt.event.ActionEvent; //
import java.awt.event.ActionListener; //

public class MainPanel extends JFrame {

    private DrawingPanel panel1, panel2, panel3;
    private Color color = Color.LIGHT_GRAY;
    

    public MainPanel() {
        setTitle("Exemplo de JPanel com PaintComponent"); // Definindo um título para...
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Definindo a operação para fechar o JFRAME
        setLayout(new BorderLayout()); // Definindo o Layout para uma nova borda

        // Cria os painéis de desenho
        panel1 = new DrawingPanel(1); // Criando um novo Painel
        panel2 = new DrawingPanel(2); // Criando um novo Painel (Panel2)
        panel3 = new DrawingPanel(3); // Criando um novo Painel (Panel3)

        // Adiciona os painéis ao JFrame
        add(panel1, BorderLayout.WEST); // Adiciona o Painel 1 para a borda leste
        add(panel2, BorderLayout.CENTER); // Adiciona o Painel 2 para a borda do centro
        add(panel3, BorderLayout.EAST); // Adiciona o Painel 3 para a borda oeste

        // Cria o botão para alterar as cores
        JButton button = new JButton("Alterar Cores"); // Cria um botão 
        button.addActionListener(new ActionListener() { // Está invocando o método addActionListener e está enviando para o parâmetro
            @Override // SOBRESCREVER
            public void actionPerformed(ActionEvent e) { // Criando um novo método público sem retorno do parâmetro "e" do tipo ActionEvent

                color = JColorChooser.showDialog(
                MainPanel.this, "Choose a color", color);

                // Gera uma cor aleatória
                Color newColor1 = color; // Criar uma nova cor (Color1)
                Color newColor2 = color; // Criar uma nova cor (Color2)
                Color newColor3 = color; // Criar uma nova cor (Color3)

                // Define as novas cores nos painéis
                panel1.setColor(newColor1); // Define a cor do Painel 1 para a Cor 1
                panel2.setColor(newColor2); // Define a cor do Painel 2 para a Cor 2
                panel3.setColor(newColor3); // Define a cor do Painel 3 para a Cor 3
            }
        });

        // Adiciona o botão ao JFrame
        add(button, BorderLayout.SOUTH);

        // Configura o tamanho do JFrame e exibe-o
        setSize(600, 400); // Define o tamanho do JFrame
        setVisible(true); // Define o JFrame vísivel
    }

    // Método para gerar uma cor aleatória
    private Color getRandomColor() { //
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b); // Retorna uma nova cor
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainPanel();
            }
        });
    }
}