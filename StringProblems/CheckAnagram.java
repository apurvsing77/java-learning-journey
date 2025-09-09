package StringProblems;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {
    public static void main(String[] args){

      String  s1 = "geeks" ;
      String s2 = "kseek";
      System.out.println(checkAnagram(s1,s2));
    }
    public static boolean checkAnagram(String str1,String str2){
        if (str1.length() != str2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i <str1.length() ; i++) {

            map.put(str1.charAt(i),map.getOrDefault(str1.charAt(i),0)+1);
        }
        for(int i = 0; i <str2.length() ; i++) {
//            map.put(str2.charAt(i),map.getOrDefault(str2.charAt(i),0)-1);

            if (map.getOrDefault(str2.charAt(i),0) > 0){
                map.put(str2.charAt(i),map.get(str2.charAt(i))-1);
            }
        }
        int count = 0;
        for (char ch : map.keySet()){
            count += map.get(ch);
        }
        if (count >= 1)
        {
            return false;
        }else
            return true;
    }
}
