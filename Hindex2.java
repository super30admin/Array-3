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
} 
