//Time complexity=O(n)
//Space complexity=O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Instead of using the normal sorting we are using the bucket sort, that take O(N) time instead of O(N log N).
//In bucket sort, we are creating an array of length n+1 and are incrementing the count of the index in bucket array, at the plane where index is the value in citation array, and if the value in citation array is greater than size of array than we are incrementing the last element of the array only.
//After the array is created we are adding all the values of the array from backward and are seeing if the sum in greater or equal to the index, if it is then return the index
class Solution {
    public int hIndex(int[] citations) {
       
            
            
        int n=citations.length;
        int[] re=new int[n+1];
        int result=0;
        for(int i=0;i<citations.length;i++)
        {
            if(citations[i]>=n)
            {
                re[n]++;
            }
            else
            {
                re[citations[i]]++;
            }
        }
        for(int i=n;i>0;i--)
        {
            result+=re[i];
            if(result>=i)
                return i;
        }
        return 0;
    }
}