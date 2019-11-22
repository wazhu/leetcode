package wazhu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_79 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_79().exist(new char[][]{{'a', 'a'}}, "aaa"));
    }

    public boolean exist(char[][] board, String word) {
        List<Point> usedPoints = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (check(board, j, i, word, 0, usedPoints)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, int currentX, int currentY, String word, int index, List<Point> usedPoint) {
        if (currentY < 0 || currentY >= board.length) {
            return false;
        } else if (currentX < 0 || currentX >= board[currentY].length) {
            return false;
        }
        Point e = new Point(currentX, currentY);
        if (usedPoint.contains(e)) {
            return false;
        }
        if (board[currentY][currentX] != word.charAt(index)) {
            return false;
        }
        index++;
        if (index == word.length()) {
            return true;
        }
        usedPoint.add(e);
        boolean b = check(board, currentX - 1, currentY, word, index, usedPoint);
        if (!b) {
            b = check(board, currentX, currentY - 1, word, index, usedPoint);
        }
        if (!b) {
            b = check(board, currentX + 1, currentY, word, index, usedPoint);
        }
        if (!b) {
            b = check(board, currentX, currentY + 1, word, index, usedPoint);
        }
        if (!b) {
            usedPoint.remove(e);
        }
        return b;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
