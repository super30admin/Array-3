// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// followed from class

class Solution {
    public int hIndex(int[] citations) {
        
        //keep count for citation number
        int[] map = new int[citations.length + 1];
        int n = citations.length;

        //clip citations
        for (int i = 0; i < n; i++) {
            map[Math.min(n, citations[i])]++; 
        }

        int total = 0;
        for (int i = n; i >= 1; i--) {
            //if paper count >= citation return citation number
            if (map[i] + total >= i)
                return Math.min(i, map[i] + total);
            total += map[i];
        }
        return 0;
    }
} 
