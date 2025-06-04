package StringProblems;

public class EncryptString {

    public static void main(String[] args) {

        String st="aaabbbccc";
        System.out.println(encrypt(st,st.length()));

    }
    static String encrypt(String str ,int n){
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i <n ; i++) {
            char ch= str.charAt(i);
            String hex;
            int count=0;
            while ( i != n && str.charAt(i) == ch)
            {
                count++;
                i++;
            }
            i--;
            ans.append(ch);
            hex=hexa(count);
            ans.append(hex);
        }
        ans.reverse();

      return ans.toString();

    }

    static String hexa(int num ){
        StringBuffer sb= new StringBuffer();
        while (num != 0){
            int rem = num % 16;
            char c;
            if (rem < 10)
                c = (char) (rem + 48);
            else
                c = (char) (rem + 87);
            sb.append(c);
            num = num/16;
        }

        return sb.toString();
    }
}
