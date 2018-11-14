package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueEmailAddresses {
    /*
    ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
     */
//    public int numUniqueEmails(String[] emails) {
//        Set<String> uniqueEmail = new HashSet<>();
//        String local;
//        String domain;
//        String[] arr = new String[2];
//        for (String email: emails) {
//            arr = email.split("@");
//            local = arr[0].substring(0, arr[0].indexOf('+'));
//            local = local.replaceAll(".", "");
//            domain = arr[1];
//            uniqueEmail.add(local + "@" + domain);
//        }
//        return uniqueEmail.size();
//    }
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            set.add(process(emails[i]));
        }
        return set.size();
    }

    String process(String email) {
        boolean ignore = false;
        char[] ec = email.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ec.length; i++) {
            if (ec[i] == '@') {
                sb.append(email.substring(i));
                break;
            } else if (ec[i] == '+') {
                ignore = true;
            } else if (!ignore && ec[i] != '.') {
                sb.append(ec[i]);
            }
        }
        return sb.toString();
    }
}
