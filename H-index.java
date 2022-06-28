// Time Complexity :O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0){
            return 0;
        }
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++){
            int diff = citations.length-i;
            if(citations[i]>=diff){
                return diff;
            }
        }
        return 0;
    }
}