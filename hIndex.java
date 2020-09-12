// Time O(nlogn)
//Space O(1)

class Solution {
    public int hIndex(int[] citations) {
        /* H index basically means that we need to find a H which has atleast H citations.
        
        0<=h<=citations.length
                
        */
        if(citations==null || citations.length==0)
            return 0;
        
        Arrays.sort(citations);
        int n=citations.length;
        
        for(int i=0;i<n;i++)
            if(n-i<=citations[i])
                return n-i;
        
        return 0;
    }
}