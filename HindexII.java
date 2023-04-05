public class HindexII {
    //TC=O(n) SC=O(1)
    public int hIndex(int[] citations) {
        int n = citations.length;
        int hindex = 0;
        for(int i=0;i<n;i++){
            if(citations[i]>=n-i){
                hindex = n-i;
                break;
            }
        }
        return hindex;

    }
}
