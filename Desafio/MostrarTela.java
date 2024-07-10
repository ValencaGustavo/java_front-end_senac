// Fig. 13.12: Fonts.java
// Using fonts.
import javax.swing.JFrame;

public class MostrarTela 
{

   public static void main(String[] args)
   {

      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Tela fontJPanel = new Tela();
      frame.add(fontJPanel); 
      frame.setSize(420, 150);
      frame.setVisible(true);
   } 
} 