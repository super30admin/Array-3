// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length == 0 ) return 0;
        int n = citations.length;
        int[] bucket = new int[n+1];
        for(int c : citations){
            if(c>n) c=n;
            bucket[c]++;
        }
        int rsum = 0;
        int index = bucket.length-1;
        while(true){
            rsum+=bucket[index];
            if(index<=rsum) break;
            index--;
        }
        return index;
    }
}