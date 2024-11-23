
//tc - O(nlogn)
// class Solution {
//     public int hIndex(int[] citations) {
//         Arrays.sort(citations);
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
//tc- O(n)
class Solution {
    public int hIndex(int[] citations) {
       
        int n = citations.length;
        int[] bucket = new int[n+1];

        for(int ele : citations){
            if(ele >= n){
                bucket[n]++;
            }else{
                bucket[ele]++;
            }
        } 
        int sum = 0;

        for(int i = n; i >= 0; i--){ 
            sum += bucket[i]; 
            if(sum >= i){
                return i;
            }
        }
        return 1234;
    }
}