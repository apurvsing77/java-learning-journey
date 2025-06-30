package JavaBasicProgram.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaximumValue {
    public static void main(String[] args) {

        Map<Character,Integer> map = new HashMap<>();
        map.put('A',12);
        map.put('B',17);
        map.put('C',10);
        map.put('D',19);
        map.put('E',9);
        map.put('F',120);
        map.put('G',111);
        System.out.println(maxValueKey(map));
    }

    public static  char maxValueKey(Map<Character,Integer> map){
       char maxKey ='\u0000';
       int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            char currntKey = entry.getKey();
            int  currentValue = entry.getValue();

            if (currentValue > maxValue){
                maxValue = currentValue;
                maxKey = currntKey;
            }

        }
return maxKey;
    }
}
