class Hindex2 {
  
    /*
      Brut force 
      Time : O(N log N) | sort and then find H index.
      Space : O(1) | Assuming sorting is in place
    */
    
   // Sort array then find H index, same as H index 2 problem
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < n; i++){
            int diff = n - i;
            if(diff <= citations[i] ){
                return diff;
            }
        }
    
        return 0;
    }
  
  
   /*
      Time : O(N)  
      Space : O(N)
      Leetcode : YES
   */
  
  /*
    Approach : Bucket sort
    1. we don't care how many citations author has beyond given N,
    2. Count all of citations >= n in one bucket.
    3. iterative from back on buckets array and as sum >= i return i
  */
   public int hIndex(int[] citations) {
        if(citations == null) return 0;
        int n = citations.length;
        
        int[] buckets = new int[n + 1];
        
        for(int i = 0; i < n; i++){
            if(citations[i] >= n){
                buckets[n]++;
            }else{
               buckets[citations[i]]++; 
            }
            
        }
        
        int sum = 0;
        for(int i = n; i>=0 ; i--){
            sum += buckets[i];
            if(sum >= i){
                return i;
            }
        }
    
        return 0;
    }
} 
