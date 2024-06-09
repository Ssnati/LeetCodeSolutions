package main;

import classes.ListNode;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<int[]> couples = new ArrayList<>();
        if (Arrays.stream(nums).noneMatch(i -> i < 0)) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= target) {
                    couples.add(new int[]{nums[i], i});
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                couples.add(new int[]{nums[i], i});
            }
        }

        for (int i = 0; i < couples.size(); i++) {
            for (int j = 0; j < couples.size(); j++) {
                if ((target - couples.get(i)[0] == couples.get(j)[0]) && j != i) {
                    return new int[]{couples.get(i)[1], couples.get(j)[1]};
                }
            }
        }
        return nums;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = null;
        while (((l1 != null) || (l2 != null) || (carry > 0))) {
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            int total = l1val + l2val + carry;
            carry = total / 10;
            total %= 10;
            if (result == null) result = new ListNode(total);
            else {
                getLastNode(result).next = new ListNode(total);
            }
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return result;
    }

    public ListNode getLastNode(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
}