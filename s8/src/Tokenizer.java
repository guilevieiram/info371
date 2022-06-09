public class Tokenizer {
    boolean isStart;
    boolean isNum;
    boolean isIntNum;
    double num;
    Calculator calc;
    double decimalPlaces;
    boolean DEBUG;

    boolean isMinUnary;
    boolean isNeg;

    boolean isMem;

    public Tokenizer(boolean debug){
        isStart = true;
        isIntNum= true;
        isNum = false;
        num = 0;
        calc = new Calculator();
        decimalPlaces = 0;

        isMinUnary = true;
        isNeg = false;

        isMem=false;

        DEBUG = debug;
    }
    public Tokenizer(){
        isStart = true;
        isIntNum= true;
        isNum = false;
        num = 0;
        calc = new Calculator();
        decimalPlaces = 0;

        isMinUnary = true;
        isNeg = false;

        isMem=false;

        DEBUG = false;
    }

    private void flush(){
        if(isNum) {
            if(isMem){
                calc.commandReadMemory((int)num);
                isMem = false;
            }
            else calc.commandDouble(num);
        }
        num = 0;
        isIntNum = true;
        isNum = false;
        isNeg = false;
        decimalPlaces = 0;
    }
    public void readChar(char c){
        if(DEBUG) System.out.println("\n" + c + ": \n" + calc.toString());
        if(DEBUG) System.out.println(isMem);
        isStart = false;
        if(!Character.isDigit(c)) {
            switch(c){
                case '.': isIntNum = false; break;
                case '=': 
                    flush(); 
                    calc.commandEqual(); 
                    isMinUnary = true;
                    break;
                case '+': 
                    flush(); 
                    calc.commandOperator(Operator.PLUS); 
                    isMinUnary = true;
                    break;
                case '-': 
                    flush(); 
                    if(isMinUnary) isNeg = true;
                    else{
                        calc.commandOperator(Operator.MINUS); 
                        isMinUnary = true;
                    }
                    break;
                case '*': 
                    flush(); 
                    calc.commandOperator(Operator.MULT); 
                    isMinUnary = true;
                    break;
                case '/': 
                    flush(); 
                    calc.commandOperator(Operator.DIV); 
                    isMinUnary = true;
                    break;
                case '(': 
                    calc.commandLPar();
                    isMinUnary = true;
                    break;
                case ')': 
                    flush();
                    calc.commandRPar();
                    break;
                case 'C': 
                    flush();
                    calc.commandInit();
                    isMinUnary = true;
                    break;
                case '$': 
                    flush();
                    calc.commandInit();
                    isMinUnary = false;
                    isMem = true;
                    break;
                default: 
                    flush();
                    break;
            }
            return;
        }
        isNum = true;
        isMinUnary = false;
        int n = Character.getNumericValue(c);
        if(isNeg) n = -n;
        if(isIntNum)
            num = num * 10 + n;
        else {
            decimalPlaces += 1;
            num += n * Math.pow(10, -decimalPlaces);
        }
    }
    public void readString(String s){
        for(char c : s.toCharArray()) readChar(c);
    }
}
