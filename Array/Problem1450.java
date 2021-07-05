public class Problem1450 {
    /** 1450. Number of Students Doing Homework at a Given Time (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the length of startTime and endTime
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - To determine which entries occurred during the query time, simply check the start and end time of
     *        each query. If the start time is before or equal to the query time and the end time is after or
     *        equal to it, it occurred during the query time.
     *      - Increment a counter for when this case occurs.
     *
     * @param startTime - when the ith student started doing their homework at the time startTime[i]
     * @param endTime - when the ith student finished their homework at endTime[i]
     * @param queryTime - a certain time
     * @return the number of students doing their homework at time queryTime
     */

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0; // counts students who did homework at query time
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count++;
            }
        }
        return count;
    }
}
