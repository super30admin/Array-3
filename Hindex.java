// TC: O(n)
// SC: O(n)

// Approach: H-index can never be more than n; So, any citation > n is treated the same.
// Create buckets and start from the back as we need to find the max h index. At any h-index,
// if number of citations >= h-index, that is our answer.

class Hindex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];

        for (int cit : citations) {
            if (cit >= n) {
                buckets[n] += 1;
            } else {
                buckets[cit] += 1;
            }
        }

        int currentCitations = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            currentCitations += buckets[i];
            if (currentCitations >= i) {
                return i;
            }
        }

        throw new IllegalArgumentException("Invalid input");
    }
}