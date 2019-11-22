package wazhu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LeetCode_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<Double> result = new ArrayList<>();
        List<TreeNode> currentNodes = null;
        List<TreeNode> nextNodes = new ArrayList<>();
        nextNodes.add(root);
        while (true) {
            currentNodes = nextNodes;
            int count = currentNodes.size();
            nextNodes = new ArrayList<>();
            double sum = 0;
            for (TreeNode n : currentNodes) {
                sum += n.val;
                if (Objects.nonNull(n.left)) {
                    nextNodes.add(n.left);
                }
                if (Objects.nonNull(n.right)) {
                    nextNodes.add(n.right);
                }
            }
            result.add(sum / count);
            if (nextNodes.isEmpty()) {
                break;
            }
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
