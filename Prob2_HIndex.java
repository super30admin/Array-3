//TC : O(n + n) ==== O(n)
//SC : O(n) // Making use of n+1 buckets 
 
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)  return 0;
        
        int[] buckets = new int[citations.length + 1];
        
        for(int i = 0; i< citations.length; i++){ //O(N) for creating buckets
            if(citations[i] < citations.length){
                buckets[citations[i]]++;
            }else{
                buckets[citations.length]++;
            }
        }
        
        int ans = 0;
        
        for(int i = citations.length; i >= 0; i--){ // O(n)
            ans += buckets[i];
            
            if(ans >= i){
                return i;
            }
        }
        
        return 0;
 
    }
}


/*

//TC : O(n*log n) //Sorting citations array
//SC : O(1)

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)  return 0;
        
        Arrays.sort(citations);
        
        int len = citations.length;
        
        for(int i = 0; i< len; i++){
            int d = len - i;
            if(d <= citations[i]){
                return d;
            }
        }
        return 0;
    }
}

*/