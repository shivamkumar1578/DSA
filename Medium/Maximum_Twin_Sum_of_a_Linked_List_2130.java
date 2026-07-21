package Medium;

import java.util.LinkedList;

public class Maximum_Twin_Sum_of_a_Linked_List_2130 {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast = fast.next.next;
        }

        ListNode prev = null;
        while (slow != null) {
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        int ans = 0;
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ans = Math.max(ans, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return ans;
    }
}
