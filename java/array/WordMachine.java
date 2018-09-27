package array;


import java.util.Stack;

public class WordMachine {
    /*
    13 DUP 4 POP 5 DUP + DUP + -
     */
    public static void main(String[] args) {
        System.out.println(solution("3 DUP 5 - -"));
    }

    public static int solution(String S) {
        if (S == null || S.length() == 0) {
            return -1;
        }
        String[] s = S.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String ss : s) {
            if (ss.startsWith("DUP")) {
                if (stack.isEmpty()) {
                    return -1;
                }
                stack.push(stack.peek());
            } else {
                if (ss.startsWith("POP")) {
                    if (stack.isEmpty()) {
                        return -1;
                    }
                    stack.pop();
                } else {
                    if (ss.equals("+")) {
                        if (stack.size() < 2) {
                            return -1;
                        }
                        int first = stack.pop();
                        int second = stack.pop();
                        if (first + second > Math.pow(2, 20) - 1) {
                            return -1;
                        }
                        stack.push(first + second);
                    } else {
                        if (ss.equals("-")) {
                            if (stack.size() < 2) {
                                return -1;
                            }
                            int first = stack.pop();
                            int second = stack.pop();
                            if (first - second < 0) {
                                return -1;
                            }
                            stack.push(first - second);
                        } else {
                            int push_int = Integer.parseInt(ss);
                            if (push_int > Math.pow(2, 20) - 1) {
                                return -1;
                            }
                            stack.push(push_int);
                        }
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
}
