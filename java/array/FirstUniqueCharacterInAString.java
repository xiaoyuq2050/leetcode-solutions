package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
            } else {
                charMap.put(s.charAt(i), 1);
            }
        }
        for (int j = 0; j < s.length(); j++) {
            if (charMap.get(s.charAt(j)) == 1) {
                return j;
            }
        }
        return -1;
    }
//    public static int firstUniqChar(String s) {
//        if (s == null || s.length() == 0) {
//            return -1;
//        }
//        if (s.length() == 1) {
//            return 0;
//        }
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        System.out.println(Arrays.toString(chars));
//        for (int i = 0; i < chars.length; i++) {
//            if (i == 0) {
//                if (chars[0] != chars[1]) {
//                    return 0;
//                }
//                continue;
//            }
//            if (i == chars.length - 1) {
//                if (chars[i - 1] != chars[i]) {
//                    return i;
//                }
//                return -1;
//            }
//            if (chars[i - 1] != chars[i] && chars[i] != chars[i + 1]) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
