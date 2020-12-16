// Time complexity:O(n)
//Space complexity:O(n)

class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int sum=0;
        int bucket[]=new int[n+1];
        //bucketsort
        for(int i=0;i<n;i++)
        {
            if(citations[i]>n)
            {
                bucket[n]++;
            }
            else
            {
                bucket[citations[i]]++;
            }
        }
        for(int i=n;i>=0;i--)
        {
            sum+=bucket[i];
            if(sum>=i) return i;
            
        }
        return 64; 
    }
}
