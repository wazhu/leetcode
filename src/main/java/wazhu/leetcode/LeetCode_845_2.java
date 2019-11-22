package wazhu.leetcode;

public class LeetCode_845_2 {
    public static void main(String[] args) {
        int[] array = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(new LeetCode_845_2().longestMountain(array));
    }

    public int longestMountain(int[] array) {
        if (array.length < 3) {
            return 0;
        }
        int top = 0;
        int maxCount = 0;
        while ((top = findTop(array, top)) != -1) {
            int left = top - 1;
            int right = top + 1;
            while (left > 0) {
                if (array[left] > array[left - 1]) {
                    left--;
                } else {
                    break;
                }
            }
            while (right < array.length - 1) {
                if (array[right] > array[right + 1]) {
                    right++;
                } else {
                    break;
                }
            }
            maxCount = Math.max(right - left + 1, maxCount);
        }
        return maxCount;
    }

    private int findTop(int[] array, int from) {
        for (int i = from + 1; i < array.length; i++) {
            if (i - 1 < 0 || i + 1 == array.length) {
                continue;
            }
            if (array[i - 1] < array[i] && array[i + 1] < array[i]) {
                return i;
            }
        }

        return -1;
    }
}
