public class Problem20 {
    /** 20. Valid Parentheses (Easy)
     *
     * 1. Complexity
     *      - Time complexity:
     *      - Space complexity:
     * 2. Intuition
     *      - [Both Methods] Using a stack, push the left brackets into the array. If a right bracket is found,
     *        consider whether the stack is empty (thus unmatched) or if the corresponding left bracket is not
     *        next to it (i.e. stack.pop() != corresponding bracket). In this case, return false.
     *      - Return true if the stack is empty.
     *
     * @param s - string containing just the characters '(', ')', '{', '}', '[' and ']'
     * @return whether the string obeys the following rules: [1] open brackets must be closed by
     * the same type of brackets, and [2] open brackets must be closed in the correct order.
     */

    public boolean isValid(String s) {

        // Method 1. Readable Variation of Method 2
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if (stack.size() == 0 || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (stack.size() == 0 || stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (stack.size() == 0 || stack.pop() != '[')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    // Method 2. Initial Stack Solution
    public boolean isValid2(String s) {
        if (s.length() % 2 != 0) { // odd num of char means there is an unmatched bracket
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default: // right bracket
                    if ((stack.isEmpty() || stack.pop() != s.charAt(i))) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}
