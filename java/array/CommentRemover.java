package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommentRemover {
    public static void main(String[] sr) {
//        System.out.println(Arrays.toString(incode("d/*/e*//f")));
        System.out.println(removeComments(new String[]{"   //*/ cout << success;*/"}));
        System.out.println(removeComments(new String[] {"  /* declare a Node", "   /**/"}));
        System.out.println(removeComments(new String[] {"  /* declare a Node", "   /**/", "   //*/ cout << success;*/"}));
    }

    private static String[] incode(String s) {
        StringBuilder res = new StringBuilder();
        if (s.contains("//") && s.indexOf("//") < s.indexOf("/*")) {
            return new String[] {s.substring(0, s.indexOf("//")), "0"};
        }
        res.append(s.substring(0, s.indexOf("/*")));
        boolean span = false;
        int index = s.indexOf("/*") + 2;
        while (index < s.length()) {
            if (s.substring(index).contains("//")) {
                if (s.substring(index).contains("*/")) {
                    if (s.indexOf("*/", index) < s.indexOf("//", index)) {
                        index = s.indexOf("*/", index);
                    } else {
                        span = true;
                        break;
                    }
                } else {
                    span = true;
                    break;
                }
            } else {
                if (s.substring(index).contains("*/")) {
                    index = s.indexOf("*/", index);
                } else {
                    span = true;
                    break;
                }
            }
            int code_start = index + 2;
            int code_break = s.indexOf("//", code_start);
            int code_end = s.indexOf("/*", code_start);
            if (code_end == -1) {
                if (code_break == -1) {
                    res.append(s.substring(code_start));
                    break;
                } else {
                    res.append(s.substring(code_start, code_break));
                    break;
                }
            } else {
                if (code_break == -1 || code_break > code_end) {
                    res.append(s.substring(code_start, code_end));
                } else {
                    res.append(s.substring(code_start, code_break));
                    break;
                }
            }
            index = code_end + 2;
            if (index >= s.length()) {
                span = true;
                break;
            }
        }
        String span_s = span ? "1" : "0";
        return new String[]{res.toString(), span_s};
    }

    public static List<String> removeComments(String[] source) {
        boolean inspan = false;
        List<String> res = new ArrayList<>();
        StringBuilder spancomment = new StringBuilder();
        for (int i = 0; i < source.length; i++) {
            if (!inspan) {
                if (!source[i].contains("/*")) {
                    if (!source[i].contains("//")) {
                        res.add(source[i]);
                    } else {
                        res.add(source[i].substring(0, source[i].indexOf("//")));
                    }
                } else {
                    spancomment.append(incode(source[i])[0]);
                    if (incode(source[i])[1].equals("0")) {
                        res.add(spancomment.toString());
                        spancomment = new StringBuilder();
                    } else {
                        inspan = true;
                    }
                }
            } else {
                if (source[i].contains("*/")) {
                    inspan = false;
                    int j = source[i].indexOf("*/") + 2;
                    if (j >= source[i].length()) {
                        res.add(spancomment.toString());
                        spancomment = new StringBuilder();
                    } else {
                        if (source[i].substring(j).contains("/*")) {
                            spancomment.append(incode(source[i].substring(j))[0]);
                            if (incode(source[i].substring(j))[1].equals("0")) {
                                res.add(spancomment.toString());
                                spancomment = new StringBuilder();
                            } else {
                                inspan = true;
                            }
                        } else {
                            spancomment.append(source[i].substring(j));
                            res.add(spancomment.toString());
                            spancomment = new StringBuilder();
                        }
                    }
                }
            }
            System.out.println(spancomment);
        }
        res.removeAll(Collections.singleton(""));
        return res;
    }


}
