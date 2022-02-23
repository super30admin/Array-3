//tc: O(n)
//sc: O(n)

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int sum = 0, len = citations.length;
        int[] buckets = new int[len+1];
        
        for(int i=0; i< len; i++){
            if(citations[i] < len){
                buckets[citations[i]]++;
            } else{
                buckets[len]++;
            }
        }
        
        for(int i=buckets.length-1; i>=0; i--){
            sum += buckets[i];
            if(sum >= i){
                return i;
            }
        }
        return sum;
    }
}