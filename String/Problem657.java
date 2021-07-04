public class Problem657 {
    /** 657. Robot Return to Origin (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the length of moves
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - We know that the robot returns to its starting position when it has moved left and right an equal
     *        number of times and up and down an equal number of times. Keep track of two variables representing
     *        the robots horizontal difference and vertical difference.
     *      - Let moving right and up represent positive changes (+) and the other directions negative (-).
     *      - Return whether the two variables add up to zero in the end.
     * 3. Alternative Approaches
     *      - First turn moves into a char array, as it is faster than using charAt().
     *
     * @param moves - string consisting of either 'R' (right), 'L' (left), 'U' (up), or 'D' (down).
     * @return if the robot returns to the origin after it finishes all of its moves, return true; else return false
     */
    public boolean judgeCircle(String moves) {
        int horizontal = 0; // tracks horizontal difference from origin
        int vertical = 0; // tracks vertical difference from origin

        for (int i = 0; i < moves.length(); i++) {
            switch(moves.charAt(i)) {
                case 'R':
                    horizontal++;
                    break;
                case 'L':
                    horizontal--;
                    break;
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
            }
        }
        return (horizontal == 0 && vertical == 0);
    }
}
