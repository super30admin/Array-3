// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced problem in figuring out the index calculation.

class HIndex {
    public int hIndex(int[] citations) {
       Arrays.sort(citations);
        int N = citations.length;
        int i = 0;
        for(; i < N; i++){
            if(citations[citations.length-i-1] > i){continue;}
            else{break;}
        }
        return i;
    }
}