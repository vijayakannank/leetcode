package common;

public class GoalParserInterpretation {

    public static void main(String[] args) {
        interpret("G()(al)");
    }

    static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int length = command.length();

        while(index < length){
            if(command.charAt(index) == 'G'){
                sb.append("G");
                index++;
            }
            else if( command.startsWith("(al)", index)){
                sb.append("al");
                index += 4;
            }
            else if(command.startsWith("()", index)){
                sb.append("o");
                index += 2;
            }
            else {
                index++;
            }
        }

        return sb.toString();
    }
}
