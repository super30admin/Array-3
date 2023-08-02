
// Time Complexity : O(nlog(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations.length - i <= citations[i]) {
                return citations.length - i;
            }
        }
        return 0;
    }
}
