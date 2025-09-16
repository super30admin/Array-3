// H index 2 problem will be the citations are in sorted order so easily traverse and find put but here it is in different order. If sorting then TC is nlogn so do without sorting.
class Solution {
    public int hIndex(int[] citations) {

        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int[] freq = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            if (citations[i] >= n) {
                freq[n]++;
            } else {
                freq[citations[i]]++;
            }
            
        }

        int sum = 0;
        for (int i = n; i >= 0; --i) {
            sum += freq[i];
            if (sum >= i) {
                return i;
            }
        }

        return 0;
    }
}