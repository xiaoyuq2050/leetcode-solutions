package oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReformaDates {
    /*
    20th Oct 2052
6th Jun 1933
26th May 1960
20th Sep 1958
16th Mar 2068
25th May 1912
16th Dec 2018
26th Dec 2061
4th Nov 2030
28th Jul 1963

2052-10-20
1933-06-06
1960-05-26
1958-09-20
2068-03-16
1912-05-25
2018-12-16
2061-12-26
2030-11-04
1963-07-28
     */
    public static List<String> reformatDate(List<String> dates) {
        List<String> res = new ArrayList<>();
        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");
        for (String s: dates) {
            int first_s_idx = s.indexOf(" ");
            int second_s_idx = s.indexOf(" ", first_s_idx + 1);
            String date_old = s.substring(0, first_s_idx);
            String date_new = date_old.substring(0, date_old.length() - 2);
            if (date_new.length() < 2) {
                date_new = "0" + date_new;
            }
            String month_new = monthMap.get(s.substring(first_s_idx + 1, second_s_idx));
            String year = s.substring(second_s_idx + 1);
            res.add(year + "-" + month_new + "-" + date_new);
        }
        return res;
    }
}
