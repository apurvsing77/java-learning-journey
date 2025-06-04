package StringProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EncryptTheString {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaa";
        System.out.println(encryptString(s));
    }
    static String encryptString(String str){
        Map<Character,Integer> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        Set<Character> seen = new HashSet<>();



        for (int i = 0; i <str.length() ; i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }

        for (int i = 0; i <str.length() ; i++) {
            if (!seen.contains(str.charAt(i))) {
                String hex = convertToHex(map.get(str.charAt(i)));
                sb.append(str.charAt(i));
                sb.append(hex);
                seen.add(str.charAt(i));
            }
        }
        return sb.reverse().toString();
    }

    static  String convertToHex(int num){
        StringBuffer temp = new StringBuffer();

        while (num!=0){
            int rem = num%16;
            if (rem <10){
                temp.append((char)(rem +'0'));
            }else {
                temp.append((char) (rem-10 +'a'));

            }
            num = num/16;
        }
//        System.out.println("jkhwlidh"+temp.reverse().toString());
        return temp.reverse().toString();

    }

}
