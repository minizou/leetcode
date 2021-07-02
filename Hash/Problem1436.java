public class Problem1436 {
    /** 1436. Destination City (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the number of lists in paths
     *      - Space complexity: O(n) where n is the number of lists in paths
     * 2. Intuition
     *      - We want to find the set difference between the set comprising of the first city in each list in paths
     *        and the set comprising of the second city in each list in paths. The one different city will be the
     *        only city without an existing outward direction path.
     *      - First, add the first city in each list into the HashSet.
     *      - Then check if any last cities in each list are in that set. If not, then there that
     *        means that destination city is never a starting city and is thus a city without any path outgoing
     *        to another city. Return this city.
     * 3. Alternative Approaches
     *      - Use a HashMap instead of a HashSet.
     *
     * @param paths - array where paths[i] = [cityA, cityB] means a direct path exists going from cityA to cityB
     * @return the destination city, that is, the city without any path outgoing to another city
     */

    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<String>();
        for (List<String> list : paths) { // adding first cities in
            set.add(list.get(0));
        }
        for (List<String> list : paths) { // checking if last cities are not in hashset
            if (!set.contains(list.get(1))) { // destination city found
                return list.get(1);
            }
        }
        return "Destination not found";
    }
}
