// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int hIndex(int[] citations) {
        // Create a count array to store the frequency of citations
        // The size of the count array is citations.length + 1 to handle the case where a citation count exceeds the array length
        int[] count = new int[citations.length + 1];
        int n = count.length;

        // Count the number of papers with a certain number of citations
        for (int i : citations) {
            if (i >= n) {
                // If the citation count is greater than or equal to n (number of papers),
                // Increment the count at the last index
                count[n - 1]++;
            } else {
                // Otherwise, increment the count at the index equal to the citation count
                count[i]++;
            }
        }

        int temp = 0;  // Temporary variable to accumulate the number of papers with at least 'i' citations
        
        // Traverse the count array from the end to the beginning to find the h-index
        for (int i = n - 1; i >= 0; i--) {
            temp += count[i];  // Accumulate the count of papers with citations >= i
            if (temp >= i) {   // If the accumulated count is greater than or equal to 'i'
                return i;      // 'i' is the h-index, return it
            }
        }

        // If no valid h-index is found, return 1
        return 1;
    }
}
