package oa;


import java.util.Scanner;

public class Toutiao_oa {

    public static void main(Scanner scanner) {
        int t = 0;
        if (scanner.hasNextLine()) {
            t = Integer.parseInt(scanner.nextLine());
        }
        if (t > 0) {
            while (scanner.hasNextLine()) {
                int n = Integer.parseInt(scanner.nextLine());
                String s1 = scanner.nextLine();
                String s2 = scanner.nextLine();
                if (isValidPermutation(s1, s2)) {
                    System.out.println("Yeah");
                } else {
                    System.out.println("Sad");
                }
            }
        }
    }

    private static boolean isValidPermutation(String s1, String s2) {
        String[] permutations = getPermutation(s1);
        for (String permutation: permutations) {
            if (s2.equals(permutation)) {
                return true;
            }
            String reversed = new StringBuilder(permutation).reverse().toString();
            if (s2.equals(reversed)) {
                return true;
            }
        }
        return false;
    }

    private static String[] getPermutation(String s) {
        String[] res = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(i)).append(s.substring(0, i));
            res[i] = sb.toString();
        }
        return res;
    }
}
