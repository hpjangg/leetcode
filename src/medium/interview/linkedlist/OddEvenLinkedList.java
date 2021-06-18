package medium.interview.linkedlist;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode child6 = new ListNode(7);
        ListNode child5 = new ListNode(4, child6);
        ListNode child4 = new ListNode(6, child5);
        ListNode child3 = new ListNode(5, child4);
        ListNode child2 = new ListNode(3, child3);
        ListNode child1 = new ListNode(1, child2);
        ListNode head = new ListNode(2, child1);
        new OddEvenLinkedList().oddEvenList(head);
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
