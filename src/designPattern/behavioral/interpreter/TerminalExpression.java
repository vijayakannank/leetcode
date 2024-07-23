package designPattern.behavioral.interpreter;

public class TerminalExpression implements Expression{

    String data;

    TerminalExpression(String data){
        this.data = data;
    }
    @Override
    public boolean interpret(String context) {

        return context.contains(data);
    }
}
