public class Problem1812 {
    /** 1812. Determine Color of a Chessboard Square (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(1)
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Take advantage of the fact that the input will always be a string of length 2.
     *      - Find the ASCII values of the number and letter in coord to find its numerical value.
     *        - If it is odd, the coord is on a black square. Return false.
     *        - If it is even, the coord is on a white square. Return true.
     *
     * @param coord - coordinate consisting of a letter and a number corresponding to a 8x8 chessboard
     * @return true if the coordinate is on a white square; false if on a black square
     */

    public boolean squareIsWhite(String coord) {
        int numValue = coord.charAt(0) - 'a' + coord.charAt(1) - '0'; // numerical value of the coord
        return (numValue % 2 == 0); // odd if black, even if white
    }
}
