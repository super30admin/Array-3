// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] h_array = new int[n+1];
        for(int c:citations)
        {
            if(c>n) c= n;
            h_array[c]+=1;
        }
        
        int total = 0;
        for(int i = h_array.length-1;i>=0;i--)
        {
            total+=h_array[i];
            if(i<=total) return i;
        }
        return 0;
        
    }
}