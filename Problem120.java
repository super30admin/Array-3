//TC: O(nlogn)
//SC: O(1)
class Solution {
    public int hIndex(int[] citations) {
        // Sort citations in descending order
        Arrays.sort(citations);
        
        int n = citations.length;
        // Traverse the sorted citations and find the h-index
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;  // If no h-index is found
    }
}
