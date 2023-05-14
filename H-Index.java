/*
Time Complexity - O(nlogn)
Space Complexity - O(1)
 */
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int left = 0, right = n - 1;

        //find the first 'index' where (citations[i] >= n - i)
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // (n - mid) papers with an equal or higher citation count than citations[mid]
            if (citations[mid] == n - mid)
                return citations[mid];  // optimal result and can be returned right away
            if (citations[mid] < n - mid)
                left = mid + 1;
            else
                right = mid - 1;
        }

        // **************************** IMPORTANT **************************************************
        // We didn't find an exact match, so there's exactly (n - left) papers that have citations
        // greater than or equal to citations[left] and that is our answer
        return n - left;
        
        // Note : Left + 1 might seem to give the exact result as n - Left. But it will fail in 
        // cases like citations = [0] here left + 1 would give us 2 instead of the actual result which is 0.
    }
}
