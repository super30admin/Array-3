class Solution {
	//Approach: 1. We do bucket sort here, so create bucket of length of the citations array and start populating elements in it, the citations which are more than the length of the citatiosn array are kept in a bucket of size n.
	//2. Next from right we keep adding the number of papers we got and if anywhere the sum is greater than or equal to the number of papers we return it as h index.
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int[] bucket = new int[n+1];
        for(int i=0;i < citations.length;i++)
        {
            if(citations[i] >= n)
                bucket[n]++;
            else
                bucket[citations[i]]++;
        }
        int sum = 0;
        for(int i = n; i >= 0; i--)
        {
            sum += bucket[i];
            if(sum >= i)
                return i;
        }
        return 0;
    }
}
//Time Complexity : O(n)
//Space Complexity : O(n) for bucket where n is the length of array
//Did this code successfully run on Leetcode :
//Any problem you faced while coding this :