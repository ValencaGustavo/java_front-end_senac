import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class LinesRectsOvalsJPanel extends JPanel 
{

   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.WHITE);

      Font font = new Font("Serif", Font.BOLD, 12);

      g.setFont(font);
      g.drawString("RED LINE: ", 5, 28);
      g.setColor(Color.RED);
      g.drawLine(5, 30, 380, 30);

      g.setColor(Color.BLUE);
      g.drawString("BLUE RECT: ", 5, 110);
      g.drawRect(5, 40, 90, 55);
      g.drawString("BLUE FILL: ", 100, 110);
      g.fillRect(100, 40, 90, 55);

      g.setColor(Color.BLACK);
      g.drawString("BLACK RECT: ", 195, 110);
      g.fillRoundRect(195, 40, 90, 55, 50, 50);
      g.drawString("BLACK FILL: ", 295, 110);
      g.drawRoundRect(290, 40, 90, 55, 20, 20);

      g.setColor(Color.GREEN);   
      g.drawString("GREEN RECT: ", 5, 190);
      g.draw3DRect(5, 120, 90, 55, true);
      g.drawString("GREEN FILL: ", 100, 190);
      g.fill3DRect(100, 120, 90, 55, false);

      g.setColor(Color.MAGENTA);
      g.drawString("MAGENTA RECT: ", 188, 190);
      g.drawOval(195, 120, 90, 55);
      g.drawString("MAGENTA FILL: ", 295, 190);
      g.fillOval(290, 120, 90, 55);
   } 
} 