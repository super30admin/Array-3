//Bucket Sort
//TC:O(N)
//SC:O(N)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for (int i = 0; i < citations.length; i++){
            if (citations[i] < n){
                buckets[citations[i]]++;
            } else {
                 buckets[n]++;
            }
        }
        int sum = 0;
        for (int i = n; i>= 0; i--){
           sum = sum + buckets[i];
           if (i <= sum){
               return i;
           }
        }
        return -1;
    }
}
