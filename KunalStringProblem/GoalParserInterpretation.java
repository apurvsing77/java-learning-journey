package KunalStringProblem;

public class GoalParserInterpretation {
    public static void main(String[] args) {
    String str = "G()(al)";
        System.out.println(interpret(str));
    }
    public static String interpret(String command) {
        char[] ch = command.toCharArray();
        String result ="";
        int i=0;
        int l = command.length();
        while (i<l) {
            if (command.charAt(i) == 'G') {
               result += "G";

            } else if (command.charAt(i) =='(') {
                if (command.charAt(i+1) ==')')
                {
                    result  +="o";
                    i++;
                }else {
                    result +="al";
                    i+=2;
                }
            }
            i++;
        }
        return result;
    }
}
