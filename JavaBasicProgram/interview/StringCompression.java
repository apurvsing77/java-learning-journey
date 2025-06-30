package JavaBasicProgram.interview;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {

    public static Map<Character,Integer> compress(String input) {

        Map<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < input.length(); index++) {
            map.put(input.charAt(index), map.getOrDefault(input.charAt(index), 0)+1);
        }

        return map;
    }
    public static void main(String[] args) {
        String input = "aabcccccaaa";
        System.out.println(input);

        System.out.println(compress(input));
    }

}
