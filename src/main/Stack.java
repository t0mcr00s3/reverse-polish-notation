public class Stack {
    private String[] stack;
    
    public Stack(){
        stack = new String[0];
    }

    public void push(String value){
        if(value.equals("")){
            return;
        }
        resizeStack(1);
        stack[stack.length - 1] = value;
    }

    public String pop(){
        String value = stack[stack.length - 1];
        resizeStack(-1);        
        return value;
    }

    private void resizeStack(int size){
        String[] temp_stack = new String[stack.length + size];
        for(int i = 0; i < stack.length + size; i++){
            if(i == stack.length){
                break;
            }
            temp_stack[i] = stack[i];
        }
        stack = temp_stack;
    }

    public String get(int i){
        if(stack.length == 0){
            return "";
        }
        return stack[i];
    }

    public String[] getStack(){
        return stack;
    }

    public int length(){
        return stack.length;
    }
}