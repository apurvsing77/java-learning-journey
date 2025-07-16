package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
    String str="LVIII";
        System.out.println(convert(str));
}

    static  int  convert(String str){
        Map<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

    int n= str.length();
    int res=0;
        for (int i = 0; i< n  ; i++) {

            if ((i !=n-1) && (map.get(str.charAt(i)) < map.get(str.charAt(i+1)))) {
                res=res-map.get(str.charAt(i));
            }else {
                res=res+map.get(str.charAt(i));

            }
        }
        return res;

    }

    }

