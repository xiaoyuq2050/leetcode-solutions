package oa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindFirstRepeatedWord {
    public static void main(String[] args) {
        System.out.println(firstRepeatedWord("He    had had,quite enough:of.this nonsense."));
    }
    public static String firstRepeatedWord(String s) {
        // Write your code here
        String[] words = s.split("\\s+|,+|:+|;+|-+|\\.+");
        System.out.println(Arrays.toString(words));
        Set<String> wordset = new HashSet<>();
        for (String word: words) {
            if (wordset.contains(word)) {
                return word;
            } else {
                wordset.add(word);
            }
        }
        return null;
    }
}
