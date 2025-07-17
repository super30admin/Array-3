// Time complexity - O(nlogn)
// Space complexity - O(1)
// Solved on leetcode - Yes
// faced any issues - No
// Sort the elements and then do binaryu serach if the elemnet is greater or equal to number of elements towards right
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int left = 0, right = n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int h = n - mid;
            
            if (citations[mid] == h) {
                return h;
            } else if (citations[mid] < h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return n - left;
    }
}
