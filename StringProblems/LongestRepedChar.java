package StringProblems;

public class LongestRepedChar {
    public static void main(String[] args) {
  String str="aaaabbbbbccccnnnnnxzxzxzxzxzxzxzxzxzxzxzxzxzxzxzxxzxz";
        System.out.println("longest Repeted Char is : "+strcheck(str));
    }

    static  char strcheck(String str){

        int len = str.length();
        int count =0;
        char res = str.charAt(0);
        for (int i = 0; i < len; i++) {

            int curent_count =1;
            for (int j = i+1; j <len ; j++) {
                if (str.charAt(i) != str.charAt(j))
                    break;
                curent_count++;
            }
            if (curent_count>count){
                count = curent_count;
                res =str.charAt(i);
            }
        }

return res;
    }
}
