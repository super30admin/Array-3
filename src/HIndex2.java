/*
Problem -  H-Index (Bucket Counting) — LeetCode 274 style solution.
Approach - We count how many papers have exactly i citations using a bucket array.
If a paper has more than n citations, we treat it as n because H-index can't exceed total papers.
We go backward from n to 0, and the first index where cumulative count sum ≥ i, that's the H-index.
TimeComplexity - O(n)
Space Complexity - O(n) — Extra array of size n+1.
 */

public class HIndex2 {
    public int hIndex(int[] citations) {
        // Edge case: no papers -> h-index 0
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        // buckets[i] counts how many papers have exactly i citations (i <= n-1)
        // buckets[n] counts how many papers have citations >= n
        int [] buckets = new int[n + 1];
        for (int ele : citations) {
            if(ele > n){
                buckets[n] ++; // cap anything above n into the last bucket
            }
            else{
                buckets[ele]++; // count exact citation number
            }
        }
        int ans = 0;
        // Traverse from high to low to find the maximum h
        for (int i = n; i >= 0; i--) {
            ans += buckets[i];  // counts papers with citations >= i
            if(ans >= i) return i;//i is the largest h satisfying the condition
        }
        return ans;
    }
}
