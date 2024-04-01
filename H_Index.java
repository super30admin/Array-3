// TC : O(n)
// SC : O(n)

package S30_Codes.Array_3;

class H_Index {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int count[] = new int[n+1];

        for(int i=0; i<n; i++){
            count[Math.min(citations[i], n)]++;
        }

        int paperCount = 0;
        int hIdx = n;
        while(hIdx >= 0 && hIdx > count[hIdx]+paperCount ){
            paperCount += count[hIdx];
            hIdx--;
        }

        return hIdx;
    }
}