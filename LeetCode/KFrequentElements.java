package LeetCode;
//347. Top K Frequent Elements
//https://leetcode.com/problems/top-k-frequent-elements/description/
import java.util.*;

public class KFrequentElements {
    public static void main(String[] args) {
        int[]    arr = {1,1,1,1,2,2,3,2,4};
        System.out.println(Arrays.toString(kfrequentelement(arr,2)));
    }
    static  int[] kfrequentelement(int[] arr , int k){
        List<Integer>[] bucket = new List[arr.length + 1];
        Map<Integer , Integer> frequencyMap = new HashMap<>();

        for (int n : arr ) {
            frequencyMap.put(n , frequencyMap.getOrDefault(n , 0) + 1);
        }
        for (int key : frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int[] res = new int[k];
        int count=0;
        for (int pos = bucket.length-1 ; pos >= 0 && count < k ; pos--) {
            if (bucket[pos] != null){
                for (Integer integer : bucket[pos]){
                    res[count++] =integer;
                }
            }
        }
        return res;
    }
}
