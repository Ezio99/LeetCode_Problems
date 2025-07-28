package org.hireme.leetcode.LinkedList;

public class Comvert_Binary_Linked_1290 {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        ListNode tmp = head;
        while (tmp != null) {
            ans = ans * 2 + tmp.val;
            tmp = tmp.next;
        }
        return ans;
    }
}
