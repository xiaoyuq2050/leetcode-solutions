package oa;

public class ConsecutiveSum {
    public static void main(String[] args) {
        System.out.println(Solution(10));
    }
    public static int Solution(int num) {
//        int res = 0;
//        for (int L = 1; L * (L + 1) < 2 * num; L++) {
//            float a = (float) ((1.0*num-(L * (L + 1)) / 2) / (L + 1));
//            if (a - (int) a == 0.0) {
//                System.out.println(a);
//                res++;
//            }
//        }
//        return res;
        while(num%2==0) num/=2;
        int ans =1;
        //iterate 3,5,7,9... note: when oddNum get to 9, it will just skip because factor 3 already removed.
        for(int oddNum = 3; oddNum*oddNum<=num; oddNum+=2){
            int exponent =0;
            while(num%oddNum==0){
                exponent ++;
                num/=oddNum;
            }
            ans*= (exponent +1);
        }

        //Suppose initial N = P1^e1.P2^e2...Pn^en,  Pi is in assending order

        //so for the last iteration in the above for loop, the oddNum is Pn and N is Pn^en
        if(num==1){ // en>=2 so oddNum*oddNum <= N (which is Pn^en)
            return ans - 1;
        }else{//en==1 so oddNum*oddNum > N (Pn*Pn > Pn^1)
            //why 2 ?: last N is the largest prime number and its exponent is 1
            return ans*2 - 1;
        }
    }
}
