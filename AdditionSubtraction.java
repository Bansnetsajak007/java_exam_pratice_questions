/*

Create a Swing application that receives two numbers through
JTextFields and display the addition or subtraction of two
numbers in another JTextField when either of Add or Subtract
button is pressed and when Clear button is pressed the
JTextField's data should be cleared.

*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;    

public class AdditionSubtraction extends JFrame implements ActionListener  {
    JTextField t1, t2, t3;
    JButton addBtn, subBtn, clearBtn;

    public AdditionSubtraction(){

        // setting the layout of an application 
        setTitle("Addition &Subtraction");
        setSize(400,200);
        setLayout(new GridLayout(4,2,10,10));

        add(new JLabel("Enter First Number: "));
        t1 = new JTextField();
        add(t1);

        add(new JLabel("Enter Second Number: "));
        t2 = new JTextField();
        add(t2 );

        add(new JLabel("Result  : "));
        t3 = new JTextField();
        add(t3);

        addBtn = new JButton("ADD");
        add(addBtn);
        subBtn = new JButton("SUBTRACT");
        add(subBtn);
        clearBtn = new JButton("CLEAR");
        add(clearBtn);

        // adding action listener to buttons 
        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //main program logic 
        if  ( e.getSource() == addBtn ) {
            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());

            int sum_result = num1 + num2;  
            t3.setText(String.valueOf(sum_result));
        }
        if  ( e.getSource() == subBtn ) {
            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());

            int sub_result = num1 - num2;  
            t3.setText(String.valueOf(sub_result));
        }
        if  ( e.getSource() == clearBtn ) {
            t1.setText("");
            t2.setText("");
            t3.setText(""   );
        }
     }

     public static void main(String[] args) {
        new AdditionSubtraction();
     }
}