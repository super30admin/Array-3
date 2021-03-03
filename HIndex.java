import java.util.Arrays;
// Time Complexity :O(nlogn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class HIndex {
    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length, i;
            Arrays.sort(citations);//sort citations value

            for (i = 1; i <= n; ++i) {
                if(citations[n-i] < i) break;//iterate over sorted array and break when condtiaion is met
            }
            return i-1;//return the h index
        }
    }
}
