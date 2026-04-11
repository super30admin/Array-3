// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We take a papers array to keep track of i number of citations as we have a max cap of n number of citations.
Now, we want to check if there are atleast k citations(accumulated from the right) and use s to compute
the running count of papers. The point where s>=k, we get our h-index meaning there are atleast k citations.
 */
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];

        for(int citation : citations) {
            papers[Math.min(citation, n)]++;
        }

        int k = n;
        for(int s = papers[n] ; k > s ; s += papers[k]) {
            k--;
        }
        return k;
    }
}