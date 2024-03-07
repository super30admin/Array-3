// https://leetcode.com/problems/h-index/

// Bucket Sort
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    // n >= h
    // n - h <= h
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];

        for(int citation: citations) {
            if(citation > n) {
                buckets[n]++;
            } else {
                buckets[citation]++;
            }
        }

        int count = 0;

        for(int i = n; i >= 0 ; i--) {
            count += buckets[i];
            if( count >= i) {
                return i;
            }
        }

        return 0;
    }
}

