class Solution {
    /**
     * Sort array find breach return diff.
     * TC: O(nlogn)
     * sc: O(1)
     */

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }
}
