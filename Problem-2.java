// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {
        int[] papers = new int[citations.length+1];
        
        for(int i=0;i<citations.length;i++) {
            if(citations[i] >= citations.length) {
                papers[citations.length]++;
            } else {
                papers[citations[i]]++;
            }
        }
        int sum = 0;
        for(int i=papers.length-1;i>=0;i--) {
            sum += papers[i];
            
            if(sum>=i) {
                return i;
            } 
        }
        
        return 0;
    }
}