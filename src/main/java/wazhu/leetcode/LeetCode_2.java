package wazhu.leetcode;

import java.util.Objects;

public class LeetCode_2 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1)) {
            return l2;
        }
        if (Objects.isNull(l2)) {
            return l1;
        }
        ListNode head = new ListNode(l1.val + l2.val);
        l1 = l1.next;
        l2 = l2.next;
        ListNode tmp = head;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            tmp.next = new ListNode(l1.val + l2.val);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (Objects.nonNull(l1)) {
            tmp.next = l1;
        } else if (Objects.nonNull(l2)) {
            tmp.next = l2;
        }
        tmp = head;
        while (Objects.nonNull(tmp)) {
            int value = tmp.val;
            if (value >= 10) {
                tmp.val = value % 10;
                if (Objects.isNull(tmp.next)) {
                    tmp.next = new ListNode(1);
                } else {
                    tmp.next.val++;
                }
            }
            tmp = tmp.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
