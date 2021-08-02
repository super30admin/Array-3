class Solution {

    //O(n) space and time
    public int hIndex(int[] citations) {

        int n = citations.length;
        int[] buckets = new int[n + 1];

        for (int i = 0; i<citations.length; i++) {

            if (citations[i] >= n) {
                buckets[n] += 1;
            } else {
                buckets[citations[i]] += 1;
            }

        }

        int sum = 0;
        for (int i=n; i>=0; i--) {
            sum += buckets[i];
            if (sum >= i) return i;
        }

        return -1;

    }
}