package StringProblems;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;


public class RomanToNumber {

    private static int romanoToInt(String s){

        Map<Character,Integer> roman= new HashMap<Character,Integer>();

        put('I',1);
        put('V',5);
        put('X',10);
        put('L',50);
        put('c',100);
        put('D',500);
        put('M',1000);





        int sum=0;
        int n= s.length();
        for (int i = 0; i <n; i++) {
            if(i!=n-1 && roman.get(s.charAt(i))<roman.get(s.charAt(i+1))){
                sum -= roman.get(s.charAt(i));
            }else {
                sum += roman.get(s.charAt(i));
            }
        }
        return sum;

    }
    public static void main(String[] args) throws Exception{

        String str="VIIV";
        Integer result=romanoToInt(str);
        System.out.println(result);
    }
//    public static  Integer romanToStr(String s ){
//        Integer sum=0;
//        int len=s.length();
//        for (int i =len-1; i >=0 ; i--) {
//            if (  roman.get(s.charAt(i))>roman.get(s.charAt(i-1))){
//                sum=sum+roman.get(s.charAt(i))-roman.get(s.charAt(i-1));
//            }else {
//                sum += roman.get(s.charAt(i));
//            }
//        }
//
//
//        return sum;
//    }
}
