package wazhu.leetcode;


public class LeetCode_415 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_415().addStrings("9", "99"));
    }


    public String addStrings(String num1, String num2) {
        if (num1.trim().length() == 0) {
            return num2;
        }
        if (num2.trim().length() == 0) {
            return num1;
        }
        int num1Length = num1.length();
        int num2Length = num2.length();
        int p = 1, pMax = Math.min(num1Length, num2Length);
        StringBuilder stringBuilder = new StringBuilder();
        boolean incent = false;
        while (p <= pMax) {
            char c1 = num1.charAt(num1Length - p);
            char c2 = num2.charAt(num2Length - p);
            int v = (c1 - '0') + (c2 - '0') + (incent ? 1 : 0);
            incent = false;
            if (v >= 10) {
                incent = true;
                v -= 10;
            }
            stringBuilder.append((char) ('0' + v));
            p++;
        }
        String left = num1Length > num2Length ? num1 : (num2Length > num1Length ? num2 : null);
        if (left == null) {
            if (incent) {
                stringBuilder.append('1');
            }
            return stringBuilder.reverse().toString();
        }
        for (; p <= left.length(); p++) {
            int v = left.charAt(left.length() - p) - '0';
            if (incent) {
                v++;
            }
            incent = false;
            if (v >= 10) {
                v -= 10;
                incent = true;
            }
            stringBuilder.append((char) (v + '0'));
        }
        if (incent) {
            stringBuilder.append('1');
        }
        return stringBuilder.reverse().toString();
    }
}
