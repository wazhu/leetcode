package wazhu.leetcode;


public class LeetCode_7 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_7().reverse(34));
    }

    public int reverse(int x) {
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        boolean negative = x < 0;
        char[] tmp = chars;
        if (negative) {
            tmp = new char[chars.length - 1];
            System.arraycopy(chars, 1, tmp, 0, tmp.length);
        }
        for (int i = 0; i < tmp.length / 2; i++) {
            char c = tmp[tmp.length - 1 - i];
            tmp[tmp.length - 1 - i] = tmp[i];
            tmp[i] = c;
        }
        int startIndex = negative ? 1 : 0;
        System.arraycopy(tmp, 0, chars, startIndex, tmp.length);
        try {
            return Integer.parseInt(new String(chars));
        } catch (NumberFormatException e) {
            return 0;
        }


    }
}
