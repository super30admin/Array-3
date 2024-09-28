// Time Complexity : O(nlgn) where n is the length of the citations array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class hIndex_SortedArray {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        if (citations.length == 0) return 0;
        int n = citations.length;
        int val = 0, numElements = 0;
        for (int i = 0; i < n; i++) {
            val = citations[i];
            numElements = n - i;
            if (val >= numElements) {
                return numElements;
            }
        }
        return 0;   
    }
}