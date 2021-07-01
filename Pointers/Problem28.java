public class Problem28 {
    /** 28. Implement strStr() (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(m * n) where m is haystack.length() and n is needle.length() [Method 1 & 3 & 4]
     *                         O(m + n) where m is haystack.length() and n is needle.length() [Method 2]
     *      - Space complexity: O(1) [Method 1 & 3 & 4]
     *                          O(m + n) where where m is haystack.length() and n is needle.length() [Method 2]*
     * 2. Intuition
     *      - [Method 1] Use the built-in strSt() method.
     *
     *      - [Method 2] Using the KMP algorithm, first create char arrays of the haystack, the needle, and another
     *        array for the indices of the needle. Iterate through the char of needle and note where patterns
     *        repeat in the needle using two pointers in the array. For example:
     *
     *              - In the pattern [a   b a b  c  d], a b repeats twice. In the array, this would be:
     *                               [-1 -1 0 1 -1 -1]  where the number at each index indicates the index to return
     *                                                  to given that it appears earlier in the pattern (-1 means
     *                                                  start from the beginning; note how the second a has a 0,
     *                                                  meaning return to index 0--the location of the first array).
     *
     *      - Now, when iterating through haystack and finding some char matches, if it turns out the string does
     *        not completely match, return the pointer iterating through needle to the previous instance of a char
     *        index if it has already appeared in the needle pattern before.
     *              - In the example pattern above, this would mean that when the pointer reaches index 3 in abcbcd
     *                WITHOUT a match for index 3, the pointer would return to index 1--the previous b in the pattern.
     *              - Note that in this process, the pointer iterating through the haystack never moves backward.
     *                Only the needle pointer does.
     *
     *      - [Method 3] Check every substring of haystack that has the same length as needle.length.
     *      - [Method 4] Loop through each char in haystack. If it matches with the first char of needle, loop
     *        through both needle and the haystack to see if they match. If not, continue looping through each
     *        char in haystack.
     * 3. Alternative Approaches
     *      - Implement the Rabin-Karp String Matching Algorithm instead.
     *
     * @param haystack - string consisting of only lower-case English characters
     * @param needle - string consisting of only lower-case English characters
     * @return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     */

    // Method 1. Built In Method
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // Method 2. KMP Algorithm
    public int strStr2(String haystack, String needle) {
        if (haystack.equals(needle) || needle.equals("")) { // edge cases
            return 0;
        } else if (needle.length() > haystack.length() || haystack.length() == 0) {
            return -1;
        }

        char[] arrNeedle = needle.toCharArray(); // needle as an array
        char[] arrHay = haystack.toCharArray(); // haystack as an array
        int[] needleIndices = new int[arrNeedle.length];

        needleIndices[0] = -1; //
        int ptr = -1;

        // putting patterns within needle into needleIndices (ex: mapping ababcd into -1 -1 0 1 -1 -1)
        for (int i = 1; i < arrNeedle.length; i++) {
            while (ptr > -1 && arrNeedle[ptr + 1] != arrNeedle[i]) {
                ptr = needleIndices[ptr];
            }
            if (arrNeedle[ptr + 1] == arrNeedle[i]) {
                ptr++;
            }
            needleIndices[i] = ptr;
        }

        ptr = -1;
        for (int i = 0; i < arrHay.length; i++) {
            while (ptr > -1 && arrNeedle[ptr + 1] != arrHay[i]) { // returning to last pattern location
                ptr = needleIndices[ptr];
            }
            if (arrNeedle[ptr + 1] == arrHay[i]) { // char match found
                ptr++;
                if (ptr == arrNeedle.length - 1) { // needle match found found
                    return i - ptr;
                }
            }
        }
        return -1;
    }

    // Method 3. Built-In Method Searching for Needle Using Substring
    public int strStr3(String haystack, String needle) {
        if (haystack.equals(needle) || needle.equals("")) { // edge cases
            return 0;
        }

        // checking every possible substring with needle length in haystack for index
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++)
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }

        return -1; // needle not found
    }

    // Method 4. Initial Solution
    public int strStr4(String haystack, String needle) {
        if (needle.equals("")) { // edge cases
            return 0;
        } else if (needle.length() > haystack.length()) { return -1; }

        int ptrHay = 0;
        int ptrNeedle = 0;

        while (ptrNeedle < needle.length() && ptrHay < haystack.length()) {
            if (haystack.charAt(ptrHay) == needle.charAt(ptrNeedle)) { // first letter matches
                int index = ptrHay;
                while (ptrNeedle < needle.length() && ptrHay < haystack.length()) { // check if needle is found
                    if (haystack.charAt(ptrHay) != needle.charAt(ptrNeedle)) { // needle NOT found
                        ptrHay = index + 1;
                        ptrNeedle = 0;
                        break;
                    } else {
                        ptrNeedle++;
                        ptrHay++;
                    }
                }
                if (ptrNeedle == needle.length()) { // needle is found
                    return index;
                }
            }  else {
                ptrHay++;
            }
        }
        return -1; // needle not found
    }

    public static void main(String[] args) {
        Problem28 test = new Problem28();
        test.strStr2("ababababcd","ababcd");
    }
}
