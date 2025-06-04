package LeetCode;
//32. Longest Valid Parentheses
//
import java.util.Stack;

public class LongestValidParenthes {
    public static void main(String[] args) {
String str="(()";
        System.out.println("Valid Leangth is : "+checkparentheses(str));
    }
    static  int checkparentheses(String str){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max_value=0;

        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else{
                stack.pop();
                if (stack.isEmpty()) {
                   stack.push(i);

                }else {
                    max_value = Math.max(max_value,i-stack.peek());
                }

            }

        }

        return max_value;

    }


    static int longestValidParentheses(String s) {
        int max = 0;
        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close){
                max =  Math.max(max,2*close);
            }else if (open>close){
                open = close =0;

            }
        }
        open = close =0;
        for (int i = s.length()-1;i>=0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close){
                max =  Math.max(max,2*open);
            }else if (close>open){
                open = close =0;

            }
        }


        return max;
    }
}
