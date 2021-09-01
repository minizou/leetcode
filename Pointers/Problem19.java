public class Problem19 {
    /** 19. Remove Nth Node From End of List (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the number of nodes in the list
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Use two pointers. Let there be n + 1 spaces the pointers such
     *        that when the further (fast) pointer reaches the end of the
     *        list, the other pointer will be directly before the node to
     *        be removed.
     *
     *      - [Method 1] After incrementing the number of spaces between the pointers
     *        check if the further (fast) pointer is at the end of the list (null). If
     *        so, then the nth node to be removed is the first node (the head).
     *        Change the head to the next node if this is the case.
     *
     *      - [Method 2] Use a dummy head node to account for when the head is to be removed.
     *        Return the node after the head node.
     * @param head - head of a linked list
     * @param n - number of nodes from the end of the list
     * @return the head of the linked list after deleting the nth node from the end of the list
     */

    // Method 1. In-Place Change, No Dummy Head
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) { return null; }
        ListNode ptrSlow = head;
        ListNode ptrFast = head; // ptr reaching the end; fast ptr

        while (n > 0) { // gets n spaces between ptr1 and ptr2
            ptrFast = ptrFast.next;
            n--;
        }

        if (ptrFast == null) { // null if head is being removed
            head = head.next;
        } else {
            // so that when ptrFast is null, ptrSlow will be right before removed element
            ptrFast = ptrFast.next;
        }

        while (ptrFast != null) { // move ptrFast to end of list
            ptrSlow = ptrSlow.next;
            ptrFast = ptrFast.next;
        }

        ptrSlow.next = ptrSlow.next.next; // skips removed element
        return head;
    }

    // Method 2. Dummy Head
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode ptrSlow = newHead;
        ListNode ptrFast = newHead; // ptr reaching the end; fast ptr

        for (int i = 0; i < n + 1; i++) { // gets ptr2 properly ahead
            ptrFast = ptrFast.next;
        }

        while (ptrFast != null) {
            ptrSlow = ptrSlow.next;
            ptrFast = ptrFast.next;
        }

        ptrSlow.next = ptrSlow.next.next;
        return newHead.next;
    }
}
