// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// create a bucket of citations.length + 1, and if the value of sitation is grater then the bucket lenght then add it to the last index else increase count. at the end when traversing the bucket from the end, if sum value from the end is equal to or grater its index then the index is the result.
// Your code here along with comments explaining your approach
// bucket sort
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int [] bucket = new int [n+1];
        for(int i = 0; i < n; i++){
            if(citations[i]>n-1){
                bucket[n]++;
            }else{
                bucket[citations[i]]++;
            }
        }
        int sum = 0;
        for(int i = bucket.length-1; i >=0; i--){
            sum += bucket[i];
            if(sum >= i) return i;
        }
        return 0;
    }
}

// // using sorting
// class Solution {
//     public int hIndex(int[] citations) {
//         if(citations == null || citations.length == 0) return 0;
//         Arrays.sort(citations);
//         int n = citations.length;
//         for(int i = 0; i < n; i++){
//             if(citations[i] >= n-i){
//                 return n-i;
//             }
//         }
//         return 0;
//     }
// }
