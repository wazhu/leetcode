package wazhu.leetcode;

public class LeetCode_8 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_8().myAtoi("  +123"));
    }

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        boolean begin = false;
        char prefix = '+';
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!begin) {
                if (c == ' ') {
                    continue;
                } else if (c == '+' || c == '-') {
                    prefix = c;
                    begin = true;
                } else if (c >= '0' && c <= '9') {
                    stringBuilder.append(c);
                    begin = true;
                } else {
                    return 0;
                }
            } else {
                if (c >= '0' && c <= '9') {
                    stringBuilder.append(c);
                } else {
                    break;
                }
            }
        }
        stringBuilder.insert(0, prefix);
        if (stringBuilder.length() < 2) {
            return 0;
        }
        try {

            return Integer.parseInt(stringBuilder.toString());
        } catch (NumberFormatException e) {
            if (prefix == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
}
