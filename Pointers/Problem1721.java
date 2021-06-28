public class Problem1721 {
    /** 1721. Swapping Nodes in a Linked List (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the length of the linked list [Both Methods]
     *      - Space complexity: O(1) [Both Methods]
     * 2. Intuition
     *      - [Method 1] Find the kth node using a pointer. Record this value. Then continue moving
     *        the pointer along with another pointer.
     *      - When the first pointer reaches the end of the linked list, the other pointer
     *        now points to the kth node from the end. Record this value as well.
     *      - Swap the two values using a temporary int container.
     *      - [Method 2] Similar to Method 1, the main idea is to record the two nodes at new pointers and
     *        swap these values later. The main difference lies in finding the kth node from the end.
     *      - Rather than taking advantage of the first pointer, find the length of the linked list and then
     *        subtract k from it to find the kth node from the end.
     * 3. Alternative Approaches
     *      - Rather than only swapping the values, record k's node, it's next value, and the previous node
     *        so that the nodes can actually be swapped rather than just their values.
     *
     * @param head - head of a linked list
     * @param k - integer index
     * @return the head of the linked list after swapping the values of the kth node from the beginning
     * and the kth node from the end (the list is 1-indexed)
     */

    // Method 1. One-Pass Cleaned Variation
    public ListNode swapNodes(ListNode head, int k) {
        ListNode newHead = new ListNode(0, head); // to deal with 1-indexed list
        ListNode ptr = newHead;
        ListNode ptrOther = newHead; // to point to node at kth node from the end
        ListNode ptrK = null; // to point to node at kth node from the beginning

        while (k > 0) { // finding kth node
            ptr = ptr.next;
            k--;
        }
        ptrK = ptr;

        while (ptr != null) { // finding kth node from the end
            ptr = ptr.next;
            ptrOther = ptrOther.next;
        }

        // swapping values
        int temp = ptrOther.val;
        ptrOther.val = ptrK.val;
        ptrK.val = temp;
        return newHead.next; // returns old head
    }

    // Method 2. Initial Solution
    public ListNode swapNodes2(ListNode head, int k) {
        ListNode ptr = head;
        int length = 1;

        while (ptr != null) { // determines length of linked list
            length++;
            ptr = ptr.next;
        }

        ptr = head;
        int index = 1;
        ListNode ptrK = null; // to point to kth node from the beginning
        ListNode ptrOther = head; // to point to kth node from the end

        while (ptr != null) {
            if (index == k) { // k is found
                ptrK = ptr;
            }
            if (index++ == length - k) { // to point to kth node from the end is found
                ptrOther = ptr;
            }
            ptr = ptr.next;
        }

        // swapping values
        int temp = ptrOther.val;
        ptrOther.val = ptrK.val;
        ptrK.val = temp;
        return head;
    }
}
