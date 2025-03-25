// Time complexity:- O(n log n) due to the sorting step
// Space complexity:- O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Approach:
 * First, I sort the citations array in ascending order to make it easier to find the h-index.
 * Then, I iterate through the sorted array, and for each element, I calculate the difference 
 * between the total number of papers ('n') and the current index ('i').  If this difference 
 * ('n - i') is less than or equal to the number of citations at the current index ('citations[i]'),
 * I return the difference as the h-index, which is the maximum number of papers that have at least h citations.
 */ 
class Solution {
    public int hIndex(int[] citations) {
        // Sort the citations array in ascending order
        Arrays.sort(citations);
        int n = citations.length;

        // Iterate through the sorted citations array
        for(int i = 0; i < n; i++) {
            // Calculate the difference between the total papers and the current index
            int diff = n - i;
            // If the number of citations is greater than or equal to the difference, return the difference
            if(diff <= citations[i]) {
                return diff;
            }
        }
        // Return 0 if no valid h-index is found
        return 0;
    }
}