//Time complexity: O(n)
//Space complexity: O(n)
class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
       int bucket[]=new int[n+1];
        
        for(int i=0;i<n;i++)
        {
           if(citations[i] < n)
           {
               bucket[citations[i]]++;
           }
            else
            {
                bucket[n]++;
            }
        }
        int sum=0;
        for(int i=n;i>=0;i--)
        {
           sum+=bucket[i]; 
            if(sum>=i)
            {
                return i;
            }
        }
        return 0;
    }
}

