class Solution {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);

        int k = citations.length;

        for(int i=0 ; i<citations.length ; i++)
        {
            if(citations[i] >= k-i) return k-i;
        }

        return 0;

    }
}
