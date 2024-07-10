import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Tela extends JPanel
{

   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
 
      g.setColor(Color.BLUE);
      g.fillRect(20, 40, 100, 50);
      g.setFont(new Font("Arial", Font.ITALIC, 22));
      g.drawString("Senac", 20, 30);
   } 
}

