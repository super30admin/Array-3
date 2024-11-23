//the logic is h >= h ; n-h >= h

//brute forse linear approach tc- logn
// class Solution {
//     public int hIndex(int[] citations) {
//         int n = citations.length;
//         for(int i = 0; i < n; i++){ 
//             int diff = n - i;
//             if(citations[i] >= diff){
//                 return diff;
//             }
//         }
//         return 0;
//     }
// }

//binary search tc-O(logn)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int diff = n - mid;
            if(diff == citations[mid]){
                return diff;
            }else if(citations[mid] >= diff){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return n - low;
    }
}
