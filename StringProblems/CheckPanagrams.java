package StringProblems;

import java.util.HashSet;
import java.util.Set;

public class CheckPanagrams {
    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";
        if (check(str)){
            System.out.println("This sentens is panagram");
        }else
            System.out.println("This sentence is NOT panagram");
    }
    static  boolean check(String str){
        Set<Character> set= new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                set.add(ch);
            if (ch >= 'A' && ch <= 'Z') {
                ch = Character.toLowerCase(ch);
                set.add(ch);
            }
        }
        if (set.size()==26) {
            return true;
        }else
            return false;
    }

}
