//TC - nlog(n)
//SC - O(1)

class Solution {
    int maax = 0;
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; ++i)
        {
            if(citations[i] >= citations.length - i)
                maax = Math.max(citations.length - i, maax);
        }
        
        return maax;
    }
}
