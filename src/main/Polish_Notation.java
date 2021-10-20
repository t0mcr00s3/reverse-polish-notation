public class Polish_Notation {
    private String[]stack;

    public Polish_Notation(String[] stack){
        this.stack = stack;
    }

    public void convertToReverse(){
        String temp;
        for(int i = 1; i < stack.length - 1; i = i + 2){
            temp = stack[i];
            stack[i] = stack[i + 1];
            stack[i + 1] = temp;
        }
    }

    public String computation(){
        double var1 = Double.valueOf(stack[0]);
        double var2 = Double.valueOf(stack[1]);
        boolean flag = false;
        for(int i = 2; i < stack.length; i++){
            if(checkOperation(stack[i], var1, var2)){
                flag = true;
            }
            switch(stack[i]){
                case "+": var1 = var1 + var2; break;
                case "-": var1 = var1 - var2; break;
                case "*": var1 = var1 * var2; break;
                case "/": var1 = var1 / var2; break;
                case "^": var1 = Math.pow(var1, 2); break;
                case "√": var1 = Math.sqrt(var1); break;
                case "%": var1 = var1 * var2 / 100; break;
                default :var2 = Double.parseDouble(stack[i]); break;
            }
        }
        if(flag){
            return "error";
        }
        return "" + var1;
    }

    private boolean checkOperation(String sign, double var1, double var2){
        if(sign.equals("/") || sign.equals("*")){
            if(var1 == 0.0 || var2 == 0.0){
                return true;
            }
        }
        return false;
    }
}
