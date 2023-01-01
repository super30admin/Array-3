// Time Complexity : O(n) 
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//274. H-Index

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int[] papers = new int[citations.length + 1];
        for(int i = 0; i < citations.length; i++){
            if(citations[i] > citations.length){
                papers[citations.length]++;
            }
            else{
                papers[citations[i]]++;
            }
        }
        int count = 0;
        for(int i = citations.length; i >= 0; i--){
            count = count + papers[i];
            if(count >= i){
                return i;
            }
        }
        return 0;
    }
}