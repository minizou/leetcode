public class Problem1678 {
    /**
     * 1678. Goal Parser Interpretation (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is command.length()
     *      - Space complexity: O(n) where n is the total number of alphabet chars ("G", "()", and "(al)")
     * 2. Intuition
     *      - Loop through the char in command, concatenating the interpreted strings using a switch statemen
     *        for the three possible cases.
     * 3. Alternative Approaches
     *      - Use StringBuilder instead of String for the solution
     *
     * @param command - a string consisting of only "G", "()" and/or "(al)" in some order.
     * @return the interpreted string of command where "G" is interpreted as the string "G",
     * "()" is interpreted as "o", and "(al)" is interpreted as "al".
     */

    public String interpret(String command) {
        String solution = "";
        for (int i = 0; i < command.length(); i++) {
            switch(command.charAt(i)) {
                case 'G':
                    solution += "G";
                    break;
                case '(':
                    if (command.charAt(i+1) == ')') { // case of "()"
                        solution += "o";
                        i += 1; // skips iterating through )
                    } else { // case of "(al)"
                        solution += "al";
                        i += 3; // skips iterating through a, l, and )
                    }
            }
        }
        return solution;
    }
}
