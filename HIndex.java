// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class HIndex {
    class Solution {// 0 1 3 5 6
        public int hIndex(int[] citations) {
            if(citations == null || citations.length == 0) return 0;
            int n = citations.length;
            int low = 0;
            int high = citations.length - 1;
            Arrays.sort(citations);
            for(int i=0; i<n; i++) {
                int noOfPapers = n - i;
                if(citations[i] >= noOfPapers)
                    return noOfPapers;
            }
            return 0;

        }
    }
}
