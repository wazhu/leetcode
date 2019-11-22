package wazhu.leetcode;

public class LeetCode_457 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_457().circularArrayLoop(new int[]{-2, -3, -9}));
    }

    public boolean circularArrayLoop(int[] nums) {
        outter:
        for (int i = 0; i < nums.length; i++) {
            boolean postive = nums[i] > 0;
            int[] used = new int[nums.length];
            int index = i;
            while (used[index] != 1) {
                if (postive && nums[index] < 0) {
                    continue outter;
                } else if (!postive && nums[index] > 0) {
                    continue outter;
                }
                used[index]++;
                index += nums[index];
                while (index >= nums.length) {
                    index -= nums.length;
                }
                while (index < 0) {
                    index += nums.length;
                }
            }
            if (Math.abs(nums[index]) % nums.length != 0) {
                return true;
            }
        }
        return false;
    }
}
