package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicographicalSubstring {

    public static void main(String[] args) {
        System.out.println(solution("aiuewhjf"));
    }

    public static String solution(String a) {
        List<String> res = new ArrayList<>();
        char maxChar = 'a';
        char[] sc = a.toCharArray();
        for(int i = 0; i < sc.length; i++) {
            if(sc[i] > maxChar) {
                maxChar = sc[i];
                res.clear();
                res.add(a.substring(i));
            } else if(sc[i] == maxChar) {
                res.add(a.substring(i));
            }
        }
        Collections.sort(res);
        return res.get(res.size()-1);
    }
}
