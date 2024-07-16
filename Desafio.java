
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Desafio extends JFrame 
{
   private final Color[] colorValues = 
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};   
   private final JRadioButtonMenuItem[] colorItems; 
   private final JRadioButtonMenuItem[] fonts;
   private final JCheckBoxMenuItem[] styleItems; 
   private final JLabel displayJLabel;
   private final ButtonGroup fontButtonGroup;
   private final ButtonGroup colorButtonGroup; 
   private int style; 

   public Desafio()
   {
      super("");     

      JMenu fileMenu = new JMenu("Arquivo"); 
      fileMenu.setMnemonic('F'); 
 
      JMenuItem aboutItem = new JMenuItem("Sobre");
      aboutItem.setMnemonic('A'); 
      fileMenu.add(aboutItem); 
      aboutItem.addActionListener(
         new ActionListener() 
         {  

            @Override
            public void actionPerformed(ActionEvent event)
            {
               JOptionPane.showMessageDialog(Desafio.this,
                  "Isso é um exemplo\n",
                  "Sobre", JOptionPane.PLAIN_MESSAGE);
            } 
         } 
      ); 
      
      JMenuItem exitItem = new JMenuItem("Sair");
      exitItem.setMnemonic('x'); 
      fileMenu.add(exitItem);
      exitItem.addActionListener(
         new ActionListener() 
         {  

            @Override
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            } 
         }
      ); 


      JMenuBar bar = new JMenuBar(); 
      setJMenuBar(bar); 
      bar.add(fileMenu); 

      JMenu formatMenu = new JMenu("Editar"); 
      formatMenu.setMnemonic('r');

      String[] colors = {"Preto", "Azul", "Vermelho", "Verde"};

      JMenu colorMenu = new JMenu("Cores"); 
      colorMenu.setMnemonic('C'); 


      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup(); 
      ItemHandler itemHandler = new ItemHandler(); 


      for (int count = 0; count < colors.length; count++) 
      {
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]); 
         colorMenu.add(colorItems[count]);
         colorButtonGroup.add(colorItems[count]); 
         colorItems[count].addActionListener(itemHandler);
      }

      colorItems[0].setSelected(true); 

      formatMenu.add(colorMenu);
      formatMenu.addSeparator(); 

      String[] fontNames = {"Serif", "Monospaced", "SansSerif"};
      JMenu fontMenu = new JMenu("Fontes"); 
      fontMenu.setMnemonic('n'); 

      fonts = new JRadioButtonMenuItem[fontNames.length];
      fontButtonGroup = new ButtonGroup(); 

      for (int count = 0; count < fonts.length; count++) 
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]);
         fontButtonGroup.add(fonts[count]); 
         fonts[count].addActionListener(itemHandler); 
      } 

      fonts[0].setSelected(true);
      fontMenu.addSeparator();

      String[] styleNames = {"Bold", "Italic"}; 
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler(); 


      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]); 
         fontMenu.add(styleItems[count]); 
         styleItems[count].addItemListener(styleHandler); 
      }

      formatMenu.add(fontMenu);
      bar.add(formatMenu); 
     
      displayJLabel = new JLabel("Texto", SwingConstants.CENTER);
      displayJLabel.setForeground(colorValues[0]);
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));

      getContentPane().setBackground(Color.CYAN);
      add(displayJLabel, BorderLayout.CENTER); 
   } 
   private class ItemHandler implements ActionListener 
   {

      @Override
      public void actionPerformed(ActionEvent event)
      {

         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]);
               break;
            } 
         } 


         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, 72));
            }
         }

         repaint();
      } 
   } 

   private class StyleHandler implements ItemListener 
   {

      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName(); 
         Font font;


         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, 72);
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, 72);
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, 72);
         else
            font = new Font(name, Font.PLAIN, 72);

         displayJLabel.setFont(font);
         repaint();
      } 
   } 
} 

