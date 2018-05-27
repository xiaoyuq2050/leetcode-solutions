package array;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    // Solution 1: time complexity: O(m * n * logn)
    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            // time complexity: O(n * logn)
            Arrays.sort(charArray);
            String stringKey = new String(charArray);
            if (anagramMap.containsKey(stringKey)) {
                List<String> originList = anagramMap.get(stringKey);
                originList.add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                anagramMap.put(stringKey, newList);
            }
        }
        System.out.println(anagramMap.size());
        // 新建arraylist 参数为map.values()
        return new ArrayList<>(anagramMap.values());
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String s : strs) {
            // 构造一个长度为26的charArray，将s中的character按字母顺序加进去。
            // 时间复杂度：O(n)
            int[] charArray = new int[26];
            String stringKey = "";
            for (int i = 0; i < s.length(); i++) {
                charArray[s.charAt(i) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (charArray[j] != 0) {
                    stringKey += String.valueOf(charArray[j]) + String.valueOf((char) (j + 'a'));
                }
            }
            // 以下与Solution1相同
            if (anagramMap.containsKey(stringKey)) {
                List<String> originList = anagramMap.get(stringKey);
                originList.add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                anagramMap.put(stringKey, newList);
            }
        }
        return new ArrayList<>(anagramMap.values());
    }
}
