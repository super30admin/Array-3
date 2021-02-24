class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int t = citations.length;
        if(t == 0) return 0;
        if(citations[t-1]==0) return 0;
        int res;
        for(int i=t-1; i>0; i--){
            res = t - i; 
            if(citations[i] >= res && citations[i-1] <= res)
                return res;
        }
        return t;
    }
}

//Time complexity : O(NlogN) where N is the number of elements in citations array
//Space complexity : O(1)
