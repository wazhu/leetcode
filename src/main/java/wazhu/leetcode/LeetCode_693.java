package wazhu.leetcode;

public class LeetCode_693 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_693().hasAlternatingBits(5));
    }

    public boolean hasAlternatingBits(int n) {
        int tmp = (n >> 1) ^ n;
        return (tmp & (tmp + 1)) == 0;
    }
}
