//Time Complexity - O(n)
//Space Complexity - O(1)
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int[] result = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int idx = citations[i];
            if (idx > n) {
                result[n] = result[n] + 1;
                continue;
            }
            result[idx] = result[idx] + 1;
        }

        int hIndex = 0;
        for (int i = n; i >= 0; i--) {
            hIndex = result[i] + hIndex;
            if (hIndex >= i) {
                return i;
            }
        }
        return 0;
    }
}
