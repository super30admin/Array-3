//https://leetcode.com/problems/h-index/
// Time Complexity :O(n)  
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] bucket=new int[n+1];
        for(int citation:citations) 
        {
            if(citation>n)
                bucket[n]+=1;
            else
                bucket[citation]+=1;
                
        }
        int sum=0;
        for(int i=n;i>=0;i--) //here index gives the number of papers
        {
            sum+=bucket[i];
            if(sum>=i)
                return i;
        }
        
        return 0;       
    }
}