/*
 * Time Complexity (TC)
Sorting the citations array takes O(n log n).
The subsequent loop runs in O(n).
Overall, TC = O(n log n) + O(n) = O(n log n).

Space Complexity (SC)
The algorithm sorts the array in place and uses only a few extra variables.
SC = O(1) (constant space).

The algorithm sorts the citations array in ascending order.
It then iterates through the array, checking for the highest h-index by comparing the number of remaining papers (n - i) with the citation count at index i.
As soon as it finds an index where n - i is less than or equal to citations[i], it returns n - i, otherwise, it returns 0.
 */


 class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i ++) {
            int diff = n - i;
            if (diff <= citations[i]) {
                return diff;
            }
        }
        return 0;
    }
}