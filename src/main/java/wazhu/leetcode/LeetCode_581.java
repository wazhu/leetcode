package wazhu.leetcode;

import java.util.Arrays;

public class LeetCode_581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int first = 0, last = nums.length;
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] == nums[i]) {
                first++;
            } else {
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (last <= first) {
                break;
            }
            if (copy[i] == nums[i]) {
                last--;
            } else {
                break;
            }
        }
        return last - first;
    }
}
