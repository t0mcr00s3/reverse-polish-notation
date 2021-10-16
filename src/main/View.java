package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class View {
    private Controller controller;
    JTextField textField;

    public View(){
        final int WIDTH = 70;
        final int HEIGHT = 50; 


        this.controller = new Controller(this);
        JFrame frame = new JFrame("Калькулятор");

        JButton clear_last_entry = new JButton("CE");
        clear_last_entry.setBounds(10, 60, WIDTH, HEIGHT); 
        clear_last_entry.addActionListener(this.controller);
        frame.add(clear_last_entry);

        JButton change_sign = new JButton("±");
        change_sign.setBounds(80, 60, WIDTH, HEIGHT); 
        change_sign.addActionListener(this.controller);
        frame.add(change_sign);

        JButton clear = new JButton("C");
        clear.setBounds(10, 110, WIDTH, HEIGHT);
        clear.addActionListener(this.controller);
        frame.add(clear);

        JButton percent = new JButton("%");
        percent.setBounds(80, 110, WIDTH, HEIGHT);
        percent.addActionListener(this.controller);
        frame.add(percent);

        JButton square_root = new JButton("√");
        square_root.setBounds(150, 110, WIDTH, HEIGHT);
        square_root.addActionListener(this.controller);
        frame.add(square_root);

        JButton div = new JButton("/");
        div.setBounds(220, 110, WIDTH, HEIGHT);
        div.addActionListener(this.controller);
        frame.add(div);

        JButton sub = new JButton("-");
        sub.setBounds(220, 210, WIDTH, HEIGHT);
        sub.addActionListener(this.controller);
        frame.add(sub);

        JButton mul = new JButton("*");
        mul.setBounds(220, 160, WIDTH, HEIGHT);
        mul.addActionListener(this.controller);
        frame.add(mul);

        JButton add = new JButton("+");
        add.setBounds(220, 260, WIDTH, 100);
        add.addActionListener(this.controller);
        frame.add(add);

        JButton decimal_point = new JButton(".");
        decimal_point.setBounds(80, 310, WIDTH, HEIGHT);
        decimal_point.addActionListener(this.controller);
        frame.add(decimal_point);

        JButton equals = new JButton("=");
        equals.setBounds(150, 310, WIDTH, HEIGHT);
        equals.addActionListener(this.controller);
        frame.add(equals);

        JButton one = new JButton("1");
        one.setBounds(10, 260, WIDTH, HEIGHT);
        one.addActionListener(this.controller);
        frame.add(one);

        JButton two = new JButton("2");
        two.setBounds(80, 260, WIDTH, HEIGHT);
        two.addActionListener(this.controller);
        frame.add(two);

        JButton three = new JButton("3");
        three.setBounds(150, 260, WIDTH, HEIGHT);
        three.addActionListener(this.controller);
        frame.add(three);

        JButton fourth = new JButton("4");
        fourth.setBounds(10, 210, WIDTH, HEIGHT);
        fourth.addActionListener(this.controller);
        frame.add(fourth);

        JButton five = new JButton("5");
        five.setBounds(80, 210, WIDTH, HEIGHT);
        five.addActionListener(this.controller);
        frame.add(five);

        JButton six = new JButton("6");
        six.setBounds(150, 210, WIDTH, HEIGHT);
        six.addActionListener(this.controller);
        frame.add(six);

        JButton seven = new JButton("7");
        seven.setBounds(10, 160, WIDTH, HEIGHT);
        seven.addActionListener(this.controller);
        frame.add(seven);

        JButton eight = new JButton("8");
        eight.setBounds(80, 160, WIDTH, HEIGHT);
        eight.addActionListener(this.controller);
        frame.add(eight);

        JButton nine = new JButton("9");
        nine.setBounds(150, 160, WIDTH, HEIGHT);
        nine.addActionListener(this.controller);
        frame.add(nine);

        JButton zero = new JButton("0");
        zero.setBounds(10, 310, WIDTH, HEIGHT);
        zero.addActionListener(this.controller);
        frame.add(zero);

        JButton enter = new JButton("enter");
        enter.setBounds(150, 60, WIDTH * 2, HEIGHT);
        enter.addActionListener(this.controller);
        frame.add(enter);

        textField = new JTextField("");
        textField.setBounds(10, 10, 280, HEIGHT);
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);
        
        frame.setSize(300, 390);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getText(){
        return this.textField.getText();
    }

    public void concatTextField(String str){
        this.textField.setText(this.textField.getText().concat(str));
    }

    public void setTextField(String str){
        this.textField.setText(str);
    }
}