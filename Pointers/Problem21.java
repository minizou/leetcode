public class Problem21 {
    /** 21. Merge Two Sorted Lists (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the sum of the length of the two sorted lists
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - [VIDEO EXPLANATION: https://imgur.com/a/MP72A6q]
     *      - First determine which list contains the head of the merged linked list (which head of the two lists
     *        has a lesser value). Then compare the values at the pointers to determine the next node in the sequence.
     *      - Continue this process until one of the pointers reaches the end of the list.
     *      - Let the next node point to the non-null pointer and return the head the merged linked list.
     * 3. Alternative Approaches
     *      - Implement a recursive solution instead.
     *
     * @param l1 - sorted linked list in non-decreasing order
     * @param l2 - another sorted linked list in non-decreasing order
     * @return the merged and sorted linked list made by splicing together the nodes of l1 and l2
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1, ptr2 = l2;
        ListNode last; // denotes current last node in merged linked list
        ListNode head; // head of merged linked list

        if (l1 == null) { // empty list edge cases
            return l2;
        } else if (l2 == null) { return l1; }

        if (l1.val > l2.val) { // determining head of merged linked list
            head = l2;
            last = l2;
            ptr2 = ptr2.next;
        } else {
            head = l1;
            last = l1;
            ptr1 = ptr1.next;
        }

        while (ptr1 != null && ptr2 != null) { // putting nodes in sorted order
            if (ptr1.val < ptr2.val) {
                last.next = ptr1;
                last = ptr1;
                ptr1 = ptr1.next;
            } else {
                last.next = ptr2;
                last = ptr2;
                ptr2 = ptr2.next;
            }
        }

        if (ptr1 != null) { // adding remaining nodes to merged list
            last.next = ptr1;
        } else if (ptr2 != null) { last.next = ptr2; }

        return head;
    }
}
