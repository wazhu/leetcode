package wazhu.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeetCode_111 {
    public int minDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int count = 1;
        List<TreeNode> currentNodes = new ArrayList<>();
        List<TreeNode> nextNodes = new ArrayList<>();
        nextNodes.add(root);
        while (true) {
            currentNodes = new ArrayList<>(nextNodes);
            nextNodes.clear();
            for (TreeNode e : currentNodes) {
                if (Objects.isNull(e.left) && Objects.isNull(e.right)) {
                    return count;
                } else {
                    if (Objects.nonNull(e.left)) {
                        nextNodes.add(e.left);
                    }
                    if (Objects.nonNull(e.right)) {
                        nextNodes.add(e.right);
                    }
                }
            }
            count++;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
