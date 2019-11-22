package wazhu.leetcode;

import java.util.Stack;

public class LeetCode_227 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_227().calculate("0 - 0"));
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        String[] nums = s.split("[\\+\\-\\*\\/]");
        String[] ops = s.split("\\d+");
        numStack.push(Integer.valueOf(nums[0]));
        int numPoint = 1;
        for (int i = 1; i < ops.length; i++) {
            char op = ops[i].charAt(0);
            if (op == '+' || op == '-') {
                opStack.push(op);
                numStack.push(Integer.valueOf(nums[numPoint++]));
            } else {
                int first = numStack.pop();
                int second = Integer.parseInt(nums[numPoint++]);
                int v = 0;
                if (op == '*') {
                    v = first * second;
                } else if (op == '/') {
                    v = first / second;
                }
                numStack.push(v);
            }
        }
        Integer[] integers = numStack.toArray(new Integer[0]);
        Character[] op = opStack.toArray(new Character[0]);
        int v = integers[0];
        for (int i = 0; i < op.length; i++) {
            if (op[i] == '+') {
                v += integers[i + 1];
            } else {
                v -= integers[i + 1];
            }
        }
        return v;
    }
}
