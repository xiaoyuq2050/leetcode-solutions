package oa;

public class MergeStrings {
    public static void main(String[] args) {
        System.out.println(mergeStrings("abc", "d"));
    }
    static String mergeStrings(String a, String b) {
        int length = Math.min(a.length(), b.length());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < length; i++) {
            res.append(a.charAt(i));
            res.append(b.charAt(i));
        }
        if (a.length() > length) {
            res.append(a.substring(length));
        }
        if (b.length() > length) {
            res.append(b.substring(length));
        }
        return res.toString();
    }
}
