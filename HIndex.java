// Time Complexity: O(nlogn)
// Space Complexity: O(1)
class Solution {
    public int hIndex(int[] citations) {
        int i = 0, n = citations.length;
        Arrays.sort(citations);
        while(i < n && citations[n - 1 - i] > i) {
            i++;
        }
        return i;
    }
}