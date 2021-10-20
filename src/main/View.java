import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class View {
    private Controller controller;
    JTextField textField;

    public View(){
        final int WIDTH = 70;
        final int HEIGHT = 50; 

        controller = new Controller(this);
        JFrame frame = new JFrame("Калькулятор");

        JButton buttonCE = new JButton("CE");
        buttonCE.setBounds(10, 60, WIDTH, HEIGHT); 
        buttonCE.addActionListener(controller);
        buttonCE.setActionCommand("Clear_Last_Entry");
        frame.add(buttonCE);

        JButton buttonChange_Sign= new JButton("±");
        buttonChange_Sign.setBounds(80, 60, WIDTH, HEIGHT); 
        buttonChange_Sign.addActionListener(controller);
        buttonChange_Sign.setActionCommand("Change_Sign");
        frame.add(buttonChange_Sign);

        JButton buttonPow= new JButton("x²");
        buttonPow.setBounds(220, 60, WIDTH, HEIGHT); 
        buttonPow.addActionListener(controller);
        buttonPow.setActionCommand("Pow");
        frame.add(buttonPow);

        JButton buttonC = new JButton("C");
        buttonC.setBounds(10, 110, WIDTH, HEIGHT);
        buttonC.addActionListener(controller);
        buttonC.setActionCommand("Clear_All");
        frame.add(buttonC);

        JButton buttonPercent = new JButton("%");
        buttonPercent.setBounds(150, 60, WIDTH, HEIGHT);
        buttonPercent.addActionListener(controller);
        buttonPercent.setActionCommand("Percent");
        frame.add(buttonPercent);

        JButton buttonSquare_Root = new JButton("sqrt"); //√
        buttonSquare_Root.setBounds(150, 110, WIDTH, HEIGHT);
        buttonSquare_Root.addActionListener(controller);
        buttonSquare_Root.setActionCommand("Square_Root");
        frame.add(buttonSquare_Root);

        JButton buttonDiv = new JButton("/");
        buttonDiv.setBounds(220, 110, WIDTH, HEIGHT);
        buttonDiv.addActionListener(controller);
        buttonDiv.setActionCommand("Div");
        frame.add(buttonDiv);

        JButton buttonSub = new JButton("-");
        buttonSub.setBounds(220, 210, WIDTH, HEIGHT);
        buttonSub.addActionListener(controller);
        buttonSub.setActionCommand("Sub");
        frame.add(buttonSub);

        JButton buttonMul = new JButton("*");
        buttonMul.setBounds(220, 160, WIDTH, HEIGHT);
        buttonMul.addActionListener(controller);
        buttonMul.setActionCommand("Mul");
        frame.add(buttonMul);

        JButton buttonAdd = new JButton("+");
        buttonAdd.setBounds(220, 260, WIDTH, 100);
        buttonAdd.addActionListener(controller);
        buttonAdd.setActionCommand("Add");
        frame.add(buttonAdd);

        JButton buttonDecimal_Point = new JButton(".");
        buttonDecimal_Point.setBounds(80, 310, WIDTH, HEIGHT);
        buttonDecimal_Point.addActionListener(controller);
        buttonDecimal_Point.setActionCommand("Decimal_Point");
        frame.add(buttonDecimal_Point);

        JButton buttonEquals = new JButton("=");
        buttonEquals.setBounds(150, 310, WIDTH, HEIGHT);
        buttonEquals.addActionListener(controller);
        buttonEquals.setActionCommand("Result");
        frame.add(buttonEquals);

        JButton buttonOne = new JButton("1");
        buttonOne.setBounds(10, 260, WIDTH, HEIGHT);
        buttonOne.addActionListener(controller);
        buttonOne.setActionCommand("One");
        frame.add(buttonOne);

        JButton buttonTwo = new JButton("2");
        buttonTwo.setBounds(80, 260, WIDTH, HEIGHT);
        buttonTwo.addActionListener(controller);
        buttonTwo.setActionCommand("Two");
        frame.add(buttonTwo);

        JButton buttonThree = new JButton("3");
        buttonThree.setBounds(150, 260, WIDTH, HEIGHT);
        buttonThree.addActionListener(controller);
        buttonThree.setActionCommand("Three");
        frame.add(buttonThree);

        JButton buttonFourth = new JButton("4");
        buttonFourth.setBounds(10, 210, WIDTH, HEIGHT);
        buttonFourth.addActionListener(this.controller);
        buttonFourth.setActionCommand("Four");
        frame.add(buttonFourth);

        JButton buttonFive = new JButton("5");
        buttonFive.setBounds(80, 210, WIDTH, HEIGHT);
        buttonFive.addActionListener(controller);
        buttonFive.setActionCommand("Five");
        frame.add(buttonFive);

        JButton buttonSix = new JButton("6");
        buttonSix.setBounds(150, 210, WIDTH, HEIGHT);
        buttonSix.addActionListener(controller);
        buttonSix.setActionCommand("Six");
        frame.add(buttonSix);

        JButton buttonSeven = new JButton("7");
        buttonSeven.setBounds(10, 160, WIDTH, HEIGHT);
        buttonSeven.addActionListener(controller);
        buttonSeven.setActionCommand("Seven");
        frame.add(buttonSeven);

        JButton buttonEight = new JButton("8");
        buttonEight.setBounds(80, 160, WIDTH, HEIGHT);
        buttonEight.addActionListener(controller);
        buttonEight.setActionCommand("Eight");
        frame.add(buttonEight);

        JButton buttonNine = new JButton("9");
        buttonNine.setBounds(150, 160, WIDTH, HEIGHT);
        buttonNine.addActionListener(controller);
        buttonNine.setActionCommand("Nine");
        frame.add(buttonNine);

        JButton buttonZero = new JButton("0");
        buttonZero.setBounds(10, 310, WIDTH, HEIGHT);
        buttonZero.addActionListener(controller);
        buttonZero.setActionCommand("Zero");
        frame.add(buttonZero);

        JButton buttonBackspace = new JButton("←");
        buttonBackspace.setBounds(80, 110, WIDTH, HEIGHT);
        buttonBackspace.addActionListener(controller);
        buttonBackspace.setActionCommand("backSpace");
        frame.add(buttonBackspace);

        textField = new JTextField("");
        textField.setBounds(10, 10, 280, HEIGHT);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(textField);
        
        frame.setSize(300, 390);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getText(){
        return textField.getText();
    }

    public void concatTextField(String str){
        textField.setText(textField.getText().concat(str));
    }

    public void setTextField(String str){
        textField.setText(str);
    }
}