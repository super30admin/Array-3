// Time Complexity : O(n + nlog(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {
        //Sort the array
        Arrays.sort(citations);
        //Get to the point where number of papers on right is equal to or less than citaions
        for(int i=citations.length; i>0; i--){
            if(i <= citations[citations.length-i]) return i;
        }
        return 0;
    }
}