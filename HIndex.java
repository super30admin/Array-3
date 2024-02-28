// Time Complexity :O(nlogn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yess
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach: Sort the array and traverse
class Solution {
    public int hIndex(int[] citations) {
        int result = 0;
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                result = n - i;
                break;
            }
        }
        return result;
    }
}