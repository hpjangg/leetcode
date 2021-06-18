package medium.interview.linkedlist;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1_next_next = new ListNode(3);
        ListNode l1_next = new ListNode(4, l1_next_next);
        ListNode l1 = new ListNode(2, l1_next);

        ListNode l2_next_next = new ListNode(4);
        ListNode l2_next = new ListNode(6, l2_next_next);
        ListNode l2 = new ListNode(5, l2_next);
        new AddTwoNumbers().addTwoNumbers(l1, l2);
    }

    // Time Complexity: O(max(m,n))
    // Space Complexity: O(max(m,n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}

