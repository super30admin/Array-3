// Time Complexity : O(n), n = length of array citations
// Space Complexity : O(n), n = length of array citations
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        
        int n = citations.length;
        int[] bucketList = new int[n+1];
        
        for(int i=0; i<n; i++) {
            if(citations[i] >= n)
                bucketList[n]++;
            else
                bucketList[citations[i]]++;
        }
        int papers = 0;
        for(int i=n; i>=0; i--) {
            papers += bucketList[i];
            if(papers >= i)
                return i;
        }
        return 0;
    }
}