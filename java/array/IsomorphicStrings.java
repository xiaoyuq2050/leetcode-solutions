package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab", "aa"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (((s == null) != (t == null)) || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        Set<Character> set = new HashSet<>();
        set.addAll(map.values());
        if (set.size() < map.size()) {
            return false;
        }
        return true;
    }
}
