// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {
        //base case
        if(citations == null || citations.length == 0)
            return 0;
        
        int n=citations.length;
        int[] bucket=new int[n+1];
        
        for(int c : citations)
        {
            if(c > n)
                c=n;
            bucket[c]++;
        }
        
        int rSum=0;
        int k=n;
        while(k>=0)
        {
            rSum+=bucket[k];
            if(rSum >= k)
                break;
            k--;
        }
        return k;
    }
}
