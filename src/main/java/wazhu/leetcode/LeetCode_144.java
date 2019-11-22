package wazhu.leetcode;

import java.util.*;

public class LeetCode_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            result.add(root.val);
            if (Objects.nonNull(root.right)) {
                stack.push(root.right);
            }
            if (Objects.nonNull(root.left)) {
                root = root.left;
            } else if (!stack.isEmpty()) {
                root = stack.pop();
            } else {
                break;
            }
        }
        return result;
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
