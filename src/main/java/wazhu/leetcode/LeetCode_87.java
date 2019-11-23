package wazhu.leetcode;

public class LeetCode_87 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_87().addBinary("1010", "1011"));
        ;
    }

    public String addBinary(String a, String b) {
        boolean carry = false;
        int p = 1;
        StringBuilder result = new StringBuilder();
        while (p <= a.length() || p <= b.length()) {
            if (p <= a.length() && p <= b.length()) {
                int v = a.charAt(a.length() - p) - '0' + b.charAt(b.length() - p) - '0' + (carry ? 1 : 0);
                if (v >= 2) {
                    carry = true;
                    v -= 2;
                } else {
                    carry = false;
                }
                result.append(v);
            } else if (p <= a.length()) {
                int v = a.charAt(a.length() - p) - '0' + (carry ? 1 : 0);
                if (v >= 2) {
                    carry = true;
                    v -= 2;
                } else {
                    carry = false;
                }
                result.append(v);
            } else if (p <= b.length()) {
                int v = b.charAt(b.length() - p) - '0' + (carry ? 1 : 0);
                if (v >= 2) {
                    carry = true;
                    v -= 2;
                } else {
                    carry = false;
                }
                result.append(v);
            }
            p++;
        }
        if (carry) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}
