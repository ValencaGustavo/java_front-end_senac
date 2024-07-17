// Fig. 20.25: FibonacciNumbers.java
// Using SwingWorker to perform a long calculation with 
// results displayed in a GUI.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.concurrent.ExecutionException;

public class FibonacciNumbers extends JFrame 
{
   // components for calculating the Fibonacci of a user-entered number
   private final JPanel workerJPanel =  
      new JPanel(new GridLayout(2, 2, 5, 5));
   private final JTextField numberJTextField = new JTextField();
   private final JButton goJButton = new JButton("Go");
   private final JLabel fibonacciJLabel = new JLabel();

   // components and variables for getting the next Fibonacci number
   private final JPanel eventThreadJPanel =  
      new JPanel(new GridLayout(2, 2, 5, 5));
   private long n1 = 0; // initialize with first Fibonacci number
   private long n2 = 1; // initialize with second Fibonacci number
   private int count = 1; // current Fibonacci number to display
   private final JLabel nJLabel = new JLabel("Fibonacci of 1: ");
   private final JLabel nFibonacciJLabel = 
      new JLabel(String.valueOf(n2));
   private final JButton previousNumberJButton = new JButton("Previous Number");
   private final JButton nextNumberJButton = new JButton("Next Number");

   // constructor
   public FibonacciNumbers()
   {
      super("Fibonacci Numbers");
      setLayout(new GridLayout(2, 1, 10, 10));
      
      // add GUI components to the SwingWorker panel
      workerJPanel.setBorder(new TitledBorder(
         new LineBorder(Color.BLACK), "With SwingWorker"));
      workerJPanel.add(new JLabel("Get Fibonacci of:"));
      workerJPanel.add(numberJTextField);
      goJButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               int n;

               try
               {
                  // retrieve user's input as an integer
                  n = Integer.parseInt(numberJTextField.getText());
               } 
               catch(NumberFormatException ex)
               {
                  // display an error message if the user did not
                  // enter an integer
                  fibonacciJLabel.setText("Enter an integer.");
                  return;
               } 
               
               // indicate that the calculation has begun
               fibonacciJLabel.setText("Calculating...");

               // create a task to perform calculation in background
               BackgroundCalculator task = 
                  new BackgroundCalculator(n, fibonacciJLabel);         
               task.execute(); // execute the task
            } 
         } // end anonymous inner class
      ); // end call to addActionListener         
      workerJPanel.add(goJButton);
      workerJPanel.add(fibonacciJLabel);
      
      // add GUI components to the event-dispatching thread panel
      eventThreadJPanel.setBorder(new TitledBorder(
         new LineBorder(Color.BLACK), "Without SwingWorker"));
      eventThreadJPanel.add(nJLabel);
      eventThreadJPanel.add(nFibonacciJLabel); 

      previousNumberJButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {

               long temp = n2 - n1;
               n1 = n2;
               n2 = temp;
               --count;


               nJLabel.setText("Fibonacci of " + count + ": ");
               nFibonacciJLabel.setText(String.valueOf(n2));
            }
         } 
      );
      eventThreadJPanel.add(previousNumberJButton);

      nextNumberJButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {

               long temp = n1 + n2;
               n1 = n2;
               n2 = temp;
               ++count;

               nJLabel.setText("Fibonacci of " + count + ": ");
               nFibonacciJLabel.setText(String.valueOf(n2));
            }
         } // end anonymous inner class
      ); // end call to addActionListener
      eventThreadJPanel.add(nextNumberJButton);

      add(workerJPanel);
      add(eventThreadJPanel);
      setSize(275, 200);
      setVisible(true);
   } // end constructor

   // main method begins program execution
   public static void main(String[] args)
   {
      FibonacciNumbers application = new FibonacciNumbers();
      application.setDefaultCloseOperation(EXIT_ON_CLOSE);
   } 
} // end class FibonacciNumbers

/*************************************************************************
* (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
* Pearson Education, Inc. All Rights Reserved.                           *
*                                                                        *
* DISCLAIMER: The authors and publisher of this book have used their     *
* best efforts in preparing the book. These efforts include the          *
* development, research, and testing of the theories and programs        *
* to determine their effectiveness. The authors and publisher make       *
* no warranty of any kind, expressed or implied, with regard to these    *
* programs or to the documentation contained in these books. The authors *
* and publisher shall not be liable in any event for incidental or       *
* consequential damages in connection with, or arising out of, the       *
* furnishing, performance, or use of these programs.                     *
*************************************************************************/
  