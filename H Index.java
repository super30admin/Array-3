// Time Complexity = O(1)
// Space Complexity = O(n)

class Solution {
    public int hIndex(int[] citations) {
        int total = 0;
        
        int n = citations.length;
        int [] buckets = new int [n+1];
        
        for(int i = 0; i < n; i ++){
            if(citations[i] >= n){
                buckets[n]++;
            }else{
                int idx = citations[i];
                buckets[idx] ++; 
            }
        }
        
        for(int i = n; i >= 0; i--){
            total += buckets[i];
            if(total>=i){
                return i;
            }
        }
        return 0;
    }
}

