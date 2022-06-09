import java.util.EmptyStackException;
import java.util.Stack;
import java.util.LinkedList;

public class Calculator {

    public Stack<Double> numbers;
    public Stack<Operator> operators;
    public LinkedList<Double> results;

    public Calculator() {
        numbers = new Stack<Double>();
        operators = new Stack<Operator>();
        results = new LinkedList<Double>();
    }

    @Override
    public String toString(){
        return numbers.toString() + "\n" + operators.toString();
    }
    
    public void pushDouble(double d){
        numbers.push(d);
    }
    public void pushOperator(Operator o){
        operators.push(o);
    }
    public double getResult() throws RuntimeException{
        if(numbers.empty()) throw new RuntimeException("The number stack is empty.");
        return numbers.peek();
    }
    public void executeBinOperator(Operator op){
        switch(op){
            case PLUS:
                numbers.push(numbers.pop() + numbers.pop());
                break;
            case MINUS:
                numbers.push(- numbers.pop() + numbers.pop());
                break;
            case MULT:
                numbers.push(numbers.pop() * numbers.pop());
                break;
            case DIV:
                numbers.push(1 / numbers.pop() * numbers.pop());
                break;
            default: break;
        }
    }
    private static int precedence(Operator op){
        switch(op){
            case PLUS: case MINUS: return 0;
            case MULT: case DIV: return 1;
            default: return -1;
        }
    }
    public void commandOperator(Operator op){
        try{
            Operator top = operators.peek();
            if(precedence(top) < precedence(op)) throw new RuntimeException("no precedence");
            executeBinOperator(operators.pop());
            commandOperator(op);
        }
        catch(EmptyStackException e){pushOperator(op);}
        catch(RuntimeException e){pushOperator(op);}
    }
    public void commandDouble(double d){
        pushDouble(d);
    }
    public void commandEqual(){
        while(!operators.empty()){
            executeBinOperator(operators.pop());
        }
        results.addFirst(getResult());
    }
    public void commandLPar() {
        pushOperator(Operator.OPEN);
    }
    public void commandRPar() {
        if(operators.empty()) return;
        Operator op = operators.pop();
        while(!op.equals(Operator.OPEN) && !operators.empty()){
            executeBinOperator(op);
            op = operators.pop();
        }
    }
    public void commandInit() {
        numbers = new Stack<Double>();
        operators = new Stack<Operator>();
    }
    public void commandReadMemory (int i){
        commandDouble(results.get(i - 1));
    }
}
