/*
Time: O(N log N)
Space: O(1)

Approach:
1. Sort array
2. Now, binary search for citation count where value is equal to h
*/
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int low = 0, high = citations.length-1, n = citations.length;
        while(low <= high) {
            int mid = low +(high - low)/2;
            if(citations[mid] == n - mid) 
                return n - mid;
            else if(citations[mid] > n - mid) {
                high = mid - 1;
            }
            else 
                low = mid + 1;
        }
        return n - low;
    }
}