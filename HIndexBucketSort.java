// TC: O(n)
// SC: O(n)

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for(int c : citations) {
            if(c >= n) {
                bucket[n]++;
            } else {
                bucket[c]++;
            }
        }
        int i, h = 0;

        for(i = n; i >= 0; i--) {
            h += bucket[i];
            if(h >= i) {
                break;
            }
        }
        return i;
    }
}