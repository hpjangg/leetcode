package medium.interview.linkedlist;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        ListNode intersection_3 = new ListNode(5);
        ListNode intersection_2 = new ListNode(4, intersection_3);
        ListNode intersection = new ListNode(8, intersection_2);

        ListNode listA_2 = new ListNode(1, intersection);
        ListNode listA = new ListNode(4, listA_2);

        ListNode listB_3 = new ListNode(1, intersection);
        ListNode listB_2 = new ListNode(6, listB_3);
        ListNode listB = new ListNode(5, listB_2);

        new IntersectionOfTwoLinkedLists().getIntersectionNode(listA, listB);
    }

    // Time Complexity: O(N x M)
    // Space Complexity: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode pB = headB;
            while (pB != null) {
                if (headA == pB) {
                    return headA;
                }
                pB = pB.next;
            }
            headA = headA.next;
        }
        return null;
    }
}
