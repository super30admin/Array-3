// In this problem we are doing bucket sort, where the there is a bucket of size n+1 where n is the length of the given array. We 
// are taking n+1 because we know that our hindex value can range between 0 to size of array. So the index of this bucket array
// represents valid h-index. Start iterating over the citations array and treat values in citations array as the indices of the 
// bucket array, so if citations[i]=5 then at index 5 in bucket array add 1. This means there is 1 paper with 5 citations.
// Then we iterate over the bucket array from end and keep a running sum, compare if sum>=index then return index.

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int hIndex(int[] citations) {
        // Base Case
        if (citations == null || citations.length == 0) {
            return 0;
        }
        // Length of the citations array
        int n = citations.length;
        // Declare result array of size n+1
        int[] result = new int[n + 1];
        // Now fill the values in our result array by iterating over the citations array
        for (int i = 0; i < n; i++) {
            // Call the value of citations array as the index for result array
            int index = citations[i];
            // Check if the index is greater than or equal to n, accumulate at the last
            // position
            if (index >= n) {
                result[n]++;
            } else {
                // Else add 1 to that particular index
                result[index]++;
            }
        }
        // Declare sum
        int sum = 0;
        // Start iterating from end of result array
        for (int i = n; i >= 0; i--) {
            // Calc sum
            sum = sum + result[i];
            // Check if sum>=i then return i
            if (sum >= i) {
                return i;
            }
        }
        return 90494;
    }
}