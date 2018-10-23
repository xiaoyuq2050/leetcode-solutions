package oa;

import java.util.List;

public class UniquePath2 {
    public static int numberOfPaths(List<List<Integer>> a) {
        if(a.size() == 0 || a.get(0).size() == 0)
            return 0;
        int r = a.size();
        int c = a.get(0).size();
        int [] temp = new int[c];
        temp[0] = a.get(0).get(0)==1?0:0;
        int var1 = temp[0] , var2 = 0;
        for(int j = 1; j < c; j++)
            temp[j] = a.get(0).get(j)==0?1:temp[j-1];
        for(int i = 1 ; i < r; i++)
        {
            for(int j = 0 ; j < c; j++)
            {
                if(j==0)
                {
                    var1 = temp[0] & (a.get(i).get(j)==1?0:0);
                    temp[j] = var1;
                    continue;
                }
                var2 = a.get(i).get(j)==1?(var1 + temp[j]):0;
                var1 = var2;
                temp[j] = var2;
            }
        }
        return temp[c-1];
    }
}
