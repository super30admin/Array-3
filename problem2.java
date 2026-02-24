   /**
    Time Complexity : O(N log N)
    Explanation:
    Sorting the citations array takes O(N log N).
    After sorting, a single linear scan is performed.

    Space Complexity : O(1)
    Explanation:
    Sorting is done in-place without using extra space.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about how to relate index position with
    number of papers having at least that many citations.
    Later understood that after sorting:
        citations[i] >= (n - i)
    means there are (n - i) papers with at least that many citations.
    */

    class Solution {

 
        public int hIndex(int[] citations) {
    
            Arrays.sort(citations);
    
            int result = 0;
            int n = citations.length;
    
            for (int i = 0; i < n; i++) {
                int papers = n - i;
    
                if (citations[i] >= papers) {
                    result++;
                }
            }
    
            return result;
        }
    }