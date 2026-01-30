/* 
1) Create swing application that receive two
numbers through two JTextFields and display the largest
number of two numbers in another JTextField when the
LARGENO button is pressed and when EXIT button is pressed
the program will terminate.
*/



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LargestNumberSwing extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton largestBtn, exitBtn;

    public LargestNumberSwing() {

        setTitle("Largest Number Finder");
        setSize(350, 200);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Enter First Number:"));
        t1 = new JTextField();
        add(t1);

        add(new JLabel("Enter Second Number:"));
        t2 = new JTextField();
        add(t2);

        add(new JLabel("Largest Number:"));
        t3 = new JTextField();
        t3.setEditable(false);
        add(t3);

        largestBtn = new JButton("LARGEST");
        exitBtn = new JButton("EXIT");

        add(largestBtn);
        add(exitBtn);

        largestBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // main logic
        if (e.getSource() == largestBtn) {

            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());

            int largest = (num1 > num2) ? num1 : num2;

            t3.setText(String.valueOf(largest));
        }

        if (e.getSource() == exitBtn) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new LargestNumberSwing();
    }
}
