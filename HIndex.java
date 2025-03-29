// Time Complexity: O(n) where n is the length of the citations array
// Space Complexity: O(n) where n is the length of the citations array

class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];

        for(int i = 0; i < n; i++){
            if(citations[i] >= n){
                buckets[n]++;
            }else{
                buckets[citations[i]]++;
            }
        }

        int count = 0;
        for(int i = n; i >= 0; i--){
            count +=  buckets[i];

            if(count >= i){
                return i;
            }
        }
        return 0;
    }
}
