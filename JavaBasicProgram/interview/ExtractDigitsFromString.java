package JavaBasicProgram.interview;

import java.util.ArrayList;
import java.util.List;

public class ExtractDigitsFromString {

    public static List<Integer> extractDigits(String inputString) {
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < inputString.length() ; i++) {
            if(inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9'){
               al.add(Character.getNumericValue(inputString.charAt(i)));
            }
        }
        return al;
    }

    public static void main(String[] args) {
        String inputString = "Hel21lo874Wor33ld123";
        System.out.println("Digits in the given string: " + extractDigits(inputString));
    }
}
