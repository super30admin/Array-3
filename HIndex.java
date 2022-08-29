// 0(n)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length==0)
        {
            return 0;
        }
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int i=0;i<n;i++)
        {
            if(citations[i]>n)
            {
                buckets[n]++;
            }
            else
            {
                buckets[citations[i]]++;
            }
        }
        int ruuning_sum=0;
        for(int i=n;i>=0;i--)
        {
            ruuning_sum+=buckets[i];
            if(ruuning_sum>=i)
            {
                return i;
            }
        }
        return 0;
    }
}