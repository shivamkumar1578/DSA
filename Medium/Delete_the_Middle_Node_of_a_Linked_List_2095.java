package Medium;

public class Delete_the_Middle_Node_of_a_Linked_List_2095 {
    public ListNode deleteMiddle(ListNode head) {
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        if (count == 1) {
            head = null;
            return head;
        }

        ListNode pos = head;
        for (int i = 1; i < count / 2; i++) {
            pos = pos.next;
        }

        pos.next = pos.next.next;
        return head;
    }
}
