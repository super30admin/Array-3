
// Time Complexity: O(n)
// Space Complexity: O(n)


// Create a bucket array of size n+1 to count how many papers have each citation count.
// If a paper has >= n citations, put it in bucket[n] (since h-index cannot exceed n).
// Traverse buckets from high to low, keeping a running total of papers.
// The first index i where the running total >= i is the h-index. If no such i exists, return 0.

class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int bucket[]=new int[n+1];

        for(int i=0;i<n;i++){
            if(citations[i]>=n)
                bucket[n]++;
            else
                bucket[citations[i]]++;
        }
        int sum=0;
        for(int i=n;i>=0;i--){
            sum+=bucket[i];
            if(sum>=i)
                return i;
        }
        return 0;
    }
}