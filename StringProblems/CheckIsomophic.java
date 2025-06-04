package StringProblems;

import java.util.HashMap;
import java.util.Map;

public class CheckIsomophic {
    public static void main(String[] args) {
        String str1 = "babc";
        String str2 = "kikp";
        if (isisomorphic(str1,str2)){
            System.out.println("Strin is isomorphic ");
        }else {
            System.out.println(" Strin is NOT isomorphic ");
        }
    }
    static  boolean isisomorphic(String str1, String str2){

        if (str1.length() != str2.length()) return false;
        Map<Character,Character> isomor= new HashMap<>();

        for (int i = 0; i <str1.length() ; i++) {
            char key = str1.charAt(i);
            char value= str2.charAt(i);
            if (!isomor.containsKey(key)){
                if (!isomor.containsValue(value)){
                    isomor.put(key,value);
                }else {
                    return false;
                }
            }else {
                char mapedchar = isomor.get(key);
                if (mapedchar != value)
                    return false;
            }

        }

            return true;
    }
}
