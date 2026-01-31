/* 
 Write a Swing program to create a
calculator where addition, subtraction, multiplication and clear
operation is performed of two inputs given by the user and Resuit is shown 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField t1,t2,t3;
    JButton addBtn, subBtn, mulBtn, clearbtn;

    //setting the layout of an application

    public Calculator() {

    setTitle("Simple Calculator");  
    setSize(400,250);  
    setLayout(new GridLayout(5,2,10,10));

    //adding components to the frame
    add(new JLabel("Number 1: "));
    t1 = new JTextField();
    add(t1);  

    add(new JLabel("Number 2: "));
    t2 = new JTextField();
    add(t2);    

    add(new JLabel("Result : "));
    t3 = new JTextField();
    add(t3  ); 

    addBtn = new JButton("+");
    add(addBtn);
    subBtn = new JButton("-");
    add(subBtn);
    mulBtn = new JButton("*");
    add(mulBtn);
    clearbtn = new JButton("CLEAR");
    add(clearbtn);

    //adding event listeners to buttons 
    addBtn.addActionListener(this);
    subBtn.addActionListener(this);
    mulBtn.addActionListener(this);
    clearbtn.addActionListener(this);   

    //setting default close operation and visibility    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);  
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());

            int sum_result = num1 + num2;  
            t3.setText(String.valueOf(sum_result));   
        }

        if (e.getSource() == subBtn) {  

            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());

            int dif_result = num1 - num2;  
            t3.setText(String.valueOf(dif_result)); 
        }

        if (e.getSource() == mulBtn) {
            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());

            int mul_result = num1 * num2;  
            t3.setText(String.valueOf(mul_result));    
        }
        if(e.getSource() == clearbtn) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }   
    } 

    public static void main(String[] args) {
        new Calculator();
    }

}