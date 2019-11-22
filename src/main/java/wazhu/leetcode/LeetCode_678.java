package wazhu.leetcode;

public class LeetCode_678 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_678().checkValidString("(*()"));
    }

    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        int p1 = 0, p2 = -1;
        int leftStarCount = 0;
        for (; p1 < chars.length; p1++) {
            if (chars[p1] == '(') {
                p2 = p1 + 1;
                if (p2 >= chars.length) {
                    return false;
                }
                boolean find = false;
                int nextStar = -1;
                for (; p2 < chars.length; p2++) {
                    if (nextStar == -1 && chars[p2] == '*') {
                        nextStar = p2;
                    }
                    if (chars[p2] == ')') {
                        find = true;
                        break;
                    }
                }
                if (find) {
                    chars[p2] = '\0';
                } else if (nextStar != -1) {
                    chars[nextStar] = '\0';
                    if (p2 < chars.length) {
                        chars[p2] = '\0';
                    }

                } else {
                    return false;
                }

            } else if (chars[p1] == ')') {
                if (leftStarCount > 0) {
                    leftStarCount--;
                } else {
                    return false;
                }
            } else if (chars[p1] == '*') {
                leftStarCount++;
            }
        }
        return true;
    }
}
