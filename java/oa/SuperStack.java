package oa;

import java.util.ArrayList;
import java.util.List;

public class SuperStack {
    /*
    12
push 4
pop
push 3
push 5
push 2
inc 3 1
pop
push 1
inc 2 2
push 4
pop
pop
     */
    public static void main(String[] args) {
        superStack(new String[]{"12", "push 4", "pop", "push 3", "push 5", "push 2", "inc 3 1",
                "pop", "push 1", "inc 2 2", "push 4", "pop", "pop"});
    }

    static void printline(String s) {
        if (s.contains(" ")) {
            int space_idx = s.indexOf(" ");
            int s1 = Integer.valueOf(s.substring(0, space_idx));
            int s2 = Integer.valueOf(s.substring(space_idx + 1));
            System.out.println(s1 + s2);
        } else {
            System.out.println(Integer.valueOf(s));
        }
    }

    static void superStack(String[] operations) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < operations.length; i++) {
            if (operations[i].startsWith("push")) {
                list.add(operations[i].substring(5));
                System.out.println(Integer.valueOf(list.get(list.size() - 1)));
            } else {
                if (operations[i].startsWith("pop")) {
                    if (list.size() == 1) {
                        list.remove(list.size() - 1);
                        System.out.println("EMPTY");
                    } else {
                        if (list.get(list.size() - 1).contains(" ")) {
                            int space_idx = list.get(list.size() - 1).indexOf(" ");
                            String toadd = list.get(list.size() - 1).substring(space_idx + 1);
                            list.remove(list.size() - 1);
                            if (list.get(list.size() - 1).contains(" ")) {
                                int new_space_idx = list.get(list.size() - 1).indexOf(" ");
                                int new_toadd = Integer.valueOf(list.get(list.size() - 1).substring(new_space_idx + 1))
                                        + Integer.valueOf(toadd);
                                list.set(list.size() - 1, list.get(list.size() - 1).substring
                                        (0, new_space_idx) + " " + Integer.toString(new_toadd));
                                printline(list.get(list.size() - 1));
                            } else {
                                list.set(list.size() - 1, list.get(list.size() - 1) + " " + toadd);
                                printline(list.get(list.size() - 1));
                            }
                        } else {
                            list.remove(list.size() - 1);
                            printline(list.get(list.size() - 1));
                        }
                    }
                } else {
                    if (operations[i].startsWith("inc")) {
                        int add_idx = operations[i].indexOf(' ', 5);
                        int num_int = Integer.valueOf(operations[i].substring(4, add_idx));
                        int added = Integer.valueOf(operations[i].substring(add_idx + 1));
                        if (list.get(num_int - 1).contains(" ")) {
                            int ori_added_idx = list.get(num_int - 1).indexOf(" ");
                            int ori_added = Integer.valueOf(list.get(num_int - 1).substring(ori_added_idx + 1));
                            String new_added = Integer.toString(ori_added + added);
                            list.set(num_int - 1, list.get(num_int - 1).substring(0, ori_added_idx) + " " + new_added);
                        } else {
                            list.set(num_int - 1, list.get(num_int - 1) + " " + Integer.toString(added));
                        }
                        printline(list.get(list.size() - 1));
                    }
                }
            }
        }
    }
}
