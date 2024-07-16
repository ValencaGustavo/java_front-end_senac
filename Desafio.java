
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

   // no-argument constructor set up GUI
   public Desafio()
   {
      super("");     

      JMenu fileMenu = new JMenu("Arquivo"); // create file menu
      fileMenu.setMnemonic('F'); // set mnemonic to F
 
      // create About... menu item
      JMenuItem aboutItem = new JMenuItem("Sobre");
      aboutItem.setMnemonic('A'); // set mnemonic to A
      fileMenu.add(aboutItem); // add about item to file menu
      aboutItem.addActionListener(
         new ActionListener() // anonymous inner class
         {  
            // display message dialog when user selects About...
            @Override
            public void actionPerformed(ActionEvent event)
            {
               JOptionPane.showMessageDialog(Desafio.this,
                  "Isso é um exemplo\n",
                  "Sobre", JOptionPane.PLAIN_MESSAGE);
            } 
         } 
      ); 
      
      JMenuItem exitItem = new JMenuItem("Sair"); // create exit item
      exitItem.setMnemonic('x'); // set mnemonic to x
      fileMenu.add(exitItem); // add exit item to file menu
      exitItem.addActionListener(
         new ActionListener() // anonymous inner class
         {  
            // terminate application when user clicks exitItem
            @Override
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0); // exit application
            } 
         }
      ); 


      JMenuBar bar = new JMenuBar(); // create menu bar
      setJMenuBar(bar); // add menu bar to application
      bar.add(fileMenu); // add file menu to menu bar

      JMenu formatMenu = new JMenu("Editar"); // create format menu
      formatMenu.setMnemonic('r'); // set mnemonic to r

      // array listing string colors
      String[] colors = {"Preto", "Azul", "Vermelho", "Verde"};

      JMenu colorMenu = new JMenu("Cores"); // create color menu
      colorMenu.setMnemonic('C'); // set mnemonic to C

      // create radio button menu items for colors
      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup(); // manages colors
      ItemHandler itemHandler = new ItemHandler(); // handler for colors

      // create color radio button menu items
      for (int count = 0; count < colors.length; count++) 
      {
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]); // create item
         colorMenu.add(colorItems[count]); // add item to color menu
         colorButtonGroup.add(colorItems[count]); // add to group
         colorItems[count].addActionListener(itemHandler);
      }

      colorItems[0].setSelected(true); // select first Color item

      formatMenu.add(colorMenu); // add color menu to format menu
      formatMenu.addSeparator(); // add separator in menu

      // array listing font names
      String[] fontNames = {"Serif", "Monospaced", "SansSerif"};
      JMenu fontMenu = new JMenu("Fontes"); // create font menu
      fontMenu.setMnemonic('n'); // set mnemonic to n

      // create radio button menu items for font names
      fonts = new JRadioButtonMenuItem[fontNames.length];
      fontButtonGroup = new ButtonGroup(); // manages font names

      // create Font radio button menu items
      for (int count = 0; count < fonts.length; count++) 
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]); // add font to font menu
         fontButtonGroup.add(fonts[count]); // add to button group
         fonts[count].addActionListener(itemHandler); // add handler
      } 

      fonts[0].setSelected(true); // select first Font menu item
      fontMenu.addSeparator(); // add separator bar to font menu

      String[] styleNames = {"Bold", "Italic"}; // names of styles
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler(); // style handler

      // create style checkbox menu items
      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]); // for style
         fontMenu.add(styleItems[count]); // add to font menu
         styleItems[count].addItemListener(styleHandler); // handler
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

         repaint(); // redraw application
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

