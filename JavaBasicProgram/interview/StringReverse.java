package JavaBasicProgram.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class StringReverse {
    public static void main(String[] args) {
        String str = "Apurv Kumar";

        System.out.println("Result is : "+reverseString(str));

//        stackexample();
    }
    public static StringBuilder reverseString(String str){

        char[] ch = str.toCharArray();
        System.out.println(Arrays.toString(ch)+" length "+ch.length);
        StringBuilder res= new StringBuilder();
        Stack<Character> strChar = new  Stack<>();
        for (int i = 0; i < ch.length ; i++) {
            strChar.push(ch[i]);
        }
        for (int i = 0; i < ch.length; i++) {
//            System.out.println(strChar.pop());
            res.append(strChar.pop());
        }
//      while (!strChar.isEmpty()){
//           // res = res.concat(""+strChar.pop());
//             res.append(strChar.pop());
//        }

        return res;
    }
    static void stackexample(){
        Stack<Character> stack = new Stack<>();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.push('D');
        stack.push('E');
        stack.push(' ');
        stack.push('F');
        stack.push('G');
        stack.push('H');
        stack.push('I');
        System.out.println(stack);

//        for (int i = 0; i < stack.size(); i++) {
////            System.out.println(stack.pop());
////        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

//        System.out.println(stack.peek());
//
    }
}
