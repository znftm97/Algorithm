package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.List;

public class _382 {
    private List<Integer> nums = new ArrayList<>();

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void Solution(ListNode head) {
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
