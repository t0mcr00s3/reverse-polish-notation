package main;

import java.util.Stack;

public class Model {
    private View view;
    private Stack<String> stack = new Stack<String>();
    private String temp_number = "";
    private boolean comma_status = false;
    private boolean enter_status = false;

    public Model(View view){
        this.view = view;
    }

    public void Number_Pressed(String number){
        this.temp_number += number;
        this.view.concatTextField(number);
    }

    private void Clear_Temp_Number(){
        this.temp_number = "";
    }

    public void Enter_Pressed(){
        if(this.enter_status)return;
        this.enter_status = true;
        Push_stack(this.temp_number);
        Clear_Temp_Number();
        this.view.concatTextField(" ");
    }

    private void Push_stack(String value){
        if(value.equals("")){
            return;
        }
        this.stack.push(value);
        Clear_Temp_Number();
    }

    public void Sign_Pressed(String sign){
        Push_stack(this.temp_number);
        if(!Check_Stack_Value()){
            return;
        }
        if(this.stack.size()<2){
            return;
        }
        Push_stack(sign);
        Clear_Temp_Number();
        this.view.concatTextField(" " + sign + " ");
    }

    private boolean Check_Stack_Value(){
        if(this.stack.size() == 0) return false;
        String value = this.stack.pop();
        this.stack.push(value);
        if(value.equals("-") || value.equals("+") || value.equals("/") || value.equals("*") || value.equals("%") || value.equals("√") || value.equals("")){
            return false;
        }
        return true;
    }
    public void Clear_All(){
        System.out.println(stack.size());
        while(!stack.empty()){
            stack.pop();
        }
        this.view.setTextField("");
        this.temp_number = "";
        this.enter_status = false;
    }

    public void Clear_Last_Entry(){
        if(this.temp_number.length() == 1){
            this.temp_number = "";
            return;
        }
        if(this.temp_number.length() == 0 && stack.size() >= 1){
            this.temp_number = this.stack.pop();
        }
        this.temp_number = this.temp_number.substring(0, this.temp_number.length() - 1);
        String expression = this.view.getText().substring(0, this.view.getText().length() - 1);
        this.view.setTextField(expression);
    }

    public void Add_Comma(){
        if(this.comma_status)return;
        this.comma_status = true;
        this.temp_number.concat(".");
        this.view.concatTextField(".");
    }

    public void print_stack(){
        System.out.println("-------------------------");
        for(String s : this.stack){
            System.out.println(s);
        }
    }

    public void Calculate(){
        Push_stack(this.temp_number);
        if(Check_Stack_Value())return;
        double arg1 = Double.valueOf(stack.get(0));
        double arg2 = Double.valueOf(stack.get(1));
        for(int i = 2; i < stack.size(); i++){
            String value = stack.get(i);
            switch (value){
                case "/": arg1 /= arg2; break;
                case "*": arg1 *= arg2; break;
                case "+": arg1 += arg2; break;
                case "-": arg1 -=arg2; break;
                case "√": arg1 = Math.sqrt(arg1);break;
                case "%": arg1 *= arg2 / arg2; break;
                default: arg2 = Double.valueOf(stack.get(i));
            }
        }
        String answer = Check_Record(String.valueOf(arg1));
        Clear_All();
        Push_stack(answer);
        Clear_Temp_Number();
        this.view.setTextField(answer);
    }

    private String Check_Record(String number){
        String[] array = number.split("");
        int count_of_zeros = 0;
        int count_of_values = 0;
        int index = number.length() - 1;
        while(!array[index].equals(".")){
            if(array[index].equals("0")){
                count_of_zeros++;
            }
            count_of_values++;
            index--;
        }
        String answer = "";
        if(count_of_values == count_of_zeros){
            answer = number.substring(0, index);
        }else{
            answer = number;
        }
        return answer;
    }
}