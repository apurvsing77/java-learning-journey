package KunalStringProblem;

import java.util.HashMap;
import java.util.Map;

public class ShuffleString {
    public static void main(String[] args) {
    String str ="codeleet";
    int[] indicate ={4,5,6,7,0,2,1,3};
        System.out.println(restoreString2(str,indicate));
    }
    public static String restoreString(String s, int[] indices) {

        String result ="";
        Map<Integer,String> map = new HashMap<>();
        String[] str = s.split("");

        for (int i = 0; i < indices.length ; i++) {

            map.put(indices[i],str[i] );
        }
        for (int i = 0; i <indices.length ; i++) {
            result+=(map.get(i));
            System.out.println(map.get(i));
        }

        return result;
    }
    public static String restoreString2(String s, int[] indices) {
        char[] ch = s.toCharArray();
        char[] result = new char[indices.length];
        for (int i = 0; i < indices.length ; i++) {
            result[indices[i]] =ch[i];
        }


        return String.valueOf(result);
    }
}
