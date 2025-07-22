// Time Complexity : O(nlogn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Approach : Sort all citations. for current citation to be h-index, there must be minimum citations[i] papers
/// Which means in sorted array there must be atleast citations[i] elements greater than it next to it so just check the 
/// number of elements to be right with current citation value if >= return current citation

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for(int i=0;i<n;i++){
            if(n-i<=citations[i]){
                return n-i;
            }
        }
        return citations[0];
    }
}