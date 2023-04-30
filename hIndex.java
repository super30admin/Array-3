// TC : O(nlogn)
// SC : O(1)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        int n = citations.length;

        for(int i = 0 ; i < n ; i++)
        {
            int diff = n - i;
            if(diff <= citations[i])
                return diff;
        }

        return 0;     
    }
}




// TC : O(n)
// SC : O(1)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int[] buckets = new int[n+1];

        for(int i = 0 ; i <n; i++)
        {
            int num = citations[i];
            if(num > n)
                buckets[n]++;
            else
                buckets[num]++;
        }
        int sum = 0 ;
        for(int i = n ; i>= 0 ; i--)
        {
            sum += buckets[i];
            if(sum >= i)
                return i;
        }
        return 0;     
    }
}