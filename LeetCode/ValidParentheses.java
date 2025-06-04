package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
     String str="()";
      //  String str="(]";
        System.out.println(checkParentheses(str));
    }
static boolean check(String str){
    Map<Character,Character> map = new HashMap<>();
    map.put(')','(');
    map.put('}','{');
    map.put(']','[');
    Stack<Character>  stack= new Stack<>();
    for (int i = 0; i <str.length() ; i++) {
        if (str.charAt(i) == '('||str.charAt(i) == '{' ||str.charAt(i) == '[' ) {
            stack.push(str.charAt(i));
        }  if (stack.empty()) {
            return false;
        } else if (str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']') {
            if (map.get(str.charAt(i)) == stack.peek()) {
                stack.pop();
            }else return false;
        }

    }
    if (stack.empty()){
        return true;
    }else return false;
}

static boolean checkParentheses(String str){
        Stack<Character> stack = new Stack<>();
    for (int i = 0; i <str.length() ; i++) {
        if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
            stack.push(str.charAt(i));
        } else if (stack.empty()) {
            return false;
        }else {

            if (checkPick(stack.peek(),str.charAt(i))) {
                stack.pop();
            }else return false;

        }
    }
    if (stack.empty()){
        return true;
    }else return false;

}
static  boolean checkPick(char a,char b){
    if ( (a =='(' && b == ')')  || (a =='{' && b == '}')  ||  (a =='[' && b == ']') ) {
        return true;
    }else return false;
}


}
