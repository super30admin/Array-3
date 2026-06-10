// Time Complexity : O(n) because we count citations and scan the buckets once
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use bucket counting where bucket[i] stores the number of papers with exactly i citations.
// All citation counts greater than n are placed into bucket[n] because H-index cannot exceed n.
// Scanning buckets from high to low gives the number of papers with at least h citations, allowing us to find the largest valid H-index.

class Solution {
    public int hIndex(int[] citations) {

        int n = citations.length;
        int[] buckets = new int[n + 1];

        // build citation frequency buckets
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }

        int papers = 0;

        // count papers with at least h citations
        for(int h = n; h >= 0; h--) {
            papers += buckets[h];

            if(papers >= h) {
                return h;
            }
        }

        return 0;
    }
}