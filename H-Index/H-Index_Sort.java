/* Time Complexity : O(n logn)) 
 *  n - len of array - citations */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for(int i = 0; i < n; i++){
            int diff = n - i;
            //If diff is equal to value or if there is a flip/switch ie., diff less than value - we have our h-index
            if(diff <= citations[i]){
                return diff;
            }
        }
        return 0;
    }
}