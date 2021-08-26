// Time Complexity :o(N)
// Space Complexity : o(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int hIndex(int[] citations) {
        
        if(citations==null)
            return 0;
        int n=citations.length;
        
        int[] buckets=new int[n+1];
        
        //distribute elements into buckets
        for(int i=0;i<n;i++)
        {
            if(citations[i]>=n)
            {
                buckets[n]++;
            }
            else
            {
                buckets[citations[i]]++;
            }
        }
        
        int papers=0;
        for(int i=n;i>=0;i--)
        {
            papers+=buckets[i];
            
            if(papers>=i)
                return i;
        }
        return 0;
    }
}