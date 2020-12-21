// Time Complexity :  O(N log N) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int N = citations.length;
        for(int i = 0; i < N; i++){
            if(citations[i] >= N - i){
                return N - i;
            }
        }
        return 0;
    }
}