class Solution {
    //Time O(N)
    //Space O(1)
    public int hIndex(int[] citations) 
    {
        if(citations == null || citations.length == 0)
        {
            return 0;
        }
        int[] ar = new int[citations.length+1];
        int n = citations.length;
        for(int i=0 ; i<n ; i++)
        {
            if(citations[i] >= n)
            {
                ar[n]++;
            }
            else
            {
                ar[citations[i]]++;
            }
        }
        int sum = 0;
        for(int i=n ; i>=0 ; i--)
        {
            sum += ar[i];
            if(sum >= i)
            {
                return i;
            }
        }
        return 0;
    }
}