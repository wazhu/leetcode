package wazhu.leetcode;

import java.util.Arrays;

public class LeetCode_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode_1().twoSum(new int[]{-1, -2, -3, -4, -5}, -8)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] newArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newArray);
        for (int i = 0; i < newArray.length; i++) {
            int tmp = target - newArray[i];
            int index1 = -1, index2 = -1;
            if (Arrays.binarySearch(newArray, i + 1, newArray.length, tmp) >= 0) {
                for (int j = 0; j < nums.length; j++) {
                    if (index1 == -1 && nums[j] == newArray[i]) {
                        index1 = j;
                    } else if (nums[j] == tmp) {
                        index2 = j;
                    }
                    if (index1 != -1 && index2 != -1) {
                        return new int[]{index1, index2};
                    }
                }
            }

        }
        return new int[]{-1, -1};
    }
}
