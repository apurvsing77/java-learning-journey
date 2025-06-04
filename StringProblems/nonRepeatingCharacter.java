package StringProblems;

import java.util.HashMap;
import java.util.Map;

public class nonRepeatingCharacter {
    public static void main(String[] args) {
     String s = "racecarxyz";
        System.out.println(chekRepeaing(s));
    }
    static char chekRepeaing(String str){
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i <str.length() ; i++) {
//            map.getOrDefault((str.charAt(i)),1) ,0+1);
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        for (int i = 0; i <str.length() ; i++) {
            if (map.get(str.charAt(i)) == 1) {
               // System.out.println(str.charAt(i));
                return str.charAt(i);
            }
        }

        return '$';
    }
}
