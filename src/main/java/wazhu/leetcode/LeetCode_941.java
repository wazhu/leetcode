package wazhu.leetcode;

public class LeetCode_941 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_941().validMountainArray(new int[]{0, 3, 2, 1}));
    }

    public boolean validMountainArray(int[] array) {
        if (array.length == 0) {
            return false;
        }
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        if (maxIndex == 0 || maxIndex == array.length - 1) {
            return false;
        }
        for (int i = maxIndex; i > 0; i--) {
            if (array[i] <= array[i - 1]) {
                return false;
            }
        }
        for (int i = maxIndex; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
