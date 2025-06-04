package LeetCode150;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
  String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> mapfrequency = new HashMap<>();

        for (String key: strs) {
            String stringFrequincy = getStringfreq(key);

            if (mapfrequency.containsKey(stringFrequincy)){
                mapfrequency.get(stringFrequincy).add(key);
            }else {
                List<String> list = new ArrayList<>();
                list.add(key);
                mapfrequency.put(stringFrequincy,list);
            }
        }
        return new ArrayList<>(mapfrequency.values());
    }

    private static String getStringfreq(String key) {
        int[] arr = new int[26];
        for (int i = 0; i <key.length() ; i++) {
            arr[key.charAt(i)-'a']++;
        }
        StringBuffer sb = new StringBuffer();
        char c= 'a';
        for (int i: arr) {
            sb.append(c);
            sb.append(i);
            c++;
        }
        return sb.toString();
    }

}
