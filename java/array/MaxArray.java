package array;

import java.util.Scanner;

public class MaxArray {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        String[] first_line = scan.nextLine().split(" ");
        int arraylen = Integer.valueOf(first_line[0]);
        int operanum = Integer.valueOf(first_line[1]);
        int[] res = new int[arraylen];
        int operacnt = 0;
        while (scan.hasNextLine() && operacnt <= operanum){
            operacnt++;
            String data[]=scan.nextLine().split(" ");
            int start = Integer.valueOf(data[0]) - 1;
            int end = Integer.valueOf(data[1]) - 1;
            int addend = Integer.valueOf(data[2]);
            for (int i = start; i <= end; i++) {
                res[i] += addend;
            }
        }
        int max = 0;
        for (int i = 0; i < arraylen; i++) {
            if (res[i] > max) {
                max = res[i];
            }
        }
        System.out.println(max);
    }
}
