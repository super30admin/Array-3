/* Time Complexity : O(n)) 
 *  n - len of array - citations */
/* Space Complexity : O(n) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        //Bucket sort
        int[] buckets = new int[n+1];
        for(int i = 0; i < n; i++){
            if(citations[i] >= n){
                buckets[n]++;
            }else{
                buckets[citations[i]]++;
            }
        }

        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum += buckets[i];
            //If sum is equal to idx or if there is a flip/switch ie., sum is greater than idx - we have our h-index
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }
}