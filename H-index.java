// O(n log n) time: O(n log n) for sorting function, O(n) linear search (even if we did binary search, would not change time complexity)
// O(1) space

class Solution {
    public int hIndex(int[] citations) {
        // sorting citations in ascending order
        Arrays.sort(citations);
        
        // finding h-index by linear search
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i){ // start with last index - go in order of descending
            i++;
        }
        return i; // after while loop, i already incremented by 1 more.        
    }
}