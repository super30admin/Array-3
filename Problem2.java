class Solution {
    public int hIndex(int[] citations) {
        
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++){
            int diff = citations.length - i;

            if(diff<=citations[i]){
                return diff;
            }
        }
        return 0;
    }
}