package wazhu.leetcode;

public class LeetCode_387 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_387().firstUniqChar("abcbabdc"));
        ;
    }

    public int firstUniqChar(String s) {
        int[] array = new int[27];
        int[] pos = new int[27];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            array[index]++;
            if (pos[index] == 0) {
                pos[index] = i;
            }
        }
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                minIndex = Math.min(minIndex, pos[i]);
            }
        }
        if (minIndex == Integer.MAX_VALUE) {
            return -1;
        }
        return minIndex;
    }
}
