//TC: O(N)
//SC:O(N)
//where N is the length of citations array.
class Solution {
    public int hIndex(int[] citations) {
        if(citations==null)
            return 0;
        int n=citations.length;
        int[] buckets = new int[n+1];
        
        //distribute the elements into buckets
        for(int i=0;i<n;i++){
            if(citations[i]>=n){
                buckets[n]++;
            }else{
                buckets[citations[i]]++;
            }
        }
        int papers = 0;
        for(int i=n;i>=0;i--){
            papers+=buckets[i];
            if(papers>=i)
                return i;
        }
        return 0;
    }
}