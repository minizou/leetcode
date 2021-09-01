public class Problem876 {
    /** 876. Middle of the Linked List (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the number of nodes in the linked list
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Use two pointers. Let one pointer increment by 1 and the other pointer increment by 2 each loop. Thus,
     *        the second pointer will always be twice as fast as the first.
     *      - When the second pointer reaches the end of the linked list, the first will be at the middle of the linked
     *        list. Return the first pointer.
     * 3. Alternative Approaches
     *      - Brute Force (Loop through linked list and count the number of nodes, then loop again through
     *        half of them)
     * @param head - the first node of a singly linked list
     * @return the middle node of the linked list (second middle node if there are two middle nodes)
     */

    public ListNode middleNode(ListNode head) {
        ListNode ptrSlow = head;
        ListNode ptrFast = head;
        while (ptrFast != null && ptrFast.next != null) {
            ptrFast = ptrFast.next.next;
            ptrSlow = ptrSlow.next;
        }
        return ptrSlow;
    }
}
