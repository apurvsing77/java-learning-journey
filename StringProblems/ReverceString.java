package StringProblems;

public class ReverceString {
    public static void main(String[] args) {
        String res="";
        String str[]="Revarce The String".split(" ");
        for (int i = 0; i <str.length ; i++) {
            String str2[] = str[i].split("");
            res += reverse2(str2);
        }
        System.out.println(res);
        reverse(str);
    }
    static  void reverse(String str[]){
        String revstr="";

        for (int i = str.length-1; i >=0; i--) {
            revstr += str[i];
            if (i==0)
            {
                break;
            }else revstr +="_";
        }


        System.out.println(revstr);
    }
    static  String reverse2(String str[]){
        String revstr2="";

        for (int i = str.length-1; i >=0; i--) {
            revstr2 += str[i];

        }

        return revstr2;

    }

}
