package oa;

public class ACapsLock {
    public static void main(String[] args) {
        System.out.println(pressAForCapsLock("aaaaa"));
    }

    public static String pressAForCapsLock(String message) {
        boolean caps = false;
        StringBuilder res = new StringBuilder();
        for (char s: message.toCharArray()) {
            if (s == 'a') {
                caps = !caps;
            } else {
                if (caps && s >= 'a' && s <= 'z') {
                    res.append(Character.toUpperCase(s));
                } else {
                    res.append(s);
                }
            }
        }
        return res.toString();
        }
}
