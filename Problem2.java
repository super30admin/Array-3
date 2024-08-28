//Time = O(n)
//Space = O(n)

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        
        // Count the number of papers with i citations
        for (int citation : citations) {
            if (citation >= n) {
                // If the citation count is greater than or equal to n,
                // increment the count of papers with n citations.
                count[n]++;
            } else {
                // Otherwise, increment the count of papers with the
                // corresponding citation count.
                count[citation]++;
            }
        }
        
        // Compute the H-Index
        int total = 0;
        for (int i = n; i >= 0; i--) {
            // Add the count of papers with i citations to the total.
            total += count[i];
            
            // Check if we have found the H-Index.
            if (total >= i) {
                // If the total count of papers with at least i citations
                // is greater than or equal to i, then i is the H-Index.
                return i;
            }
        }
        
        // If we have not found the H-Index, return 0.
        return 0;
    }
}
