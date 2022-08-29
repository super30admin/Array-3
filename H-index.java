// class Solution {
//     public int hIndex(int[] citations) {
//         if(citations.length == 0) return 0;
        
//         Arrays.sort(citations);
//         int n = citations.length; 
//         for(int i = 0; i < citations.length; i++){
//             int diff = n - i;
//             if(citations[i] >= diff)
//             {
//                 return diff;
//             }
            
//         }
        
//         return 0;
//     }
// }

//Time Complexity: O(logn).
//Space Complexity: O(n).

class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        
        
        int n = citations.length; 
         int sum = 0;
        int[] buckets = new int[n+1];
        for(int i = 0; i < citations.length; i++){
            if(citations[i] > n){
                buckets[n]++;
            }
            else{
                 buckets[citations[i]]++;
            }
        }
        
        for(int i = n; i >= 0; i--){
           sum = sum + buckets[i];
            if(sum >= i){
                return i;
            }
        }
        
        return 0;
    }
}

