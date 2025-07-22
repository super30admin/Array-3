// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES

class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int size = citations.length;
        int result = 0;

        while (result < size && citations[size - result - 1] > result)
            result++;

        return result;
    }
}