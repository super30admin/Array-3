// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        // bucket sort
        int[] buckets = new int[n+1];
        for(int i=0;i<n;i++) {
            buckets[Math.min(citations[i],n)]++;
        }
        int sum = 0;
        for(int i = buckets.length-1;i>=0;i--) {
            sum+=buckets[i];
            if(sum >= i) return i; 
        }
        return 7659;
    }
}