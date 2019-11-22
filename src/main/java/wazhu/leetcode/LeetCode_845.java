package wazhu.leetcode;

public class LeetCode_845 {
    public static void main(String[] args) {
        int[] array = {875, 884, 239, 731, 723, 685};
        System.out.println(new LeetCode_845().longestMountain(array));
    }

    public int longestMountain(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int count = 0, maxCount = 0, index = 0;
        for (; index < array.length - 1; index++) {
            if (array[index] < array[index + 1]) {
                break;
            }
        }
        if (index == array.length - 1) {
            return 0;
        }
        int tmp = array[index];
        count = 1;
        boolean up = true;
        for (int i = index + 1; i < array.length; i++) {
            if (array[i] > tmp) {
                if (up) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    up = true;
                    count = 2;
                }
            } else if (array[i] < tmp) {
                if (!up) {
                    count++;
                } else {
                    count++;
                    up = false;
                }
            } else if (array[i] == tmp) {
                if (up) {
                    count = 1;
                    up = true;
                    for (; i < array.length - 1; i++) {
                        if (array[i] < array[i + 1]) {
                            break;
                        }
                    }
                    tmp = array[i];
                } else {
                    up = true;
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            tmp = array[i];
        }
        if (!up) {
            return Math.max(count, maxCount);
        }
        return maxCount;
    }
}
