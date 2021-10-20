
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
    private Model model;
    
    public Controller(View view){
        model = new Model(view);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Zero": model.numberPressed("0"); break;
            case "One": model.numberPressed("1"); break;
            case "Two": model.numberPressed("2"); break;
            case "Three": model.numberPressed("3"); break;
            case "Four": model.numberPressed("4"); break;
            case "Five": model.numberPressed("5"); break;
            case "Six": model.numberPressed("6"); break;
            case "Seven": model.numberPressed("7"); break;
            case "Eight": model.numberPressed("8"); break;
            case "Nine": model.numberPressed("9"); break;
            case "Clear_All": model.removeAll(); break;
            case "Clear_Last_Entry": model.clearLastEntry(); break;
            case "backSpace": model.removeLastSymbol(); break;
            case "Change_Sign" : model.toggleNumberSignPressed(); break;
            case "Decimal_Point" : model.decimalPointPressed(); break;
            case "Mul" : model.signPressed("*"); break;
            case "Sub" : model.signPressed("-"); break;
            case "Div" : model.signPressed("/"); break;
            case "Add" : model.signPressed("+"); break;
            case "Square_Root" : model.singleOperation("√"); break;
            case "Percent" : model.signPressed("%"); break;
            case "Pow" : model.singleOperation("^"); break;
            case "Result" : model.Equal(); break;
        }
    }
}
