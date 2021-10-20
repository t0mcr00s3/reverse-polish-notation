public class Model {
    private View view;
    private String temp_number = "";
    private boolean decimal_point_status = false;
    private Stack stack;

    public Model(View view){
        this.view = view;
        stack = new Stack();
    }

    public void numberPressed(String number){
        temp_number = temp_number + number;
        view.setTextField(temp_number);
    }

    public void signPressed(String sign){
        if(view.getText().length() == 0){
            return;
        }
        stack.push(temp_number);
        if(checkSign()){
            removeSign();
        }
        stack.push(sign);
        view.concatTextField(" " + sign);
        decimal_point_status = false;
        temp_number = "";
    }

    private boolean checkSign(){
        String [] signs = {"*", "/", "-", "+", "%"};
        String last_sign = stack.get(stack.length() - 1);
        boolean flag = false;
        for(String item : signs){
            if(item.equals(last_sign)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    private void removeSign(){
        stack.pop();
        int length = view.getText().length() - 2;
        view.setTextField(view.getText().substring(0, length));
    }

    public void singleOperation(String sign){
        if(temp_number.length() == 0){
            return;
        }
        stack.push(temp_number);
        stack.push(sign); 
        Equal();
    }

    public void toggleNumberSignPressed(){
        if(temp_number.length() == 0){
            return;
        }
        String buffer;
        if(temp_number.charAt(0) == '-'){
            buffer = temp_number.substring(1, temp_number.length());
        }else{
            buffer = "-" + temp_number;
        }
        temp_number = buffer;
        view.setTextField(temp_number);
    }

    public void decimalPointPressed(){
        if(decimal_point_status){
            if(temp_number.endsWith(".")){
                removeDecimalPoint(); 
            }
            return;
        }
        decimal_point_status = true;
        if(temp_number.length() == 0){
            temp_number = "0";
        }
        temp_number = temp_number + ".";
        view.setTextField(temp_number);
    } 

    private void removeDecimalPoint(){
        if(temp_number.length() == 1){
            temp_number = "";
            view.setTextField(temp_number);
            return;
        }
        else{
            temp_number = temp_number.substring(0, temp_number.length() - 1);
            view.setTextField(temp_number);
            decimal_point_status = false;
        }
    }

    public void removeAll(){
        stack = new Stack();
        view.setTextField("");
        temp_number = "";
        decimal_point_status = false;
    }

    public void clearLastEntry(){
        decimal_point_status = false;
        if(stack.length() == 0){
            temp_number = "";
            view.setTextField(temp_number);
            return;
        }
        int times_of_pop = view.getText().split(" ").length + 1;
        if(temp_number.length() > 0){
            times_of_pop = 0;
        }else{
            times_of_pop = view.getText().split(" ").length;
        }
        for(int i = 0; i < times_of_pop; i++){
            stack.pop();
        }
        temp_number = "";
        view.setTextField(temp_number);
    }

    public void removeLastSymbol(){
        if(checkSign()){
            removeSign();
        }
        else{
            if(temp_number.length() == 0){
                temp_number = stack.pop();
            }
            if(decimal_point_status){
                if(temp_number.endsWith(".")){
                    removeDecimalPoint(); 
                    return;
                }
            }
            temp_number = temp_number.substring(0, temp_number.length() - 1);
            view.setTextField(temp_number);
        }
    }

    public void Equal(){
        stack.push(temp_number);
        if(checkSign()){
            return;
        }
        if(stack.length() == 0){
            return;
        }
        Polish_Notation notation = new Polish_Notation(stack.getStack());
        notation.convertToReverse();
        String result = notation.computation();
        if(result.equals("error")){
            removeAll();
            view.setTextField("error");
        }
        decimal_point_status = checkResultForPointStatus(result);
        result = processingResult(result);
        removeAll();
        temp_number = result;
        view.setTextField(result);
    }

    private boolean checkResultForPointStatus(String result){
        boolean flag = false;
        for(String symbol: result.split("")){
            if(symbol.equals(".")){
                flag = true;
                break;
            }
        }
        return flag;
    }

    private String processingResult(String result){
        int index = result.length() - 1;
        int count_of_zeros = 0;
        String[] array_of_result = result.split("");
        while(!array_of_result[index].equals(".")){
            if(array_of_result[index].equals("0")){
                count_of_zeros++;
            }
            index--;
        }
        if(count_of_zeros == result.length() - 1 - index){
            result = result.substring(0, index);
        }
        return result;
    }
}