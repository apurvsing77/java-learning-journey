package JavaBasicProgram;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String[] args){
        String str = "I Am Apurv";
        String str2 = "APURV";
        revrseString(str);
//        revrse(str);
    }


    public static String revrseString(String str){
        StringBuffer sb = new StringBuffer();
          String[] strArr = str.split(" ");
          for(int i = strArr.length-1; i >=0 ; i--) {
//              sb.append(strArr[i]+" ");
              sb.append(revrseWorde(strArr[i])+" ");
          }
          System.out.println(Arrays.toString(strArr));
          System.out.println(sb.toString());

        return sb.toString();
    }
    static String revrseWorde(String worde){
        char[] ch = worde.toCharArray();
        int i =0;
        int j = ch.length-1;

        while (i<j){
            char temp =  ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(ch);
    }

    public static String revrse(String str){
        String result = Arrays.stream(str.split(" "))
                .map(word -> new StringBuffer(word).reverse().toString())
                .collect(Collectors.joining(" "));

        result = Arrays.stream(result.split(" ")).collect(Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    Collections.reverse(list);
                    return list.stream().collect(Collectors.joining(" "));
                }
        ));

        System.out.println(result);
        return result;
    }
}
