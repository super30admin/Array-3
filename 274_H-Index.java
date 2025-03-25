// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {

    // Time Complexity : O(nlogn) + O(n) = O(nlogn)
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for(int i = 0; i < n ; i++){
            int diff = n - i;
            if(diff <= citations[i]){
                return diff;
            }
        }
        return 0;
    }

    //Time Complexity : O(2n) = O(n)
    // Bucket sort (linear sort we are doing)
    public int hIndex(int[] citations){
        int n = citations.length;
        int [] buckets = new int[n+1];
        for(int i = 0; i <n; i++){
            if(citations[i] >= n){
                buckets[n]++;
            } else{
                buckets[citations[i]]++;
            }
        }
        int count = 0;
        for(int i =n; i >= 0; i--){
            count += buckets[i];
            if(count >= i){
                return i;
            }
        }
        return 0;
    }

}