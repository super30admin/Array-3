class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int [] bucket = new int [n + 1];
        
        //filling the buckets array
        for(int i = 0; i < n; i++){
            int k = citations[i];
            if(citations[i] >= n){
                bucket[n] += 1;
            }else{
                bucket[k] += 1;
            }
        }
        int sum = 0;
        //iterating from last
        for(int i = n; i >=0; i--){
            sum += bucket[i];
            //untill sum is equal or crosses the index value 
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }
}
