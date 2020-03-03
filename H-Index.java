//Time Complexity : O(N Log N) for Linear Search Approach 
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
*/

public class Solution {
    public int hIndex(int[] citations) {
        // sorting the citations in ascending order
        Arrays.sort(citations);
        int idx = 0, n = citations.length;
    for(int c : citations) {
      if (c >= n - idx) return n - idx;
      else idx++;
    }
    return 0;
    }
}
