// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0)
            return 0;
        int n = citations.length;
        int [] count = new int[n+1];
        int sum = 0;
        for(int i =0;i<n;i++){
            if(citations[i]>n)
                count[n]++;
            else
                count[citations[i]]++;
        }
        for(int i=n;i>=0;i--){
            sum += count[i];
            if(sum>=i)
                return i;
        }
        return 0;
    }
}