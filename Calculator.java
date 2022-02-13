package com.tella;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener
{
    private double trackerNum;
    private String FuncSelected = "";
    private JLabel myTitle;
    private Font myTitleFont;
    private JButton FClear, btn0, btn1,btn2,btn3,btn4,btn5, btn6,btn7, btn8,btn9, btnDot, btnEquals,FuncMul,FuncDiv,
    FuncMin,FuncPlus;
    private JPanel myPanel;
    private JTextField result, tracker;

    public static void main(String[] args)
    {
        new Calculator();
    }

    public Calculator()
    {
        setSize(500, 680);
        setTitle("CSCI-141");
        this.setResizable(false);

        myTitleFont     = new Font(Font.SANS_SERIF, Font.BOLD, 40);

        myTitle         = new JLabel("Calculator");
        myTitle.setBounds(0,10,500,20);
        myTitle.setVerticalAlignment(JLabel.TOP);
        myTitle.setHorizontalAlignment(JLabel.CENTER);
        myTitle.setFont(myTitleFont);



        btn0 = new JButton("0");
        btn0.setBackground(Color.white);
        btn0.addActionListener(this);

        btn1 = new JButton("1");
        btn1.setBackground(Color.white);
        btn1.addActionListener(this);

        btn2 = new JButton("2");
        btn2.setBackground(Color.white);
        btn2.addActionListener(this);

        btn3 = new JButton("3");
        btn3.setBackground(Color.white);
        btn3.addActionListener(this);

        btn4 = new JButton("4");
        btn4.setBackground(Color.white);
        btn4.addActionListener(this);

        btn5 = new JButton("5");
        btn5.setBackground(Color.white);
        btn5.addActionListener(this);

        btn6 = new JButton("6");
        btn6.setBackground(Color.white);
        btn6.addActionListener(this);

        btn7 = new JButton("7");
        btn7.setBackground(Color.white);
        btn7.addActionListener(this);

        btn8 = new JButton("8");
        btn8.setBackground(Color.white);
        btn8.addActionListener(this);

        btn9 = new JButton("9");
        btn9.setBackground(Color.white);
        btn9.addActionListener(this);

        btnDot = new JButton(".");
        btnDot.setBackground(Color.white);
        btnDot.addActionListener(this);

        btnEquals = new JButton("=");
        btnEquals.setBackground(Color.white);
        btnEquals.addActionListener(this);

        FuncMul = new JButton("*");
        FuncMul.setBackground(Color.white);
        FuncMul.addActionListener(this);

        FuncDiv = new JButton("/");
        FuncDiv.setBackground(Color.white);
        FuncDiv.addActionListener(this);

        FuncPlus = new JButton("+");
        FuncPlus.setBackground(Color.white);
        FuncPlus.addActionListener(this);

        FuncMin = new JButton("-");
        FuncMin.setBackground(Color.white);
        FuncMin.addActionListener(this);

        FClear = new JButton("C");
        FClear.setBackground(Color.white);


        JPanel buttonPanel = new JPanel(new GridLayout(4,3));

        buttonPanel.add(btn7);
        buttonPanel.add(btn8);
        buttonPanel.add(btn9);
        buttonPanel.add(btn4);
        buttonPanel.add(btn5);
        buttonPanel.add(btn6);
        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        buttonPanel.add(btn3);
        buttonPanel.add(btn0);
        buttonPanel.add(btnDot);
        buttonPanel.add(btnEquals);


        JPanel FuncPanel = new JPanel(new GridLayout(5,1));

        FuncPanel.add(FClear);
        FuncPanel.add(FuncMul);
        FuncPanel.add(FuncDiv);
        FuncPanel.add(FuncMin);
        FuncPanel.add(FuncPlus);


        result = new JTextField(20);
        result.setHorizontalAlignment(JTextField.RIGHT);
        result.setEditable(false);
        result.setBackground(Color.white);

        tracker = new JTextField();
        tracker.setHorizontalAlignment(JTextField.RIGHT);
        tracker.setEditable(false);
        tracker.setBackground(Color.LIGHT_GRAY);

        JPanel TopPanel = new JPanel(new GridLayout(3,1));
        TopPanel.add(myTitle);
        TopPanel.add(tracker);
        TopPanel.add(result);


        myPanel       = new JPanel();
        myPanel.setLayout(new BorderLayout());
        myPanel.setPreferredSize(new Dimension(500, 400));





        //Add action listener
        FClear.addActionListener(this);

        myPanel.add(TopPanel, BorderLayout.NORTH);
        myPanel.add(buttonPanel, BorderLayout.CENTER);
        myPanel.add(FuncPanel, BorderLayout.EAST);


        this.getContentPane().add(myPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == FClear)
        {
            result.setText("");
            trackerNum = 0;
            tracker.setText("");
            FuncSelected = "";

        } else if(e.getSource() == btn0){
            result.setText(result.getText()+"0");
        }else if(e.getSource() == btn1){
            result.setText(result.getText()+"1");
        }else if(e.getSource() == btn2){
            result.setText(result.getText()+"2");
        }else if(e.getSource() == btn3){
            result.setText(result.getText()+"3");
        }else if(e.getSource() == btn4){
            result.setText(result.getText()+"4");
        }else if(e.getSource() == btn5){
            result.setText(result.getText()+"5");
        }else if(e.getSource() == btn6){
            result.setText(result.getText()+"6");
        }else if(e.getSource() == btn7){
            result.setText(result.getText()+"7");
        }else if(e.getSource() == btn8){
            result.setText(result.getText()+"8");
        }else if(e.getSource() == btn9){
            result.setText(result.getText()+"9");
        }else if(e.getSource() == btnDot){
            if(result.getText().contains(".")==false){
            result.setText(result.getText()+".");}
        }else if((e.getSource() == FuncPlus) && (result.getText().isEmpty() != true)){
            FuncSelected = "+";
            tracker.setText(result.getText());
            trackerNum = Double.parseDouble(tracker.getText());
            result.setText("");} /*else{
                FuncSelected = "+";
                tracker.setText(result.getText());
                resultNum = Double.parseDouble(result.getText());
                trackerNum -= resultNum;
                tracker.setText(String.valueOf(trackerNum));
                result.setText("");
            }*/
        else if((e.getSource() == FuncMin) && (result.getText().isEmpty() != true)){
            if (FuncSelected == ""){
            FuncSelected = "-";
            tracker.setText(result.getText());
            trackerNum = Double.parseDouble(tracker.getText());
            result.setText("");}

        }else if((e.getSource() == FuncMul) && (result.getText().isEmpty() != true)){
            if (FuncSelected == ""){
            FuncSelected = "*";
            tracker.setText(result.getText());
            trackerNum = Double.parseDouble(tracker.getText());
            result.setText("");}

        }else if((e.getSource() == FuncDiv) && (result.getText().isEmpty() != true)){
            if (FuncSelected == ""){
            FuncSelected = "/";
            tracker.setText(result.getText());
            trackerNum = Double.parseDouble(tracker.getText());
            result.setText("");}

        }else if((e.getSource() == btnEquals) && (result.getText().isEmpty() != true) &&
                (tracker.getText().isEmpty() != true)){
            if(FuncSelected == "+"){
                tracker.setText(result.getText());
                trackerNum += Double.parseDouble(result.getText());
                result.setText(String.valueOf(trackerNum));
            }else if(FuncSelected == "-"){
                tracker.setText(result.getText());
                trackerNum -= Double.parseDouble(result.getText());
                result.setText(String.valueOf(trackerNum));
            }else if(FuncSelected == "*"){
                tracker.setText(result.getText());
                trackerNum *= Double.parseDouble(result.getText());
                result.setText(String.valueOf(trackerNum));
            }else if(FuncSelected == "/"){
                tracker.setText(result.getText());
                trackerNum /= Double.parseDouble(result.getText());
                result.setText(String.valueOf(trackerNum));
            }
        }
    }
}
