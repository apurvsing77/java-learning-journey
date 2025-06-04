package LeetCode;
//118. Pascal's Triangle
//https://leetcode.com/problems/pascals-triangle/description/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//118. Pascal's Triangle
public class PaskelTrangelLeetcode {
    public static void main(String[] args) {
    int row = 5;
       // System.out.println(generate(row));

            for (List<Integer> l :generate(row)) {
                for (int i = 0; i <row-l.size() ; i++) {
                    System.out.print("  ");
                }
                System.out.println(l);

            }


        generate2(row);
    }
    static List<List<Integer>> generate(int row){
        List<List<Integer>> result = new ArrayList<>();
       List<Integer> firstRow = new ArrayList<>();
       firstRow.add(1);
       result.add(firstRow);

        for (int i = 1; i <row ; i++) {
            List<Integer> prevRow = result.get(i-1);

            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 0; j < i-1 ; j++) {
                newRow.add(prevRow.get(j) + prevRow.get(j+1));
            }
            newRow.add(1);

            result.add(newRow);

        }
        return result;
    }
    static void generate2(int row){

        for (int i = 1; i <=row ; i++) {
            for (int s = 1; s <=row-i ; s++) {
                System.out.print(" ");
            }
            int k=1;
            for (int j = 1; j <=i ; j++) {
                System.out.print(k+" ");
                k= k*(i - j)/j;
            }
            System.out.println();
        }
    }
}
