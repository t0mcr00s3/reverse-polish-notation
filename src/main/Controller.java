package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
    private Model model;
    
    public Controller(View view){
        this.model = new Model(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand().toString()){
            case "enter": this.model.Enter_Pressed(); break;
            case "0": this.model.Number_Pressed("0");break;
            case "1": this.model.Number_Pressed("1");break;
            case "2": this.model.Number_Pressed("2");break;
            case "3": this.model.Number_Pressed("3");break;
            case "4": this.model.Number_Pressed("4");break;
            case "5": this.model.Number_Pressed("5");break;
            case "6": this.model.Number_Pressed("6");break;
            case "7": this.model.Number_Pressed("7");break;
            case "8": this.model.Number_Pressed("8");break;
            case "9": this.model.Number_Pressed("9");break;
            case "C": this.model.Clear_All();break;
            case "CE": this.model.Clear_Last_Entry(); break;
            case "±" : this.model.print_stack(); break;
            case "." : this.model.Add_Comma();break;
            case "*" : this.model.Sign_Pressed("*");break;
            case "-" : this.model.Sign_Pressed("-");break;
            case "/" : this.model.Sign_Pressed("/");break;
            case "+" : this.model.Sign_Pressed("+");break;
            case "√" : this.model.Sign_Pressed("√");break;
            case "%" : this.model.Sign_Pressed("%");break;
            case "=" : this.model.Calculate();break;
        }
    }
}
