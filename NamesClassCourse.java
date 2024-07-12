// Fig. 12.21: ComboBoxFrame.java
// JComboBox that displays a list of image names.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NamesClassCourse extends JFrame 
{
   private final JComboBox<String> imagesJComboBox; // hold icon names
   private final JLabel label; // displays selected icon

   private static final String[] names = 
   {"Gustavo", "Douglas",  "Gabriel", "João victor Farias", "Lucas", "Matheus", "Daniel", "Júlio", "Angelo", "Enrique", "Germano", "Felipe", "Rafael"};

   // ComboBoxFrame constructor adds JComboBox to JFrame
   public NamesClassCourse()
   {
      super("Testing JComboBox");
      setLayout(new FlowLayout()); // set frame layout     

      imagesJComboBox = new JComboBox<String>(names); // set up JComboBox
      imagesJComboBox.setMaximumRowCount(3); // display three rows

      add(imagesJComboBox); // add combobox to JFrame
      label = new JLabel(names[0]); // display first icon
      add(label); // add label to JFramea
      imagesJComboBox.addItemListener(event -> { 
           if (event.getStateChange() == ItemEvent.SELECTED)
              label.setText(names[imagesJComboBox.getSelectedIndex()]);
           }); 
   } 
} 