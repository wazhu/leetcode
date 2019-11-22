package wazhu.leetcode;

public class LeetCode_994 {
    //[[2,1,1],[0,1,1],[1,0,1]]
    public static void main(String[] args) {
        System.out.println(new LeetCode_994().orangesRotting(new int[][]{new int[]{2, 1, 1}, new int[]{0, 1, 1}, new int[]{1, 0, 1}}));
        ;
    }

    public int orangesRotting(int[][] grid) {
        int count = 0;
        while (true) {
            boolean mark = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 2) {
                        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                            mark = true;
                            grid[i - 1][j] = 3;
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                            mark = true;
                            grid[i][j - 1] = 3;
                        }
                        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                            mark = true;
                            grid[i + 1][j] = 3;
                        }
                        if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
                            mark = true;
                            grid[i][j + 1] = 3;
                        }
                    }
                }
            }

            if (!mark) {
                break;
            }
            count++;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 3) {
                        grid[i][j] = 2;
                    }
                }

            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }

        }
        return count;
    }
}
