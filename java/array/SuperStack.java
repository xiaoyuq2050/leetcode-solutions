package array;

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
        superStack(new String[] {"12", "push 4", "pop", "push 3", "push 5", "push 2", "inc 3 1",
        "pop", "push 1", "inc 2 2", "push 4", "pop", "pop"});
    }
    static void superStack(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].startsWith("push")) {
                list.add(Integer.valueOf(operations[i].substring(5)));
                System.out.println(list.get(list.size() - 1));
            } else {
                if (operations[i].startsWith("pop")) {
                    list.remove(list.size() - 1);
                    if (list.isEmpty()) {
                        System.out.println("EMPTY");
                    } else {
                        int res = list.get(list.size() - 1);
                        System.out.println(res);
                    }
                } else {
                    int add_idx = operations[i].indexOf(' ', 5);
                    int num_int = Integer.valueOf(operations[i].substring(4, add_idx));
                    int added = Integer.valueOf(operations[i].substring(add_idx + 1));
                    for (int j = 0; j < num_int; j++) {
                        list.set(j, list.get(j) + added);
                    }
                    System.out.println(list.get(list.size() - 1));
                }
            }
        }
    }
}
