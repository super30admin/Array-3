// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int hIndex(int[] citations) {
        
        int n = citations.length+1;
        int[] count = new int[n];
        
        for(int c : citations) {
            c = c>=n?n-1:c;
            count[c]++;
        }
        
        int greater = 0;
        for(int i=n-1;i>=0;i--) {
            greater+=count[i];
            if(greater>=i) return i;
        }
        return 0;
    }
}
