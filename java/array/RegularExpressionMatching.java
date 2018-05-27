//package array;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class RegularExpressionMatching {
//
//    public static boolean isMatch(String s, String p) {
//        int index = 0;
//        List<String> regexList = new ArrayList<>();
//        while (index < p.length()) {
//            if (p.charAt(index + 1) == '*') {
//                regexList.add(p.substring(index, index + 2));
//                index += 2;
//            } else {
//                regexList.add(String.valueOf(p.charAt(index)));
//                index += 1;
//            }
//        }
//        int start = 0;
//        int end = 0;
//        int regexLeftIdx = 0;
//        int regexRightIdx = 0;
//        while (regexLeftIdx < regexList.size() && start < s.length()) {
//            regexRightIdx = findNextSingleChar(regexList, regexLeftIdx);
//            if (regexRightIdx == -1) {
//                if (checkStar(s, regexList, start, s.length(), regexLeftIdx, regexList.size())) {
//                    return true;
//                }
//                return false;
//            }
//            end = findMatchedSingleChar(s, start, regexList.get(regexRightIdx));
//            if (end == -1) {
//                return false;
//            }
//            if (!checkStar(s, regexList, start, end, regexLeftIdx, regexRightIdx)) {
//                return false;
//            }
//            regexLeftIdx = regexRightIdx + 1;
//            start = end + 1;
//        }
//        if (regexLeftIdx == regexList.size() - 1 && start == s.length() - 1 && s.charAt(start) == regexList.get(regexLeftIdx)) {
//            return false;
//        }
//        return true;
//    }
//
//    private static boolean checkStar(String s, List<String> regexList, int start, int end, int regexLeft, int regexRight) {
//        int regexIdx = regexLeft;
//        for (int i = start; i < end; i++) {
//            if (s.charAt(i) == regexList.get(regexIdx).charAt(0)) {
//                continue;
//            }
//            while (s.charAt(i) != regexList.get(regexIdx).charAt(0)) {
//                regexIdx++;
//                if (regexIdx >= regexRight) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    private static int findMatchedSingleChar(String s, int startIdx, String c) {
//        for (int i = startIdx; i < s.length(); i++) {
//            if (c.charAt(0) == s.charAt(i)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    private static int findNextSingleChar(List<String> regexList, int leftIdx) {
//        for (int i = leftIdx; i < regexList.size(); i++) {
//            if (regexList.get(i).length() == 1) {
//                return i;
//            }
//        }
//        return -1;
//    }
//}
