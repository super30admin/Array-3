// Time Complexity :O(n)= length of array
// Space Complexity :O(n)= length of res array(extra)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    //bucket sort method
    public int hIndex(int[] citations) {
        if(citations.length==0||citations==null)
            return 0;
        int n=citations.length;
        //h index can range from 0 to n, we need 0 index and nth index
        int [] res= new int[n+1];
        
        for(int i=0;i<citations.length;i++){
            if(citations[i]>n)
            res[n]++;
            else
            res[citations[i]]++;
        }
        int sum=0;
        for(int i=res.length-1;i>=0;i--){
            sum+=res[i];
            if(sum>=i)
                return i;
        }
        return 0;
    }
}