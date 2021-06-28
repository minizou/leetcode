public class Problem821 {
    /** 821. Shortest Distance to a Character (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is s.length() [Both Methods]
     *      - Space complexity: O(n) where n is s.length() [Both Methods]
     * 2. Intuition
     *      - [Method 1] Using a pointer to record where c is, loop through the char in the string s twice:
     *          - first, loop through and record the distance from each char to the previous c;
     *          - then record the distance from each char to the latter c and input the minimum value between
     *            these two distances into the array.
     *      - [Method 2] Like Method 1, we input compare the distance at a char to its previous c and its
     *        latter c. A running counter is used instead of i - ptr to denote the distance.
     *
     * @param s - string consisting of lowercase English letters; guaranteed to contain at least one c
     * @param c - a char in s
     * @return
     */


    // Method 1. More Clear Solution (2-Pass)
    public int[] shortestToChar(String s, char c) {
        // -s.length() so that i - ptr adds properly for the first letters without a previous c
        int ptr = -s.length();
        int[] ans = new int[s.length()];

        // retrieves distance from each index to previous c
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                ptr = i;
            }
            ans[i] = i - ptr;
        }

        // retrieves distance from each index to latter c
        for (int i = ptr - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                ptr = i;
            }
            ans[i] = Math.min(ans[i], ptr - i); // ans[i] becomes min of latter and previous c
        }
        return ans;
    }

    // Method 2. Initial Solution
    public int[] shortestToChar2(String s, char c) {
        int[] ans = new int[s.length()];
        int ptr1 = 0; // points at a char in s
        int counter = 0; // counts distance from ptr1 to c
        int next = 0; // next empty slot in ans

        boolean cFound = false; // included to denote whether the first c is found; used to ensure the
        // first letters before the first c only account for the latter c

        while (ptr1 < s.length()) {
            if (s.charAt(ptr1) == c) { // ptr is a c
                while (next <= ptr1) {
                    // ans[next] is currently distance from beginning of string and not distance from the previous
                    // c when cFound == false
                    if (cFound == false) {
                        ans[next] = counter;
                    } else { // retrieves minimum distance from c
                        ans[next] = Math.min(counter,ans[next]);
                    }
                    next++;
                    counter -= 1;
                }
                cFound = true;
                counter = 0; // resets distance from c when c is found
            } else { // not c
                counter++;
                if (ans[ptr1] == 0) {
                    ans[ptr1] = counter;
                }
            }
            ptr1++;
        }
        return ans;
    }
}
